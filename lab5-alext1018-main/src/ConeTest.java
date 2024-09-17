import static org.junit.Assert.*;

import org.junit.Test;

public class ConeTest {

	@Test
	public void interfaceTest() {
		try {
			class intTest implements Shape3D {
				public double volume() {
					return 0;
				}
				public double surfaceArea() {
					return 0;
				}
			}
		}
		catch (Exception e) {
			fail("Interface Shape3D could not be used.");
		}
	}
	@Test
	public void volumeTest() {
		Shape3D s = new Cone(5,5);
		if(s.volume() != 130.89969389957471) {
			fail("Incorrent volume.");
		}
	}
	@Test
	public void surfaceAreaTest() {
		Shape3D s = new Cone(5,5);
		if(s.surfaceArea() != 189.611889793704) {
			fail("Incorrent surface area.");
		}
	}
	@Test
	public void negativeTest() {
		Shape3D s = new Cone(-5,-5);
		if(s.volume() < 0) {
			fail("Negative dimensions.");
		}
	}
}