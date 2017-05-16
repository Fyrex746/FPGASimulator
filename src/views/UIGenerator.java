package views;

import model.Generator;
import model.Observator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class UIGenerator extends JPanel implements Observator,MouseListener{
	
	private final Generator generator;
	public static final int height = 20;
	public static final int width = 20;
	
	public UIGenerator() {
		this(new Generator());
	}
	
	public UIGenerator(Generator generator) {
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.generator = generator;
		generator.addObservator(this);
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(generator.getValue(), 5, 15);
	}

	public Generator getGenerator() {
		return generator;
	}

	public void update() {
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		generator.switchValue();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	

}
