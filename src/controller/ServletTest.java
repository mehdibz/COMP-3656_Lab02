package controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ServletTest {

	@Test
	void test() {
//		fail("Not yet implemented");
		Greeting gr = new Greeting();
		Assert.assertEquals(7, gr.testPasword("ABC1234"));
	}

}
