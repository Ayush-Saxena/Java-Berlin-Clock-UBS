package com.ubs.opsit.interviews.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.ubs.opsit.interviews.example.Example;

public class ExampleTest {

	@Test
	public void thisTestShouldPassIfYouHaveEverythingIsSetupCorrectly() {
		new Example().sayHi();
		assertThat(true, is(true));
	}
}
