package model;

public class Receptor {
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

}
