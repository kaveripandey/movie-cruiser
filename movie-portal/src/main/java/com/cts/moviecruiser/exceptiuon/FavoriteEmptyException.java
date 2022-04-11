package com.cts.moviecruiser.exceptiuon;

//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason = "Cart Empty")
public class FavoriteEmptyException extends Exception {

	public FavoriteEmptyException(String message) {
		super(message);
	}
	
}
