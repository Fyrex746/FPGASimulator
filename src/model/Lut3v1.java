package model;

import java.util.HashMap;

public class Lut3v1 {

	private String inputs = "000";
	private String output = "0";
	private HashMap<String,String> truthTable;
	
	
	
	public Lut3v1() {
		// TODO Auto-generated constructor stub
		initTruthTable();
	}
	
	private void calculateOutput() {
		output = truthTable.get(inputs);
	}
	
	
	
	//TruthTable relative
	private void initTruthTable() {
		truthTable = new HashMap<String,String>(8);
		for (int i = 0; i < 8; i++) {
			String bin = Integer.toBinaryString(8 | i).substring(1);
			truthTable.put(bin, "0");
		}
	}
	
	public String getOutputForInputs(String inputs) {
		return truthTable.get(inputs);
	}
	
	public void setOutputForInputs(String inputs, String output) throws Exception {
		if(inputs.length() !=3) {
			throw new Exception("Incorect input size");
		}
		if(output.length() != 1) {
			throw new Exception("Incorect output size");
		}
		truthTable.put(inputs, output);
	}
	
	public HashMap<String, String> getTruthTable() {
		return truthTable;
	}
	
	
	
	
	//get set
	public void setInputs(String inputs) throws Exception {
		if(inputs.length() !=3) {
			throw new Exception("Incorect input size");
		}
		this.inputs = inputs;
		calculateOutput();
	}

	public String getOutput() {
		return output;
	}

	

}
