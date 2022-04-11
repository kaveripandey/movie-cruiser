package com.cts.moviecruiser.movieportal.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cts.moviecruiser.exceptiuon.FavoriteEmptyException;
import com.cts.moviecruiser.movieportal.client.AuthClient;
import com.cts.moviecruiser.movieportal.client.FavoriteClientRest;
import com.cts.moviecruiser.movieportal.client.MovieClientRest;
import com.cts.moviecruiser.movieportal.dto.AuthenticationResponseDTO;
import com.cts.moviecruiser.movieportal.model.AuthenticationRequest;
import com.cts.moviecruiser.movieportal.model.LoginModel;
import com.cts.moviecruiser.movieportal.model.Movie;
import com.cts.moviecruiser.movieportal.model.MovieResponse;
import com.cts.moviecruiser.movieportal.service.LoginService;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MovieController {

	@Autowired
	LoginService loginService;

	@Autowired
	AuthClient authClient;

	@Autowired
	MovieClientRest clientRest;

	@Autowired
	FavoriteClientRest clientRest3;

	@Autowired
	MovieClientRest clientRest2;

	static AuthenticationResponseDTO token = null;
	static List<Movie> list;

	static String userName;
	static String myRole;

//	login Start

	@GetMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("model", new LoginModel());
		return mv;
	}

	@PostMapping("/login")
	public ModelAndView performLogin(@Valid @ModelAttribute("model") LoginModel model, BindingResult result,
			HttpServletRequest request, HttpSession session) throws FeignException {
		ModelAndView mv = new ModelAndView("login");
		System.out.println(result);

		log.info(" Before Token generation");

		try {
			token = loginService.login(model);
		} catch (Exception e) {
			log.info("Exception");
			mv.addObject("error", "Invalid Credentials");
			return mv;
		}

		request.getSession().setAttribute("token", "Bearer " + token.getJwtAuthToken());
		request.getSession().setAttribute("user", model.getUserName());

		log.info(" After Token generation");

		log.info(model.getUserName());
		log.info("Check role in LoginController: " + authClient.getRole(model.getUserName()));

		log.info(token.getJwtAuthToken());

		AuthenticationRequest authenticationrequest = authClient.getRole(model.getUserName());
		session.setAttribute("token", token.getJwtAuthToken());
		log.debug("session{}:", session.toString());
		userName = model.getUserName();
		//getRole
		myRole=authenticationrequest.getRole();
		log.info(myRole);
		if (authenticationrequest.getRole().equals("admin") && token != null) {
			log.info("Dsiplaying Admin Page");
			return new ModelAndView(new RedirectView("admin"));
		} else if (!authenticationrequest.getRole().equals("admin")&&token != null) {
			log.info("Dsiplaying User Page");
			return new ModelAndView(new RedirectView("movie-list"));
		} else {
			return new ModelAndView(new RedirectView("forbidden"));

		}
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute("token", null);
		session.setAttribute("token", "");
		token = null;
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("model", new LoginModel());
		return mv;
	}

//	Login End

	@GetMapping("/admin")
	public ModelAndView admin(ModelMap map) {
		list = clientRest.getAllMoviesAdmin();
		map.put("inf", list);
		if (token != null && myRole.equalsIgnoreCase("admin")) {
			ModelAndView mv = new ModelAndView("movie-list-admin");
			mv.addObject("model", new LoginModel());
			return mv;
		} else {
			return new ModelAndView("forbidden");
		}

	}

	@GetMapping("/movie-list")
	public ModelAndView getAllMovies(ModelMap map) {
		list = clientRest.getAllMovies();
		map.put("inf", list);
		if (token != null && !myRole.equalsIgnoreCase("admin")) {
			ModelAndView mv = new ModelAndView("movie-list-customer");
			mv.addObject("model", new LoginModel());
			return mv;
		} else {
			return new ModelAndView("forbidden");
		}

	}

	@RequestMapping(value = "/edit-menu-item-success", method = RequestMethod.POST)
	public ModelAndView successEditMovie(@ModelAttribute("editMovie") Movie movie, ModelMap model) {

		clientRest.modifyMovie(movie.getId(), movie);
		list = clientRest.getAllMoviesAdmin();

		model.put("inf", list);
		if (token != null) {
			ModelAndView mv = new ModelAndView("edit-menu-item-success");
			mv.addObject("model", new LoginModel());
			return mv;
		} else {
			return new ModelAndView("forbidden");
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView toEditMovie(@RequestParam int id, @RequestParam String title, @RequestParam String dol,
			@RequestParam String box, @RequestParam String genre, ModelMap model) throws Exception {

		DateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		String outputString = null;
		if (!dol.isEmpty()) {
			Date date = inputFormat.parse(dol);

			// Format date into output format
			DateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd");
			outputString = outputFormat.format(date);
		}
		//
		model.addAttribute("editMovie", new Movie());
		model.addAttribute("Movieid", id);
		model.addAttribute("title", title);

		model.addAttribute("dol", outputString);
		model.addAttribute("boxOffice", box);
		model.addAttribute("genre", genre);
		if (token != null) {
			ModelAndView mv = new ModelAndView("edit-menu-item");
			mv.addObject("model", new LoginModel());
			return mv;
		} else {
			return new ModelAndView("forbidden");
		}
	}

//	Favorites Start

	@RequestMapping(value = "/favorites", method = RequestMethod.GET)
	public String addedToFav(@RequestParam long id, ModelMap model) {
		String userId = userName;
		clientRest3.addFavoriteMovie(userId, id);
		return "added-to-favorites";
	}

	@RequestMapping(value = "/showfavorite", method = RequestMethod.GET)
	public String getByUId(/* @RequestParam long id */ModelMap model) throws FavoriteEmptyException {

		try {
			String userId = userName;
			model.put("inf", clientRest3.getAllFavoriteMovies(userId));
			if (token != null) {
				return "favorite";
			} else {
				return "forbidden";
			}
		} catch (Exception e) {
			model.put("inf", clientRest2.getAllMovies());
			if (token != null) {
				return "exception";
			} else {
				return "forbidden";
			}
		}

	}

	@RequestMapping(value = "deleteItem", method = RequestMethod.GET)
	public String deleteItem(@RequestParam Long id, ModelMap model) {
		clientRest3.removeFavoriteMovie(userName, id);
		List<Movie> list = null;
		return "deleted-from-favorites";

	}

//	Favorites End
//genrelist
	@ModelAttribute("genreList")
	public List<String> sourceListGenerator() {
		List<String> list = new ArrayList<String>();
		list.add("Sci-Fi");
		list.add("Action");
		list.add("Adventure");
		list.add("SuperHero");
		list.add("Comedy");
		list.add("Thriller");
		return list;
	}
}
