package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Generator;
import model.Observer;
import model.Receptor;
import model.UnitCell;

public class UnitCellFrame extends JFrame implements Observer{

	//Models
	UnitCell uc = new UnitCell();
	Generator g1 = new Generator();
	Generator g2 = new Generator();
	Generator g3 = new Generator();
	Generator clk = new Generator();
	Receptor r = new Receptor();
	
	//Views
	UIUnitCell uiuc = new UIUnitCell(uc);
	UIGenerator uig1 = new UIGenerator(g1);
	UIGenerator uig2 = new UIGenerator(g2);
	UIGenerator uig3 = new UIGenerator(g3);
	UIGenerator uiclk = new UIGenerator(clk);
	UIReceptor uir = new UIReceptor(r);
	
	//Constructor
	public UnitCellFrame() {
		super();
		
		//config frame
		setTitle("Test Mux2v1");
		setSize(1000, 1000);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		
		//config content panel
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.add(uig1);
		contentPanel.add(uig2);
		contentPanel.add(uig3);
		contentPanel.add(uiclk);
		contentPanel.add(uiuc);
		contentPanel.add(uir);
		
		//Place component
		contentPanel.setLayout(null);
		uig1.setBounds(50, 20,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(50, 60,UIGenerator.width, UIGenerator.height);
		uig3.setBounds(50, 100,UIGenerator.width, UIGenerator.height);
		uiclk.setBounds(50, 140,UIGenerator.width, UIGenerator.height);
		uiuc.setBounds(100, 10,UIUnitCell.length, UIUnitCell.length);
		uir.setBounds(500, 80,UIReceptor.width, UIReceptor.height);
		
		//Add Observer
		g1.addObserver(this);
		g2.addObserver(this);
		g3.addObserver(this);
		clk.addObserver(this);
		
		//update UI
		update();
	}

	public static void main(String[] args) {
		( new UnitCellFrame() ).setVisible(true);
	}
	
	@Override
	public void update() {
		String lutInputs = g1.getValue() + g2.getValue() + g3.getValue();
		uc.setLutInputs(lutInputs);
		uc.setClk(clk.getValue());
		r.setValue(uc.getOutput());
		repaint();
	}
}
