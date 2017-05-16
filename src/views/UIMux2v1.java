package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Mux2v1;
import model.Observator;

public class UIMux2v1 extends JPanel implements Observator{

	private final Mux2v1 mux;
	public static final int height = 80;
	public static final int width = 25;
	private static final int ratio = 50; //it is a percentage between left and right height
	private final Polygon polygon;
	
	
	public UIMux2v1() {
		this(new Mux2v1() );
	}

	public UIMux2v1(Mux2v1 mux) {
		this.mux = mux;
		mux.addObservator(this);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		
		int[] x = {0, width-1, width-1, 0, 0};
		int a = (int) ( ((100.0 - (double) ratio) / 200.0) * ((double) height) );
		int b = (int) ( ((100.0 + (double) ratio) / 200.0) * ((double) height) );
		int[] y = {0, a, b ,height-1,0};
		polygon = new  Polygon(x, y, x.length);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawPolygon(polygon);
		g.drawString("0", 3, (int) (0.4*(double) height) );
		g.drawString("1", 3, (int) (0.75*(double) height) );
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public Mux2v1 getMux() {
		return mux;
	}
}