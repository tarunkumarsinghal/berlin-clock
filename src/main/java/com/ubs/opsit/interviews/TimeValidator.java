package com.ubs.opsit.interviews;

public interface TimeValidator {
	
	String TIME24HOURS_PATTERN = "(([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]|24:00:00)";
	
	boolean isValidTime(String aTime);
	
}
