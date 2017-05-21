package simulatorsModels;

import java.util.ArrayList;

import componentsModels.Generator;
import componentsModels.Observable;
import componentsModels.Observer;
import componentsModels.Receptor;

public class ReceptorSimulator implements Observer, Observable {

	Generator g = new Generator();
	Receptor r = new Receptor();

	public ReceptorSimulator(){
		g.addObserver(this);
		update();
	}
	
	//Observer
	public void update() {
		r.setValue(g.getValue());
		System.out.println("Model update:	" + this.getClass());
	}
	
	//Get
	public Generator getG() {
		return g;
	}
	public Receptor getR() {
		return r;
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
