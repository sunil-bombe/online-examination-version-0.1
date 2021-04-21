package com.webwork.online.examination.exception;

public class UserNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	 public UserNotFoundException(String msg){
		this.msg = msg;
	}

	public String toString() {
		
		return "Exeception occured:"+ msg;
	}
}
