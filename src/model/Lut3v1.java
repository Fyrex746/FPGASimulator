package model;

import java.util.ArrayList;



public class Lut3v1 implements Observer,Observable{

	//Properties
	private String inputs = "000";
	private String output = "0";
	private TruthTable table;
	
	
	//Constructor
	public Lut3v1() {
		table = new TruthTable();
		table.addObserver(this);
	}
	
	//Method
	private void calculateOutput() {
		String newOutput = table.getOutputForInputs(inputs);
		if(output != newOutput){
			output = newOutput;
			notifyObserver();
		}
	}
	

	
	//get set
	public void setInputs(String inputs) {
		if(this.inputs == inputs){return;}
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
	public void update() {
		calculateOutput();
	}
	
	
	
	
	//Observable pattern
	private ArrayList<Observer> observators = new ArrayList<Observer>();
	public void addObserver(Observer o) {
		observators.add(o);
	}
	public void deleteObserver(Observer o) {
		observators.remove(o);
	}
	public void notifyObserver() {
		for(Observer o: observators) {
			o.update();
		}
	}

}
