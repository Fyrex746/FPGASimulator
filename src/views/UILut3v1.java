package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Lut3v1;
import model.Observator;



public class UILut3v1 extends JPanel implements Observator{

	private Lut3v1 lut;
	
	private static final int cellheight = 20;
	private static final int leftCellWidth = 50;
	private static final int rightCellWidth = 20;
	public static final int height = cellheight*8;
	public static final int width = leftCellWidth + rightCellWidth;
	
	
	
	public UILut3v1(){
		this(new Lut3v1() );
	}
	
	public UILut3v1(Lut3v1 lut){
		this.lut = lut;
		lut.addObservator(this);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(leftCellWidth-1, 0, leftCellWidth-1, height-1);
		for (int i = 1; i < 8; i++) {
			g.drawLine(0, (cellheight-1)*i, width-1, (cellheight-1)*i);
		}
	}
	
	public void update(){
		repaint();
	}
	
}
