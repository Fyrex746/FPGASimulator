package model;

import views.UIGenerator;

public class Generator {

	public UIGenerator ui;
	private String label = "";
	private String value = "0";
	
	
	
	public Generator() {
		this(null, "", "0");
	}
	
	public Generator(UIGenerator ui, String label, String value) {
		this.ui = ui;
		this.label = label;
		this.value = value;
	}
	
	public Generator(String value) {
		this(null,"",value);
	}

	
	public void switchValue() {
		if(value=="0") {
			value = "1";
		}else {
			value = "0";
		}
	}
	
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
		updateUI();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		updateUI();
	}
	
	public void updateUI() {
		if(ui != null) {
			ui.update();
		}
	}

}
