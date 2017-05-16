package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeneratorFrame extends JFrame{

	public GeneratorFrame() {
		super();
		setTitle("Test Generator");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.white);
		
		JPanel contentPanel = new JPanel();
		for (int i = 0; i < 10; i++) {
			contentPanel.add(new UIGenerator());
		}
		setContentPane(contentPanel);
	}

	public static void main(String[] args) {
		(new GeneratorFrame()).setVisible(true);
	}

}
