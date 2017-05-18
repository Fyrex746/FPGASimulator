package views;

import model.Generator;
import model.Observer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class UIGenerator extends JPanel implements Observer,MouseListener{
	
	//Properties
	private final Generator generator;
	public static final int height = 20;
	public static final int width = 20;
	
	
	//Constructors
	public UIGenerator() {
		this(new Generator());
	}
	
	public UIGenerator(Generator generator) {
		this.generator = generator;
		generator.addObserver(this);
		addMouseListener(this);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		
	}
	
	
	//Graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBorder(BorderFactory.createLineBorder(Color.black));
		g.drawString(generator.getValue(), 5, 15);
	}

	
	//Get
	public Generator getGenerator() {
		return generator;
	}

	
	//Observator
	public void update() {
		repaint();
	}

	
	//Mouse Listener
	public void mouseClicked(MouseEvent e) {
		generator.switchValue();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
