package views;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeneratorFrame {

	public GeneratorFrame() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("Test Generator");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		
		JPanel contentPanel = new JPanel();
		for (int i = 0; i < 10; i++) {
			contentPanel.add(new UIGenerator());
		}
		
		frame.setContentPane(contentPanel);
		frame.setVisible(true);
	}

}
