package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReceptorFrame extends JFrame{

	public ReceptorFrame() {
		super();
		setTitle("Test Receptor");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		UIGenerator uigenerator = new UIGenerator();
		UIReceptor uireceptor = new UIReceptor();
		contentPanel.add(uigenerator);
		contentPanel.add(uireceptor);
		uigenerator.setBounds(50, 50, 20, 20);
		uireceptor.setBounds(100, 50, 20, 20);
		setContentPane(contentPanel);
		repaint();
	}
	
	public static void main(String[] args) {
		( new ReceptorFrame() ).setVisible(true);
	}

}
