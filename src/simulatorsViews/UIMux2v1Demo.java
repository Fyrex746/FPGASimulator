package simulatorsViews;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import componentsModels.Observer;
import componentsViews.UIGenerator;
import componentsViews.UIMux2v1;
import componentsViews.UIReceptor;
import simulatorsModels.Mux2v1Demo;
import sun.awt.SunGraphicsCallback.PaintHeavyweightComponentsCallback;



public class UIMux2v1Demo extends JPanel implements Observer{

	public static final int height = 200;
	public static final int width = 200;
	
	//Model
	private Mux2v1Demo muxDemo;
	
	//SubViews
	private UIGenerator uig1;
	private UIGenerator uig2;
	private UIGenerator uig3;
	private UIMux2v1 uimux;
	private UIReceptor uir;
	
	//Constructor
	public UIMux2v1Demo(){
		this(new Mux2v1Demo());
	}
	
	public UIMux2v1Demo(Mux2v1Demo muxDemo){
		this.muxDemo = muxDemo;
		muxDemo.addObserver(this);
		
		//JPanel config
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		
		//Init subviews
		uimux = new UIMux2v1(muxDemo.getMux());
		uig1 = new UIGenerator(muxDemo.getG1());
		uig2 = new UIGenerator(muxDemo.getG2());
		uig3 = new UIGenerator(muxDemo.getG3());
		uir = new UIReceptor(muxDemo.getR());
		
		//Add subviews
		add(uig1);
		add(uig2);
		add(uig3);
		add(uimux);
		add(uir);
		
		//Place subviews
		setLayout(null);
		uig1.setBounds(10, 70,UIGenerator.width, UIGenerator.height);
		uig2.setBounds(10, 110,UIGenerator.width, UIGenerator.height);
		uig3.setBounds(50, 20,UIGenerator.width, UIGenerator.height);
		uimux.setBounds(50, 60,UIMux2v1.width, UIMux2v1.height);
		uir.setBounds(100, 90,UIReceptor.width, UIReceptor.height);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(30, 80, 50, 80);
		g.drawLine(30, 120, 50, 120);
		g.drawLine(60, 40, 60, 60);
		g.drawLine(70, 100, 100, 100);
	}
	
	//Observer
	public void update() {
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Test Mux2v1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(UIMux2v1Demo.width, UIMux2v1Demo.height);
		frame.setResizable(false);
		frame.setContentPane(new UIMux2v1Demo());
		frame.setVisible(true);
	}
	
}
