package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.TimeValidator;
import com.ubs.opsit.interviews.impl.TimeValidatorImpl;

public class Time {
	private TimeValidator timeValidator;
	
	private int hourValue;
	private int minuteValue;
	private int secondsValue;
	private boolean validTime;
	
	public Time(String aTime) {
		timeValidator = new TimeValidatorImpl();
		
		if(timeValidator.isValidTime(aTime)) {
			String[] time = aTime.split(":");
			
			this.hourValue = Integer.parseInt(time[0]);
			this.minuteValue = Integer.parseInt(time[1]);
			this.secondsValue = Integer.parseInt(time[2]);
			validTime = true;
		}
	}
	public int getHourValue() {
		return hourValue;
	}
	public int getMinuteValue() {
		return minuteValue;
	}
	public int getSecondsValue() {
		return secondsValue;
	}
	public boolean isValidTime() {
		return validTime;
	}
	@Override
	public String toString() {
		return "Time [hourValue=" + hourValue + ", minuteValue=" + minuteValue
				+ ", secondsValue=" + secondsValue + ", validTime=" + validTime + "]";
	}
}
