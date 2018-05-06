package com.ubs.opsit.interviews;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.impl.TimeValidatorImpl;

public class TimeValidatorTest {
	TimeValidator timeValidator;
	
	@Before
	public void setUp() throws Exception {
		timeValidator = new TimeValidatorImpl();
	}
	
	@Test
	public void test_isValidTime_nullCheck() {
		assertThat(timeValidator.isValidTime(null)).isEqualTo(false);
	}
	
	@Test
	public void test_isValidTime_MissingSeconds() {
		assertThat(timeValidator.isValidTime("23:00")).isEqualTo(false);
	}
	
	@Test
	public void test_IsValidTime_IncorrectHours() {
		assertThat(timeValidator.isValidTime("25:00:00")).isEqualTo(false);
	}
	
	@Test
	public void test_IsValidTime_IncorrectMinutes() {
		assertThat(timeValidator.isValidTime("25:-05:00")).isEqualTo(false);
	}
	
	@Test
	public void test_IsValidTime_IncorrectSeconds() {
		assertThat(timeValidator.isValidTime("25:05:60")).isEqualTo(false);
	}
	
	@Test
	public void test_IsValidTime_CorrectMidnight() {
		assertThat(timeValidator.isValidTime("24:00:00")).isEqualTo(true);
	}
	
	@Test
	public void test_IsValidTime_CorrectAfterNoon() {
		assertThat(timeValidator.isValidTime("13:50:00")).isEqualTo(true);
	}
	
	@Test
	public void test_IsValidTime_IncorrectFormat() {
		assertThat(timeValidator.isValidTime("Ta:ku:si")).isEqualTo(false);
	}

}
