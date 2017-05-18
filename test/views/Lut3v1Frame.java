package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Generator;
import model.Lut3v1;
import model.Mux2v1;
import model.Observator;
import model.Receptor;

public class Lut3v1Frame extends JFrame implements Observator{

	//Model
	Lut3v1 lut = new Lut3v1();
	Generator g1 = new Generator();
	Generator g2 = new Generator();
	Generator g3 = new Generator();
	Receptor r = new Receptor();
	
	//View
	UILut3v1 uilut = new UILut3v1(lut);
	UIGenerator uig1 = new UIGenerator(g1);
	UIGenerator uig2 = new UIGenerator(g2);
	UIGenerator uig3 = new UIGenerator(g3);
	UIReceptor uir = new UIReceptor(r);
	
	public Lut3v1Frame(){
		super();
		
		//config frame
		setTitle("Test Lut3v1");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		
		//config content panel
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.add(uig1);
		contentPanel.add(uig2);
		contentPanel.add(uig3);
		contentPanel.add(uilut);
		contentPanel.add(uir);
		
		//Place component
		contentPanel.setLayout(null);
		uig1.setBounds(50, 20,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(50, 60,UIGenerator.width, UIGenerator.height);
		uilut.setBounds(100, 10,UILut3v1.width, UILut3v1.height);
		uig3.setBounds(102, 120,UIGenerator.width, UIGenerator.height);
		uir.setBounds(150, 40,UIReceptor.width, UIReceptor.height);
		
		//Add Observer
		g1.addObservator(this);
		g2.addObservator(this);
		g3.addObservator(this);
		lut.addObservator(this);
		
		//update UI
		update();
		repaint();
	}

	public static void main(String[] args) {
		(new Lut3v1Frame()).setVisible(true);
	}

	
	@Override
	public void update() {
		String inputs = g1.getValue() + g2.getValue() + g3.getValue();
		try {
			lut.setInputs("000");
		} catch (Exception e) {
			e.printStackTrace();
		}
		r.setValue(lut.getOutput());
	}

}
