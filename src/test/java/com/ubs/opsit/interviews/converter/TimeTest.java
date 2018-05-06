package com.ubs.opsit.interviews.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {

	@Test
	public void testTime_Invalid() {
		new Time("Tarun");
	}
	
	@Test
	public void testTime_Valid() {
		new Time("24:00:00");
	}

	@Test
	public void testGetHourValue() {
		Time time = new Time("23:10:05");
		assertThat(time.getHourValue()).isEqualTo(23);
	}

	@Test
	public void testGetMinuteValue() {
		Time time = new Time("23:10:05");
		assertThat(time.getMinuteValue()).isEqualTo(10);
	}

	@Test
	public void testGetSecondsValue() {
		Time time = new Time("23:10:05");
		assertThat(time.getSecondsValue()).isEqualTo(5);
	}

	@Test
	public void testIsValidTime_Valid() {
		Time time = new Time("23:10:05");
		assertThat(time.isValidTime()).isEqualTo(true);
	}
	
	@Test
	public void testIsValidTime_Invalid() {
		Time time = new Time("Tarun");
		assertThat(time.isValidTime()).isEqualTo(false);
		
	}

}
