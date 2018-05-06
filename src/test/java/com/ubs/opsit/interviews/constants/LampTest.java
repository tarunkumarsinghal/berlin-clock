package com.ubs.opsit.interviews.constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LampTest {

	@Test
	public void test_RedLampStatus() {
		assertThat(Lamp.Red.toString()).isEqualTo("R");		
	}
	
	@Test
	public void test_YellowLampStatus() {
		assertThat(Lamp.Yellow.toString()).isEqualTo("Y");		
	}
	
	@Test
	public void test_OffLampStatus() {
		assertThat(Lamp.Off.toString()).isEqualTo("O");		
	}

}
