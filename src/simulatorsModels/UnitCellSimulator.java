package simulatorsModels;

import java.util.ArrayList;

import componentsModels.Generator;
import componentsModels.Lut3v1;
import componentsModels.Observer;
import componentsModels.Receptor;
import componentsModels.UnitCell;

public class UnitCellSimulator implements Observer{
	
	//Models
	private Generator g1 = new Generator();
	private Generator g2 = new Generator();
	private Generator g3 = new Generator();
	private Generator clk = new Generator();
	private UnitCell uc = new UnitCell();
	private Receptor r = new Receptor();

	public UnitCellSimulator() {
		g1.addObserver(this);
		g2.addObserver(this);
		g3.addObserver(this);
		clk.addObserver(this);
		uc.addObserver(this);
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
	public Generator getClk() {
		return clk;
	}
	public UnitCell getUc() {
		return uc;
	}
	public Receptor getR() {
		return r;
	}


	//Observer
	private Boolean updadingInProgress = false;
	public void update() {
		if(updadingInProgress){return;}
		updadingInProgress = true;
		
		String lutInputs = g1.getValue() + g2.getValue() + g3.getValue();
		uc.setLutInputs(lutInputs);
		uc.setClk(clk.getValue());
		r.setValue(uc.getOutput());
		notifyObserver();
		System.out.println("Model update:	" + this.getClass());
		
		updadingInProgress = false;
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
