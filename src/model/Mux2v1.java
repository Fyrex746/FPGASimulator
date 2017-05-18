package model;

import java.util.ArrayList;

public class Mux2v1 implements Observable{

	//Properties
	private String a = "0";
	private String b = "0";
	private String s = "0";
	private String o = "0";

	
	
	//Constructor
	public Mux2v1() {
		// TODO Auto-generated constructor stub
	}

	
	//Method
	private void calculateOutputs() {
		String newO;
		if(s=="0") {
			newO = a;
		}else {
			newO = b;
		}
		
		if(o != newO){
			o = newO;
			notifyObserver();
		}
	}


	
	
	//get, set
	public String getA() {
		return a;
	}

	public void setA(String a) {
		if(this.a == a) {return;}
		this.a = a;
		calculateOutputs();
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		if(this.b == b) {return;}
		this.b = b;
		calculateOutputs();
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		if(this.s == s) {return;}
		this.s = s;
		calculateOutputs();
	}

	public String getO() {
		return o;
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
