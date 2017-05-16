package model;

public class DLatch {

	private String d = "0";
	private String h = "0";
	private String q = "0";
	
	public DLatch() {}
	
	
	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getH() {
		return h;
	}

	public void setH(String h) {
		//if rising edge
		if(this.h=="0" && h=="1") {
			q = d;
		}
		this.h = h;
	}

	public String getQ() {
		return q;
	}
	
}
