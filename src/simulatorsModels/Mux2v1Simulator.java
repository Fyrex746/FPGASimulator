package simulatorsModels;

import java.util.ArrayList;

import componentsModels.Generator;
import componentsModels.Mux2v1;
import componentsModels.Observable;
import componentsModels.Observer;
import componentsModels.Receptor;

public class Mux2v1Simulator implements Observable, Observer{
	
	//Components
	private Generator g1 = new Generator();
	private Generator g2 = new Generator();
	private Generator g3 = new Generator();
	private Mux2v1 mux = new Mux2v1();
	private Receptor r = new Receptor();
	
	//Constructor
	public Mux2v1Simulator(){
		g1.addObserver(this);
		g2.addObserver(this);
		g3.addObserver(this);
		update();
	}
	
	
	//Get
	public Generator getG1() {
		return g1;
	}
	public Generator getG2() {
		return g2;
	}
	public Generator getG3() {
		return g3;
	}
	public Mux2v1 getMux() {
		return mux;
	}
	public Receptor getR() {
		return r;
	}
	
	
	//Observer
	public void update() {
		mux.setA(g1.getValue());
		mux.setB(g2.getValue());
		mux.setS(g3.getValue());
		r.setValue(mux.getO());
		notifyObserver();
		System.out.println("Model update:	" + this.getClass());
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