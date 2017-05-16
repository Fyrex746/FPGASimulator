package model;

import java.util.ArrayList;

import views.UIReceptor;

public class Receptor implements Observable{
	private String value = "0";
	
	public Receptor() {}
	
	public Receptor(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		notifyObservator();
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
