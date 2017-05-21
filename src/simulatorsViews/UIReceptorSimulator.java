package simulatorsViews;



import javax.swing.JFrame;
import javax.swing.JPanel;

import componentsModels.Observer;
import componentsViews.UIGenerator;
import componentsViews.UIReceptor;
import simulatorsModels.ReceptorSimulator;

public class UIReceptorSimulator extends JPanel implements Observer{

	//Model
	ReceptorSimulator receptorSimulator;
	
	//Views
	UIGenerator uigenerator;
	UIReceptor uireceptor;
	
	
	//Constructor
	public UIReceptorSimulator(){
		this(new ReceptorSimulator());
	}
	
	public UIReceptorSimulator(ReceptorSimulator receptorSimulator) {
		this.receptorSimulator = receptorSimulator;
		receptorSimulator.addObserver(this);
		
		uigenerator = new UIGenerator(receptorSimulator.getG());
		uireceptor = new UIReceptor(receptorSimulator.getR());
		
		setLayout(null);
		add(uigenerator);
		add(uireceptor);
		uigenerator.setBounds(50, 50, 20, 20);
		uireceptor.setBounds(100, 50, 20, 20);
	}

	



	//Observer
	public void update() {
		repaint();
		System.out.println("UI update:	" + this.getClass());
	}
	
	
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Generator Display Test");
		frame.setSize(200, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new UIReceptorSimulator());
		frame.setVisible(true);
	}
}
