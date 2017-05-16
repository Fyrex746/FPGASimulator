package model;

import java.util.ArrayList;

import views.UIGenerator;

public class Generator implements Observable{

	private String label = "";
	private String value = "0";
	
	
	
	public Generator() {
		this("", "0");
	}
	
	public Generator(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public Generator(String value) {
		this("",value);
	}

	
	public void switchValue() {
		if(value=="0") {
			value = "1";
		}else {
			value = "0";
		}
		notifyObservator();
	}
	
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
		notifyObservator();
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
