package views;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

public class UserInputUI extends JPanel implements ActionListener{

	String label = "";
	String value = "0";
	JTextField labelField;
	JButton valueButton;
	
	public UserInputUI() {
		super();
		initialization();
		
	}

	public UserInputUI(String label) {
		super();
		this.label = label;
		initialization();
	}
	
	private void initialization() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new GridLayout(0, 2));
		labelField = new JTextField(label);
		valueButton = new JButton(value);
		valueButton.addActionListener(this);
		add(labelField);
		add(valueButton);
	}
	
	
	public void switchValue() {
		if(value == "0") {
			value = "1";
		}else{
			value = "0";
		}
		valueButton.setText(value);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switchValue();
	}

}
