package model;

import views.UIReceptor;

public class Receptor {
	public UIReceptor ui = null;
	private String value = "0";
	
	public Receptor() {}
	
	public Receptor(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void updateUI() {
		if(ui != null) {
			ui.update();
		}
	}

}
