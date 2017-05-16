package model;

import java.util.ArrayList;

public interface Observable {
	public void addObservator(Observator o);
	public void deleteObservator(Observator o);
	public void notifyObservator();
}
