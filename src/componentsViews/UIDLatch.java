package componentsViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import componentsModels.DLatch;
import componentsModels.Observer;

public class UIDLatch extends JPanel implements Observer{
	
	//Properties
	private DLatch latch;
	public static final int height = 60;
	public static final int width = 40;
	
	//Constructor
	public UIDLatch() {
		
	}
	
	public UIDLatch(DLatch latch) {
		this.latch = latch;
		latch.addObserver(this);
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
	}
	
	//Graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBorder(BorderFactory.createLineBorder(Color.black));
		g.drawLine(0, 40, 8, 45);
		g.drawLine(0, 50, 8, 45);
		g.drawString("D", 5, 15);
		g.drawString("Q", 25, 15);
	}
	
	
	//Get
	public DLatch getLatch() {
		return latch;
	}
	
	
	//OBserver
	public void update(){
		repaint();
		System.out.println("UI update:	" + this.getClass());
	}



}
