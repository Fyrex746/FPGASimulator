package componentsModels;

import static org.junit.Assert.*;
import org.junit.Test;

import componentsModels.Mux2v1;

public class Mux2v1Test {

	@Test
	public void initObject() {
		assertNotNull(new Mux2v1());
	}
	
	@Test
	public void muxLogic() {
		Mux2v1 mux = new Mux2v1();
		
		mux.setA("0");
		mux.setB("0");
		mux.setS("0");
		assertEquals("0", mux.getO());
		
		mux.setA("0");
		mux.setB("0");
		mux.setS("1");
		assertEquals("0", mux.getO());
		
		mux.setA("0");
		mux.setB("1");
		mux.setS("0");
		assertEquals("0", mux.getO());
		
		mux.setA("0");
		mux.setB("1");
		mux.setS("1");
		assertEquals("1", mux.getO());
		
		mux.setA("1");
		mux.setB("0");
		mux.setS("0");
		assertEquals("1", mux.getO());
		
		mux.setA("1");
		mux.setB("0");
		mux.setS("1");
		assertEquals("0", mux.getO());
		
		mux.setA("1");
		mux.setB("1");
		mux.setS("0");
		assertEquals("1", mux.getO());
		
		mux.setA("1");
		mux.setB("1");
		mux.setS("1");
		assertEquals("1", mux.getO());
		
	}
	

}
