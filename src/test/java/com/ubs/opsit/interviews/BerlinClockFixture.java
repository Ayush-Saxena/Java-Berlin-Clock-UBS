package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import com.ubs.opsit.interviews.domain.Colour;
import com.ubs.opsit.interviews.impl.BerlinClock;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing
 * stories. You should not need to edit this class to complete the exercise,
 * this is your definition of done.
 */
public class BerlinClockFixture {

	private TimeConverter berlinClock;
	private String theTime;

	@Test
	public void berlinClockAcceptanceTests() throws Exception {
		aBehaviouralTestRunner().usingStepsFrom(this).withStory("berlin-clock.story").run();
	}

	@When("the time is $time")
	public void whenTheTimeIs(String time) {
		theTime = time;
	}

	@Then("the clock should look like $")
	public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
	
		//Use Clock Builder to create Berlin Clock
		berlinClock = new BerlinClock.Builder()
				.row().lamp(1, Colour.Y)
				.and()
				.row().lamp(4, Colour.R)
				.and()
				.row().lamp(4, Colour.R)
				.and()
				.row().lamp(2, Colour.Y).lamp(1, Colour.R).lamp(2, Colour.Y).lamp(1, Colour.R).lamp(2, Colour.Y).lamp(1, Colour.R).lamp(2, Colour.Y)
				.and()
				.row().lamp(4, Colour.Y).build();

		assertThat(theExpectedBerlinClockOutput).isEqualTo(berlinClock.convertTime(theTime));
	}
}
