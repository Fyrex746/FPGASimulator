package componentsModels;

import static org.junit.Assert.*;

import org.junit.Test;

import componentsModels.TruthTable;

public class TruthTableTest {

	@Test
	public void initObject() {
		assertNotNull(new TruthTable());
	}
	
	@Test
	public void getHashmap() {
		assertNotNull(new TruthTable().getHashMap());
	}
	
	@Test
	public void ModifyTable() {
		TruthTable table = new TruthTable();
		
		table.setOutputForInputs("000", "0");
		assertEquals(table.getOutputForInputs("000"), "0");
		
		table.setOutputForInputs("000", "1");
		assertEquals(table.getOutputForInputs("000"), "1");
		
		table.setOutputForInputs("010", "0");
		assertEquals(table.getOutputForInputs("010"), "0");
		
		table.setOutputForInputs("010", "1");
		assertEquals(table.getOutputForInputs("010"), "1");
		
		table.setOutputForInputs("100", "0");
		assertEquals(table.getOutputForInputs("100"), "0");
		
		table.setOutputForInputs("100", "1");
		assertEquals(table.getOutputForInputs("100"), "1");
	}

	
	@Test
	public void switchOutput() {
		TruthTable table = new TruthTable();
		
		table.switchOutputForInputs("000");
		assertEquals(table.getOutputForInputs("000"), "1");
		table.switchOutputForInputs("000");
		assertEquals(table.getOutputForInputs("000"), "0");
		
		table.switchOutputForInputs("010");
		assertEquals(table.getOutputForInputs("010"), "1");
		table.switchOutputForInputs("010");
		assertEquals(table.getOutputForInputs("010"), "0");
		
		table.switchOutputForInputs("100");
		assertEquals(table.getOutputForInputs("100"), "1");
		table.switchOutputForInputs("100");
		assertEquals(table.getOutputForInputs("100"), "0");
	}
	
	
}
