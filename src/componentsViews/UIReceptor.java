package componentsViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import componentsModels.Observer;
import componentsModels.Receptor;
import simulatorsViews.UIMux2v1Simulator;

public class UIReceptor extends JPanel implements Observer{
	
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
		receptor.addObserver(this);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	
	//Graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(receptor.getValue(), 6, 15);
	}

	
	//Observator
	public void update() {
		repaint();
	}
	
	
	//Get
	public Receptor getreceptor() {
		return receptor;
	}

	
	//Test display
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Generator Display Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int j = 5;
		int i = 2;
		int n = i*j;
		int interspace = 20;
		frame.setSize(UIGenerator.width * j + interspace*(j+1), UIGenerator.height * i + interspace*(i+1));
		frame.setResizable(false);
		
		JPanel contentPanel = new JPanel();
		for (int c = 0; c < n; c++) {
			contentPanel.add(new UIGenerator());
		}
		
		frame.setContentPane(contentPanel);
		frame.setVisible(true);
	}
}
