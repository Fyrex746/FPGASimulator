package views;

import model.Observator;
import model.Receptor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class UIReceptor extends JPanel implements Observator{
	
	//Properties
	private final Receptor receptor;
	public static final int height = 20;
	public static final int width = 20;
	
	
	//Constructors
	public UIReceptor() {
		this(new Receptor());
	}
	
	public UIReceptor(Receptor receptor) {
		this.receptor = receptor;
		receptor.addObservator(this);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	
	//Graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(receptor.getValue(), 5, 15);
	}

	
	//Observator
	public void update() {
		repaint();
	}
	
	
	//Get
	public Receptor getreceptor() {
		return receptor;
	}

}
