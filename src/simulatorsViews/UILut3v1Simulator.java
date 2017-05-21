package simulatorsViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import componentsModels.Observer;
import componentsViews.UIGenerator;
import componentsViews.UILut3v1;
import componentsViews.UIReceptor;
import simulatorsModels.Lut3v1Simulator;

public class UILut3v1Simulator extends JPanel implements Observer{

	public static final int height = 200;
	public static final int width = 300;
	
	//Model
	private Lut3v1Simulator lutSimulator;
	
	//Views
	private UIGenerator uig1;
	private UIGenerator uig2;
	private UIGenerator uig3;
	private UILut3v1 uilut;
	private UIReceptor uir;
	
	//Constructor
	public UILut3v1Simulator(){
		this(new Lut3v1Simulator());
	}
		
	public UILut3v1Simulator(Lut3v1Simulator lut) {
		//Add observer
		this.lutSimulator = lut;
		lut.addObserver(this);
		
		//JPanel config
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.white));
		
		//Init subviews
		uig1 = new UIGenerator(lut.getG1());
		uig2 = new UIGenerator(lut.getG2());
		uig3 = new UIGenerator(lut.getG3());
		uilut = new UILut3v1(lutSimulator.getLut());
		uir = new UIReceptor(lut.getR());
		
		//Add subviews
		add(uig1);
		add(uig2);
		add(uig3);
		add(uilut);
		add(uir);
		
		//Place component
		setLayout(null);
		uig1.setBounds(20, 60,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(50, 60,UIGenerator.width, UIGenerator.height);
		uig3.setBounds(80, 60,UIGenerator.width, UIGenerator.height);
		uilut.setBounds(150, 10,UILut3v1.width, UILut3v1.height);
		uir.setBounds(250, 60,UIReceptor.width, UIReceptor.height);
	}


	//Observer
	public void update() {
		repaint();
		System.out.println("UI update:	" + this.getClass());
	}
	
	//Display Simulator
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Lut3v1 Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int j = 2;
		int i = 2;
		int n = i*j;
		int interspace = 20;
		frame.setSize(UILut3v1Simulator.width * j + interspace*(j+1), UILut3v1Simulator.height * i + interspace*(i+1));
		frame.setResizable(false);
		
		JPanel contentPanel = new JPanel();
		for (int c = 0; c < n; c++) {
			contentPanel.add(new UILut3v1Simulator());
		}
		
		frame.setContentPane(contentPanel);
		frame.setVisible(true);
	}

}
