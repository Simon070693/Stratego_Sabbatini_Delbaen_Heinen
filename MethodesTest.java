package stratego;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethodesTest {

	@Test
	public void test() {
		Drapeau d = new Drapeau (7,'A','A',false);
		Drapeau d2 = new Drapeau (7,'A','A',true);
		partieGagne(d);
		
		assertEquals(false,partieGagne(d));
	}


}
