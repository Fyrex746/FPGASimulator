package model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class Lut3v1Test {

	@Test
	public void correctInit() {
		Lut3v1 lut = new Lut3v1();
		assertNotNull(lut);
	}
	
	
	
	@Test
	public void correctInitTruthTable() {
		Lut3v1 lut = new Lut3v1();
		HashMap<String, String> truthTable = lut.getTruthTable();
		for (int i = 0; i < 8; i++) {
			String bin = Integer.toBinaryString(8 | i).substring(1);
			assertEquals("0", truthTable.get(bin));
			assertEquals("0", lut.getOutputForInputs(bin));
		}
	}
	
	
	
	@Test
	public void editTruthTable() {
		Lut3v1 lut = new Lut3v1();
		try {
			lut.setOutputForInputs("000", "1");
			lut.setOutputForInputs("100", "1");
			lut.setOutputForInputs("010", "1");
		} catch (Exception e) {
			fail("Fail setting output");
		}
		assertEquals("1", lut.getOutputForInputs("000"));
		assertEquals("1", lut.getOutputForInputs("100"));
		assertEquals("1", lut.getOutputForInputs("010"));
		
		try {
			lut.setOutputForInputs("000", "0");
			lut.setOutputForInputs("100", "0");
			lut.setOutputForInputs("010", "0");
		} catch (Exception e) {
			fail("Error setting output");
		}
		assertEquals("0", lut.getOutputForInputs("000"));
		assertEquals("0", lut.getOutputForInputs("100"));
		assertEquals("0", lut.getOutputForInputs("010"));
	}
	
	
	@Test
	public void setCorrectInputs() {
		Lut3v1 lut = new Lut3v1();
		try {
			lut.setInputs("000");
			lut.setInputs("001");
			lut.setInputs("010");
			lut.setInputs("011");
			lut.setInputs("100");
			lut.setInputs("101");
			lut.setInputs("110");
			lut.setInputs("111");
		} catch (Exception e) {
			fail("Fail change current input");
		}
	}
	
	
	
	
	@Test
	public void setIncorrectInputs() {
		Lut3v1 lut = new Lut3v1();
		try {
			lut.setInputs("0");
			fail();
		} catch (Exception e) {}
		
		try {
			lut.setInputs("1");
			fail();
		} catch (Exception e) {}
		
		try {
			lut.setInputs("00");
			fail();
		} catch (Exception e) {}
		
		try {
			lut.setInputs("0000");
			fail();
		} catch (Exception e) {}
	}
	
	
	
	
	@Test
	public void IOLogic() {
		Lut3v1 lut = new Lut3v1();
		
		//configuring truthTable with custom value
		try {
			lut.setOutputForInputs("000", "1");
			lut.setOutputForInputs("100", "1");
			lut.setOutputForInputs("010", "1");
		} catch (Exception e) {
			fail("Error setting output");
		}
		
		try {
			lut.setInputs("100");
		} catch (Exception e) {
			fail("Fail change current input");
		}
		assertEquals("1", lut.getOutput());
	}

}
