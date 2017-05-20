package componentsModels;

import java.util.ArrayList;
import java.util.HashMap;

public class TruthTable implements Observable{
	// input size 	= 3
	// output size 	= 1

	//Properties
	private HashMap<String,String> table;
	
	
	//Constructor
	public TruthTable() {
		table = new HashMap<String,String>(8);
		for (int i = 0; i < 8; i++) {
			String bin = Integer.toBinaryString(8 | i).substring(1);
			table.put(bin, "0");
		}
	}
	
	//Get Set
	public String getOutputForInputs(String inputs) {
		return table.get(inputs);
	}
	
	public void setOutputForInputs(String inputs, String output) {
		if(table.get(inputs) == output){return;}
		table.put(inputs, output);
		notifyObserver();
	}
	
	public HashMap<String, String> getHashMap() {
		return table;
	}
	
	
	//Method
	public void switchOutputForInputs(String inputs){
		if(table.get(inputs) == "1"){
			table.put(inputs, "0");
		}else{
			table.put(inputs, "1");
		}
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
