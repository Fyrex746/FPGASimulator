package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Observator;
import model.Receptor;



public class UIReceptor extends JPanel implements Observator{
	
	private final Receptor receptor;
	public static final int height = 20;
	public static final int width = 20;
	
	public UIReceptor() {
		this(new Receptor());
	}
	
	public UIReceptor(Receptor receptor) {
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.receptor = receptor;
		receptor.addObservator(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(receptor.getValue(), 5, 15);
	}

	
	public void update() {
		repaint();
	}
	
	public Receptor getreceptor() {
		return receptor;
	}

}
