package simulatorsModels;

import java.util.ArrayList;

import componentsModels.Generator;
import componentsModels.Lut3v1;
import componentsModels.Receptor;
import componentsModels.Observer;
import componentsModels.Observable;

public class Lut3v1Simulator implements Observer, Observable{
	
	//Model
	private Generator g1 = new Generator();
	private Generator g2 = new Generator();
	private Generator g3 = new Generator();
	private Lut3v1 lut = new Lut3v1();
	private Receptor r = new Receptor();

	
	//Constructor
	public Lut3v1Simulator() {
		g1.addObserver(this);
		g2.addObserver(this);
		g3.addObserver(this);
		lut.addObserver(this);
		update();
	}
	
	
	//Get
	public Lut3v1 getLut() {
		return lut;
	}
	public Generator getG1() {
		return g1;
	}
	public Generator getG2() {
		return g2;
	}
	public Generator getG3() {
		return g3;
	}
	public Receptor getR() {
		return r;
	}



	//Observer
	public void update() {
		String inputs = g1.getValue() + g2.getValue() + g3.getValue();
		lut.setInputs(inputs);
		r.setValue(lut.getOutput());
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
