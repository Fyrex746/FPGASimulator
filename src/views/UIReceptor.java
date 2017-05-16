package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Receptor;



public class UIReceptor extends JPanel{
	
	private Receptor receptor;
	private int height = 20;
	private int width = 20;
	
	public UIReceptor() {
		this(new Receptor());
	}
	
	public UIReceptor(Receptor receptor) {
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.receptor = receptor;
		receptor.ui = this;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(receptor.getValue(), 5, 15);
	}

	public Receptor getreceptor() {
		return receptor;
	}
	
	public void update() {
		repaint();
	}
	

}
