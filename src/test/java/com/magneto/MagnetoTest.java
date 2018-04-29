package com.magneto;

import static org.mockito.Mockito.validateMockitoUsage;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class MagnetoTest {
	
	@After
	public void validate() {
		validateMockitoUsage();
	}
	
	@Test
	public void stubMethod() {
		
	}

}
