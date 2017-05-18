package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Lut3v1 implements Observable{

	private String inputs = "000";
	private String output = "0";
	private HashMap<String,String> truthTable;
	
	
	
	public Lut3v1() {
		// TODO Auto-generated constructor stub
		initTruthTable();
	}
	
	private void calculateOutput() {
		output = truthTable.get(inputs);
		notifyObservator();
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
		calculateOutput();
		notifyObservator();
	}
	
	public void switchOutputForInputs(String inputs){
		if(truthTable.get(inputs) == "1"){
			truthTable.put(inputs, "0");
		}else{
			truthTable.put(inputs, "1");
		}
		calculateOutput();
		notifyObservator();
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

	
	
	//Observer pattern
	private ArrayList<Observator> observators = new ArrayList<Observator>();

	public void addObservator(Observator o) {
		observators.add(o);
	}

	public void deleteObservator(Observator o) {
		observators.remove(o);
	}

	public void notifyObservator() {
		for(Observator o: observators) {
			o.update();
		}
	}

}
