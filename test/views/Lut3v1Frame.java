package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import componentsModels.Generator;
import componentsModels.Lut3v1;
import componentsModels.Observer;
import componentsModels.Receptor;
import componentsViews.UIGenerator;
import componentsViews.UILut3v1;
import componentsViews.UIReceptor;




public class Lut3v1Frame extends JFrame implements Observer{

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
		uig3.setBounds(50, 100,UIGenerator.width, UIGenerator.height);
		uilut.setBounds(100, 10,UILut3v1.width, UILut3v1.height);
		uir.setBounds(200, 60,UIReceptor.width, UIReceptor.height);
		
		//Add Observer
		g1.addObserver(this);
		g2.addObserver(this);
		g3.addObserver(this);
		lut.getTruthTable().addObserver(this);
		
		//update UI
		update();
	}

	public static void main(String[] args) {
		(new Lut3v1Frame()).setVisible(true);
	}

	
	@Override
	public void update() {
		String inputs = g1.getValue() + g2.getValue() + g3.getValue();
		lut.setInputs(inputs);
		r.setValue(lut.getOutput());
		repaint();
	}

}
