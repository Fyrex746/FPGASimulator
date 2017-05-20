package componentsModels;

import static org.junit.Assert.*;

import org.junit.Test;

import componentsModels.Lut3v1;



public class Lut3v1Test {

	@Test
	public void correctInit() {
		Lut3v1 lut = new Lut3v1();
		assertNotNull(lut);
	}
	
	
	@Test
	public void IOLogic() {
		Lut3v1 lut = new Lut3v1();
		
		lut.getTruthTable().setOutputForInputs("000", "1");
		lut.getTruthTable().setOutputForInputs("010", "1");
		lut.getTruthTable().setOutputForInputs("100", "1");
		
		
		lut.setInputs("000");
		assertEquals("1", lut.getOutput());
		
		lut.setInputs("001");
		assertEquals("0", lut.getOutput());
		
		lut.setInputs("010");
		assertEquals("1", lut.getOutput());
	}

}
