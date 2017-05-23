package simulatorsViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import componentsModels.Observer;
import componentsViews.UIDLatch;
import componentsViews.UIGenerator;
import componentsViews.UIReceptor;
import simulatorsModels.DLatchSimulator;

public class UIDLatchSimulator extends JPanel implements Observer{
	
	public static final int height = 100;
	public static final int width = 200;
	
	//Model
	private DLatchSimulator dlatchSimulator;

	
	//Subviews
	private UIGenerator uig1;
	private UIGenerator uig2;
	private UIDLatch uidlatch;
	private UIReceptor uir;

	
	//Constructor
	public UIDLatchSimulator() {
		this(new DLatchSimulator());
	}
	
	public UIDLatchSimulator(DLatchSimulator dlatchSimulator) {
		//Init simulator
		this.dlatchSimulator = dlatchSimulator;
		dlatchSimulator.addObserver(this);
		
		//JPanel config
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.white));
		
		//Init subviews
		uig1 = new UIGenerator(dlatchSimulator.getG1());
		uig2 = new UIGenerator(dlatchSimulator.getG2());
		uidlatch = new UIDLatch(dlatchSimulator.getDlatch());
		uir = new UIReceptor(dlatchSimulator.getR());
		
		//Add subviews
		add(uig1);
		add(uig2);
		add(uidlatch);
		add(uir);
		
		//Place subviews
		setLayout(null);
		uig1.setBounds(20, 20,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(20, 60,UIGenerator.width, UIGenerator.height);
		uidlatch.setBounds(80, 20,UIDLatch.width, UIDLatch.height);
		uir.setBounds(160, 40,UIReceptor.width, UIReceptor.height);		
		
	}

	
	//Get
	public UIDLatch getUidlatch() {
		return uidlatch;
	}

	//Observer
	public void update() {
		repaint();
		System.out.println("UI update:	" + this.getClass());
	}
	
	//Display Simulator
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("DLatch Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int j = 3;
		int i = 2;
		int n = i*j;
		int interspace = 20;
		frame.setSize(UIDLatchSimulator.width * j + interspace*(j+1), UIDLatchSimulator.height * i + interspace*(i+1));
		frame.setResizable(false);
		
		JPanel contentPanel = new JPanel();
		for (int c = 0; c < n; c++) {
			contentPanel.add(new UIDLatchSimulator());
		}
		
		frame.setContentPane(contentPanel);
		frame.setVisible(true);
	}

}
