package componentsModels;

import java.util.ArrayList;

public class DLatch implements Observable{

	//Properties
	private String d = "0";
	private String h = "0";
	private String q = "0";
	
	
	//Constructor
	public DLatch() {}
	
	
	//Get Set
	public String getD() {
		return d;
	}

	public void setD(String d) {
		if(this.d == d){return;}
		this.d = d;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		if(this.h == h){return;}
		//if rising edge
		if(this.h=="0" && h=="1") {
			q = d;
		}
		this.h = h;
		notifyObserver();
	}

	public String getQ() {
		return q;
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
