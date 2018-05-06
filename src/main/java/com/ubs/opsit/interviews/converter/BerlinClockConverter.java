package com.ubs.opsit.interviews.converter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.constants.BerlinClockConstants;
import com.ubs.opsit.interviews.constants.Lamp;

public class BerlinClockConverter {
	private static final Logger LOG = LoggerFactory.getLogger(BerlinClockConverter.class);
	
	private Time time;
	
	public BerlinClockConverter(Time time) {
		this.time = time;
	}
	public static String getLampStatus(Time time) {
		LOG.info("Staring getLampStatus for time = "+time.toString());
		BerlinClockConverter converter = new BerlinClockConverter(time);
		
		StringBuilder clockStatus = new StringBuilder();
		
		//Yellow Lamp status/Lamp On top of the clock
		clockStatus.append(converter.getTopLampStatus());
		
		//Five Hour Lamp Status / Lamps on First Row
		clockStatus.append(converter.getFirstRowLampsStatus());
		
		//One Hour Lamp Status / Lamps on Second Row
		clockStatus.append(converter.getSecondRowLampsStatus());
		
		//Five Minute Lamp Status / Lamps on Third Row
		clockStatus.append(converter.getThirdRowLampsStatus());
		
		//One Minute Lamp Status / Lamps on Fourth Row
		clockStatus.append(converter.getFourthRowLampsStatus());
		
		LOG.info("Finished getLampStatus for time = "+time.toString()+" With output: "+clockStatus.toString());
		return clockStatus.toString();
	}
	public String getTopLampStatus() {
		LOG.info("Staring getTopLampStatus for time = "+time.toString());
		
		StringBuilder lampStatus = new StringBuilder();
		
		//Seconds Lamp status
		lampStatus.append(time.getSecondsValue() % 2 == 0 ? Lamp.Yellow.toString() : Lamp.Off.toString());
		
		//Line separator
		lampStatus.append(System.lineSeparator());
		
		LOG.info("Finished getLampStatus for time = "+time.toString()+" With output: "+lampStatus.toString());
		return lampStatus.toString();
	}
	public String getFirstRowLampsStatus() {
		LOG.info("Staring getFirstRowLampsStatus for time = "+time.toString());
		
		//First Row Lamp status
		int totalFiveHourOnLamps = time.getHourValue() / 5;
		int totalFiveHourOffLamps = BerlinClockConstants.TOTAL_FIVE_HOUR_LAMPS - totalFiveHourOnLamps; 
		
		StringBuilder lampStatus = new StringBuilder();		
		
		//adding On Lamps
		lampStatus.append(StringUtils.repeat(Lamp.Red.toString(), totalFiveHourOnLamps));
		
		//adding remaining Off Lamps
		lampStatus.append(StringUtils.repeat(Lamp.Off.toString(), totalFiveHourOffLamps));
		
		//Line separator
		lampStatus.append(System.lineSeparator());
		
		LOG.info("Finished getFirstRowLampsStatus for time = "+time.toString()+" With output: "+lampStatus.toString());
		return lampStatus.toString();
	}
	public String getSecondRowLampsStatus() {
		LOG.info("Staring getSecondRowLampsStatus for time = "+time.toString());
		
		//Second Row Lamp status
		int totalOneHourOnLamps = time.getHourValue() % 5;
		int totalOneHourOffLamps = BerlinClockConstants.TOTAL_ONE_HOUR_LAMPS - totalOneHourOnLamps; 
		
		StringBuilder lampStatus = new StringBuilder();
		
		//adding On Lamps
		lampStatus.append(StringUtils.repeat(Lamp.Red.toString(), totalOneHourOnLamps));
		
		//adding remaining Off Lamps
		lampStatus.append(StringUtils.repeat(Lamp.Off.toString(), totalOneHourOffLamps));
		
		//Line separator
		lampStatus.append(System.lineSeparator());
		
		LOG.info("Finished getSecondRowLampsStatus for time = "+time.toString()+" With output: "+lampStatus.toString());
		return lampStatus.toString();
	}
	public String getThirdRowLampsStatus() {
		LOG.info("Staring getThirdRowLampsStatus for time = "+time.toString());
		
		//Third Row Lamp status
		int totalFiveMinuteOnLamps = time.getMinuteValue() / 5;
		int totalFiveMinuteOffLamps = BerlinClockConstants.TOTAL_FIVE_MINUTE_LAMPS - totalFiveMinuteOnLamps; 
		
		StringBuilder lampStatus = new StringBuilder();

		//adding On Lamps in reverse order
		while(totalFiveMinuteOnLamps > 0) {
			if(totalFiveMinuteOnLamps%3 == 0) {
				lampStatus.append(Lamp.Red.toString());
			}
			else {
				lampStatus.append(Lamp.Yellow.toString());
			}
			totalFiveMinuteOnLamps--;
		}
		//correcting sequence by revering the string
		lampStatus.reverse();
		
		//adding remaining Off Lamps
		lampStatus.append(StringUtils.repeat(Lamp.Off.toString(), totalFiveMinuteOffLamps));
		
		//Line separator
		lampStatus.append(System.lineSeparator());
		
		LOG.info("Finished getThirdRowLampsStatus for time = "+time.toString()+" With output: "+lampStatus.toString());
		return lampStatus.toString();
	}
	public String getFourthRowLampsStatus() {
		LOG.info("Staring getFourthRowLampsStatus for time = "+time.toString());
		
		//Fourth Row Lamp status
		int totalOneMinuteOnLamps = time.getMinuteValue() % 5;
		int totalOneMinuteOffLamps = BerlinClockConstants.TOTAL_ONE_MINUTE_LAMPS - totalOneMinuteOnLamps; 
		
		StringBuilder lampStatus = new StringBuilder();
		
		//adding On Lamps
		lampStatus.append(StringUtils.repeat(Lamp.Yellow.toString(), totalOneMinuteOnLamps));
		
		//adding remaining Off Lamps
		lampStatus.append(StringUtils.repeat(Lamp.Off.toString(), totalOneMinuteOffLamps));
		
		LOG.info("Finished getFourthRowLampsStatus for time = "+time.toString()+" With output: "+lampStatus.toString());
		return lampStatus.toString();
	}
}
