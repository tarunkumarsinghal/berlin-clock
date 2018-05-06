package com.ubs.opsit.interviews.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BerlinClockConverterTest {

	@Test
	public void testGetTopLampStatus_Off() {
		Time time = new Time("23:00:01");
		assertThat(new BerlinClockConverter(time).getTopLampStatus()).isEqualTo("O"+System.lineSeparator());
	}
	
	@Test
	public void testGetTopLampStatus_On() {
		Time time = new Time("23:00:02");
		assertThat(new BerlinClockConverter(time).getTopLampStatus()).isEqualTo("Y"+System.lineSeparator());
	}

	@Test
	public void testGetFirstRowLampsStatus_AllOff() {
		Time time = new Time("03:50:10");
		assertThat(new BerlinClockConverter(time).getFirstRowLampsStatus()).isEqualTo("OOOO"+System.lineSeparator());
	}
	
	@Test
	public void testGetFirstRowLampsStatus_AllOn() {
		Time time = new Time("24:00:00");
		assertThat(new BerlinClockConverter(time).getFirstRowLampsStatus()).isEqualTo("RRRR"+System.lineSeparator());
	}

	@Test
	public void testGetSecondRowLampsStatus_AllOff() {
		Time time = new Time("20:00:00");
		assertThat(new BerlinClockConverter(time).getSecondRowLampsStatus()).isEqualTo("OOOO"+System.lineSeparator());
	}
	
	@Test
	public void testGetSecondRowLampsStatus_ThreeOn() {
		Time time = new Time("23:00:00");
		assertThat(new BerlinClockConverter(time).getSecondRowLampsStatus()).isEqualTo("RRRO"+System.lineSeparator());
	}

	@Test
	public void testGetThirdRowLampsStatus_AllOff() {
		Time time = new Time("23:00:09");
		assertThat(new BerlinClockConverter(time).getThirdRowLampsStatus()).isEqualTo("OOOOOOOOOOO"+System.lineSeparator());
	}
	
	@Test
	public void testGetThirdRowLampsStatus_MostOn() {
		Time time = new Time("23:59:09");
		assertThat(new BerlinClockConverter(time).getThirdRowLampsStatus()).isEqualTo("YYRYYRYYRYY"+System.lineSeparator());
	}

	@Test
	public void testGetFourthRowLampsStatus_AllOff() {
		Time time = new Time("23:55:09");
		assertThat(new BerlinClockConverter(time).getFourthRowLampsStatus()).isEqualTo("OOOO");
	}
	
	@Test
	public void testGetFourthRowLampsStatus_AllOn() {
		Time time = new Time("23:59:09");
		assertThat(new BerlinClockConverter(time).getFourthRowLampsStatus()).isEqualTo("YYYY");
	}
}
