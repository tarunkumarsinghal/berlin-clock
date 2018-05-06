package com.ubs.opsit.interviews.constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BerlinClockConstants {
	private static final Logger LOG = LoggerFactory.getLogger(BerlinClockConstants.class);
	
	public static Integer TOTAL_FIVE_HOUR_LAMPS;
	public static Integer TOTAL_ONE_HOUR_LAMPS;
	public static Integer TOTAL_FIVE_MINUTE_LAMPS;
	public static Integer TOTAL_ONE_MINUTE_LAMPS;
	static {
		Properties prop = new Properties();
	    try {
	        // load a properties file
	    	LOG.info("Staring Property File Load");
	        prop.load(new FileInputStream("config.properties"));
	        TOTAL_FIVE_HOUR_LAMPS = Integer.parseInt(prop.getProperty("totalFiveHourLamps"));
	        TOTAL_ONE_HOUR_LAMPS = Integer.parseInt(prop.getProperty("totalOneHourLamps"));
	        TOTAL_FIVE_MINUTE_LAMPS = Integer.parseInt(prop.getProperty("totalFiveMinuteLamps"));
	    	TOTAL_ONE_MINUTE_LAMPS = Integer.parseInt(prop.getProperty("totalOneMinuteLamps"));
	    	LOG.info("Property File Loaded Successfully!!!");
	    }
	    catch(IOException | NumberFormatException ex) {
	    	LOG.error("config.properties file not Found Or some issue with loading config file so using default values");
	    	TOTAL_FIVE_HOUR_LAMPS=4;
	    	TOTAL_ONE_HOUR_LAMPS=4;
	    	TOTAL_FIVE_MINUTE_LAMPS=11;
	    	TOTAL_ONE_MINUTE_LAMPS=4;
	    }
	}
}
