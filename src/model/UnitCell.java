package model;

public class UnitCell implements Observator{

	//Properties
	private String lutInputs = "000";
	private String clk = "0";
	
	//Components
	private Lut3v1 lut = new Lut3v1();
	private Mux2v1 mux = new Mux2v1();
	private Generator gen = new Generator();
	private DLatch latch = new DLatch();
	
	
	//Constructor
	public UnitCell() {
		gen.addObservator(this);
		update();
	}


	@Override
	public void update() {
		lut.setInputs(lutInputs);
		latch.setD(lut.getOutput());
		latch.setH(clk);
		mux.setA(lut.getOutput());
		mux.setB(latch.getQ());
		mux.setS(gen.getValue());
	}


	//Get Set
	public String getLutInputs() {
		return lutInputs;
	}

	public void setLutInputs(String lutInputs) {
		this.lutInputs = lutInputs;
		update();
	}

	public String getClk() {
		return clk;
	}

	public void setClk(String clk) {
		this.clk = clk;
		update();
	}

	public Lut3v1 getLut() {
		return lut;
	}

	public Mux2v1 getMux() {
		return mux;
	}

	public Generator getGen() {
		return gen;
	}

	public DLatch getLatch() {
		return latch;
	}

}
