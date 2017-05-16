package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Generator;
import model.Mux2v1;
import model.Observator;
import model.Receptor;

public class Mux2v1Frame extends JFrame implements Observator{
	
	Mux2v1 mux = new Mux2v1();
	Generator g1 = new Generator();
	Generator g2 = new Generator();
	Generator g3 = new Generator();
	Receptor r = new Receptor();
	
	UIMux2v1 uimux = new UIMux2v1(mux);
	UIGenerator uig1 = new UIGenerator(g1);
	UIGenerator uig2 = new UIGenerator(g2);
	UIGenerator uig3 = new UIGenerator(g3);
	UIReceptor uir = new UIReceptor(r);
	
	

	public Mux2v1Frame() {
		super();
		setTitle("Test Mux2v1");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.add(uig1);
		contentPanel.add(uig2);
		contentPanel.add(uig3);
		contentPanel.add(uimux);
		contentPanel.add(uir);
		
		
		contentPanel.setLayout(null);
		uig1.setBounds(50, 20,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(50, 60,UIGenerator.width, UIGenerator.height);
		uimux.setBounds(100, 10,UIMux2v1.width, UIMux2v1.height);
		uig3.setBounds(102, 120,UIGenerator.width, UIGenerator.height);
		uir.setBounds(150, 40,UIReceptor.width, UIReceptor.height);
		
		g1.addObservator(this);
		g2.addObservator(this);
		g3.addObservator(this);
		mux.addObservator(this);
		update();
		repaint();
	}
	
	public static void main(String[] args) {
		( new Mux2v1Frame() ).setVisible(true);
	}

	@Override
	public void update() {
		mux.setA(g1.getValue());
		mux.setB(g2.getValue());
		mux.setS(g3.getValue());
		r.setValue(mux.getO());
		repaint();
	}

}
