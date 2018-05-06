package com.ubs.opsit.interviews.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.TimeValidator;

public class TimeValidatorImpl implements TimeValidator {
	private static final Logger LOG = LoggerFactory.getLogger(TimeValidatorImpl.class);
	
	private Pattern pattern;
	private Matcher matcher;

	public TimeValidatorImpl() {
		pattern = Pattern.compile(TIME24HOURS_PATTERN);
	} 

	@Override
	public boolean isValidTime(String aTime) {
		LOG.info("Starting isValidTime method for aTime:"+aTime);
		if(aTime != null) {
			matcher = pattern.matcher(aTime);
			return matcher.matches();
		}
		else {
			LOG.info("Finished isValidTime method with result: false");
			return false;			
		}
	}

}
