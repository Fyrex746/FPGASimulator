package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DLatchTest {

	@Test
	public void initialization() {
		DLatch latch = new DLatch();
		assertNotNull(latch);
	}
	
	@Test
	public void IOLogic() {
		DLatch latch = new DLatch();
		
		latch.setD("0");
		assertEquals("0", latch.getQ());
		
		latch.setD("1");
		assertEquals("0", latch.getQ());
		
		latch.setH("1");
		assertEquals("1", latch.getQ());
		
		latch.setD("0");
		assertEquals("1", latch.getQ());
		
		latch.setH("0");
		assertEquals("1", latch.getQ());
		
		latch.setH("1");
		assertEquals("0", latch.getQ());
	}

}
