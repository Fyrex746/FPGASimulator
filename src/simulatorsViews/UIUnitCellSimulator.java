package simulatorsViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import componentsModels.Observer;
import componentsViews.UIGenerator;
import componentsViews.UIReceptor;
import componentsViews.UIUnitCell;
import simulatorsModels.UnitCellSimulator;

public class UIUnitCellSimulator extends JPanel implements Observer{

	public static final int height = 350;
	public static final int width = 600;
	
	//Model
	private UnitCellSimulator ucSimulator;
	
	//Views
	private UIGenerator uig1;
	private UIGenerator uig2;
	private UIGenerator uig3;
	private UIGenerator uiclk;
	private UIUnitCell uiuc;
	private UIReceptor uir;
	
	//Constructor
	public UIUnitCellSimulator(){
		this(new UnitCellSimulator());
	}
		
	public UIUnitCellSimulator(UnitCellSimulator lut) {
		//Add observer
		this.ucSimulator = lut;
		lut.addObserver(this);
		
		//JPanel config
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.white));
		
		//Init subviews
		uig1 = new UIGenerator(ucSimulator.getG1());
		uig2 = new UIGenerator(ucSimulator.getG2());
		uig3 = new UIGenerator(ucSimulator.getG3());
		uiclk = new UIGenerator(ucSimulator.getClk());
		uiuc = new UIUnitCell(ucSimulator.getUc());
		uir = new UIReceptor(ucSimulator.getR());
		
		//Add subviews
		add(uig1);
		add(uig2);
		add(uig3);
		add(uiclk);
		add(uiuc);
		add(uir);
		
		//Place component
		setLayout(null);
		uig1.setBounds(50, 80,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(80, 80,UIGenerator.width, UIGenerator.height);
		uig3.setBounds(110, 80,UIGenerator.width, UIGenerator.height);
		uiclk.setBounds(80, 120,UIGenerator.width, UIGenerator.height);
		uiuc.setBounds(150, 10,UIUnitCell.length, UIUnitCell.length);
		uir.setBounds(500, 100,UIReceptor.width, UIReceptor.height);
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
		frame.setSize(UIUnitCellSimulator.width * j + interspace*(j+1), UIUnitCellSimulator.height * i + interspace*(i+1));
		frame.setResizable(false);
		
		JPanel contentPanel = new JPanel();
		for (int c = 0; c < n; c++) {
			contentPanel.add(new UIUnitCellSimulator());
		}
		
		frame.setContentPane(contentPanel);
		frame.setVisible(true);
	}

}
