package componentsModels;

import java.util.ArrayList;

public class Generator implements Observable{

	//Properties
	private String label = "";
	private String value = "0";
	
	
	
	
	//Constructor
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

	
	
	
	
	//Method
	public void switchValue() {
		if(value=="0") {
			value = "1";
		}else {
			value = "0";
		}
		notifyObserver();
	}
	
	
	
	
	
	
	//Get, set
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
		notifyObserver();
	}

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
