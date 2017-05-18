package model;

import java.util.ArrayList;

public class Receptor implements Observable{
	
	//Properties
	private String value = "0";
	
	
	
	//Constructor
	public Receptor() {}
	
	public Receptor(String value) {
		this.value = value;
	}

	
	
	//Get set
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		notifyObservator();
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
