package model;

import java.util.ArrayList;

public class Mux2v1 implements Observable{

	private String a = "0";
	private String b = "0";
	private String s = "0";
	private String o = "0";

	
	
	
	public Mux2v1() {
		// TODO Auto-generated constructor stub
	}

	private void calculateOutputs() {
		if(s=="0") {
			o = a;
		}else {
			o = b;
		}
		notifyObservator();
	}


	
	
	//get, set
	public String getA() {
		return a;
	}

	public void setA(String a) {
		if(a == this.a) {return;}
		this.a = a;
		calculateOutputs();
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		if(b == this.b) {return;}
		this.b = b;
		calculateOutputs();
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		if(s == this.s) {return;}
		this.s = s;
		calculateOutputs();
	}

	public String getO() {
		return o;
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
