package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnitCellTest {

	@Test
	public void init() {
		assertNotNull(new UnitCell());
	}
	
	@Test
	public void updateWhenLutTruthTableChange(){
		UnitCell uc = new UnitCell();
		uc.getMuxSelector().setValue("0");
		uc.setLutInputs("000");
		uc.getLut().getTruthTable().setOutputForInputs("000", "1");
		assertEquals(uc.getOutput(),"1");
	}
	
	
	@Test
	public void updateWhenLutInputsChange(){
		UnitCell uc = new UnitCell();
		uc.getMuxSelector().setValue("0");
		
		for (int i = 0; i < 8; i++) {
			String lutInputs = Integer.toBinaryString(8 | i).substring(1);
			uc.setLutInputs(lutInputs);
			uc.getLut().getTruthTable().setOutputForInputs(lutInputs, "1");
			assertEquals(uc.getOutput(),"1");
			uc.getLut().getTruthTable().setOutputForInputs(lutInputs, "0");
			assertEquals(uc.getOutput(),"0");
		}
	}
	
	
	@Test
	public void updateWhenClockChange(){
		UnitCell uc = new UnitCell();
		uc.getMuxSelector().setValue("1");
		
		for (int i = 0; i < 8; i++) {
			String lutInputs = Integer.toBinaryString(8 | i).substring(1);
			uc.setLutInputs(lutInputs);
			uc.setClk("0");
			uc.getLut().getTruthTable().setOutputForInputs(lutInputs, "1");
			assertEquals(uc.getOutput(),"0");
			uc.setClk("1");
			assertEquals(uc.getOutput(),"1");
			uc.setClk("0");
			assertEquals(uc.getOutput(),"1");
			uc.setClk("1");
			assertEquals(uc.getOutput(),"1");
			
			uc.getLut().getTruthTable().setOutputForInputs(lutInputs, "0");
			assertEquals(uc.getOutput(),"1");
			uc.setClk("0");
			assertEquals(uc.getOutput(),"1");
			uc.setClk("1");
			assertEquals(uc.getOutput(),"0");
		}
	}

}
