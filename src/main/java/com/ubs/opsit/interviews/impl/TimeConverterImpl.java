package com.ubs.opsit.interviews.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.converter.BerlinClockConverter;
import com.ubs.opsit.interviews.converter.Time;

public class TimeConverterImpl implements TimeConverter {
	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);
	
	@Override
	public String convertTime(String aTime) {
		LOG.info("Starting convertTime method with aTime:"+aTime);
		Time time = new Time(aTime);
		if(time.isValidTime()) {
			return BerlinClockConverter.getLampStatus(time);
		}
		else {
			LOG.error("Failed in convertTime method with Reason: Time format is Incorrect");
			return null;
		}
	}
}
