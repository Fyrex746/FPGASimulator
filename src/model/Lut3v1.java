package model;

import java.util.ArrayList;



public class Lut3v1 implements Observator{

	//Properties
	private String inputs = "000";
	private String output = "0";
	private TruthTable table;
	
	
	//Constructor
	public Lut3v1() {
		table = new TruthTable();
	}
	
	//Method
	private void calculateOutput() {
		output = table.getOutputForInputs(inputs);
	}
	

	
	//get set
	public void setInputs(String inputs) {
		this.inputs = inputs;
		calculateOutput();
	}

	public String getOutput() {
		return output;
	}
	
	public TruthTable getTruthTable(){
		return table;
	}

	
	
	//Observer pattern
	@Override
	public void update() {
		calculateOutput();
	}
	
	
	
	
	//Observable pattern
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
