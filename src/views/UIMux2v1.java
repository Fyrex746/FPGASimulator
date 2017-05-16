package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Mux2v1;
import model.Observator;

public class UIMux2v1 extends JPanel implements Observator{

	private final Mux2v1 mux;
	public static final int height = 20;
	public static final int width = 20;
	
	
	public UIMux2v1() {
		this(new Mux2v1() );
	}

	public UIMux2v1(Mux2v1 mux) {
		this.mux = mux;
		mux.addObservator(this);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public Mux2v1 getMux() {
		return mux;
	}
}
