package componentsViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import componentsModels.Generator;
import componentsModels.Observer;

public class UIGenerator extends JPanel implements Observer,MouseListener{
	
	//Properties
	private final Generator generator;
	public static final int height = 20;
	public static final int width = 20;
	JPopupMenu jpm = new JPopupMenu("Generator");
	JMenuItem jmi = new JMenuItem("Actionless entry");
	
	
	//Constructors
	public UIGenerator() {
		this(new Generator());
		jpm.add(jmi);
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
		g.drawString(generator.getValue(), 6, 15);
	}

	
	//Get
	public Generator getGenerator() {
		return generator;
	}

	
	//Observator
	public void update() {
		repaint();
		System.out.println("UI update:	" + this.getClass());
	}

	
	//Mouse Listener
	
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)) {
			System.out.println("Rigth Click");
			//jpm.show(e.getComponent().getParent(), e.getX(), e.getY());
		}else {
			System.out.println("Left Click");
			generator.switchValue();
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
