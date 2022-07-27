package com.IIHTSkillTracker.proj.exception;

public class profileException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public profileException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Profile with id "+id+" not found";
	}
	
	public static String NotFoundExceptionByName(String name) {
		return "No Profile matches with name "+name;
	}
	
	public static String NoMatchFoundException(String skill) {
		return "No Profile matches with skill "+skill;
	}
	
	public static String ProfileCannotBeUpdated(String id) {
		return "Time gap between each update is 10 days. Therefore, profile with ID "+id+" cannot be updated!";
	}
	
	public static String ProfileAlreadyExists() {
		return "Profile with given ID already exists";
	}
	
	public static String NotInRangeException() {
		return "Expertise level out of bound Exception | Range 0-20";
	}
	
	public static String NotInFormatException() {
		return "Expertise level should not be empty and should be number";
	}
}
