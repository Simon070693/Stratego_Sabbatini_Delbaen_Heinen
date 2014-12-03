package stratego;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPion {

	@Test
	public void test() {
		Pion p1 = new Pion (1,'A',3);
		Pion p2 = new Pion (5,'D',6);
		Pion p3 = new Pion (4,'E',10);
		Espion e = new Espion (6,'E',1);
		Drapeau d = new Drapeau (7,'A','A',false);
		Drapeau d2 = new Drapeau (7,'A','A',true);
		
		
		assertEquals(2,p1.bougerPionVerticale(2));
		assertEquals('B',p1.bougerPionLaterale('B'));
		assertEquals('B',l.bougerPionLaterale('B'));
		
		assertEquals(false,p2.estPlusFort(p1.getGrade(), p2.getGrade()));
		
		assertEquals(true,e.estMarechal(p3.getGrade()));
		
		assertEquals(false,d.estAttrape());
		assertEquals(true,d2.estAttrape());
	}

}
