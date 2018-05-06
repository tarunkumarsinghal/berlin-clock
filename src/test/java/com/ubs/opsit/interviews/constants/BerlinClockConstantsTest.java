package com.ubs.opsit.interviews.constants;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BerlinClockConstantsTest {

	@Test
	public void test_FiveHourConstantsLoadedSuccessfully() {
		assertThat(BerlinClockConstants.TOTAL_FIVE_HOUR_LAMPS).isEqualTo(4);
	}
	
	@Test
	public void test_OneHourConstantsLoadedSuccessfully() {
		assertThat(BerlinClockConstants.TOTAL_ONE_HOUR_LAMPS).isEqualTo(4);
	}
	
	@Test
	public void test_FiveMinuteConstantsLoadedSuccessfully() {
		assertThat(BerlinClockConstants.TOTAL_FIVE_MINUTE_LAMPS).isEqualTo(11);
	}
	
	@Test
	public void test_OneMinuteConstantsLoadedSuccessfully() {
		assertThat(BerlinClockConstants.TOTAL_ONE_MINUTE_LAMPS).isEqualTo(4);
	}

}
