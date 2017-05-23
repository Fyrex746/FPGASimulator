package simulatorsModels;

import java.util.ArrayList;

import componentsModels.DLatch;
import componentsModels.Generator;
import componentsModels.Observer;
import componentsModels.Receptor;

public class DLatchSimulator implements Observer{

	//Model
	private Generator g1 = new Generator();
	private Generator g2 = new Generator();
	private DLatch dlatch = new DLatch();
	private Receptor r = new Receptor();
	
	//Constructor
	public DLatchSimulator() {
		g1.addObserver(this);
		g2.addObserver(this);
	}
	
	
	
	
	//Update
	public void update(){
		dlatch.setD(g1.getValue());
		dlatch.setH(g2.getValue());
		r.setValue(dlatch.getQ());
		notifyObserver();
		System.out.println("Model update:	" + this.getClass());
	}
	
	
	//Get
	public Generator getG1() {
		return g1;
	}
	public Generator getG2() {
		return g2;
	}
	public DLatch getDlatch() {
		return dlatch;
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
