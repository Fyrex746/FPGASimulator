package model;

import java.util.HashMap;

public class TruthTable{
	// input size 	= 3
	// output size 	= 1

	private HashMap<String,String> table;
	
	public TruthTable() {
		table = new HashMap<String,String>(8);
		for (int i = 0; i < 8; i++) {
			String bin = Integer.toBinaryString(8 | i).substring(1);
			table.put(bin, "0");
		}
	}
	
	public String getOutputForInputs(String inputs) {
		return table.get(inputs);
	}
	
	public void setOutputForInputs(String inputs, String output) {
		table.put(inputs, output);
	}
	
	public void switchOutputForInputs(String inputs){
		if(table.get(inputs) == "1"){
			table.put(inputs, "0");
		}else{
			table.put(inputs, "1");
		}
	}
	
	public HashMap<String, String> getTruthTable() {
		return table;
	}

}
