package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.DLatch;
import model.Generator;
import model.Mux2v1;
import model.Observer;
import model.Receptor;
import modelViews.UIDLatch;
import modelViews.UIGenerator;
import modelViews.UIReceptor;

public class DLatchFrame extends JFrame implements Observer{

	//Model
		DLatch latch = new DLatch();
		Generator g1 = new Generator();
		Generator g2 = new Generator();
		Receptor r = new Receptor();
		
		//View
		UIDLatch uilatch = new UIDLatch(latch);
		UIGenerator uig1 = new UIGenerator(g1);
		UIGenerator uig2 = new UIGenerator(g2);
		UIReceptor uir = new UIReceptor(r);
	
	public DLatchFrame() {
		super();
		
		//config frame
		setTitle("Test DLatch");
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		
		//config content panel
		JPanel contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.add(uig1);
		contentPanel.add(uig2);
		contentPanel.add(uilatch);
		contentPanel.add(uir);
		
		//Place component
		contentPanel.setLayout(null);
		uig1.setBounds(50, 20,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(50, 60,UIGenerator.width, UIGenerator.height);
		uilatch.setBounds(100, 10,UIDLatch.width, UIDLatch.height);
		uir.setBounds(150, 40,UIReceptor.width, UIReceptor.height);
		
		//Add Observer
		g1.addObserver(this);
		g2.addObserver(this);
		
		//update UI
		update();
	}

	public static void main(String[] args) {
		(new DLatchFrame()).setVisible(true);
	}
	
	public void update() {
		latch.setD(g1.getValue());
		latch.setH(g2.getValue());
		r.setValue(latch.getQ());
		repaint();
	}
}
