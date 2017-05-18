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
		if(this.value == value){return;}
		this.value = value;
		notifyObserver();
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
