package componentsViews;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import componentsModels.Lut3v1;
import componentsModels.Observer;



public class UILut3v1 extends JPanel implements Observer, MouseListener{

	//Properties
	private Lut3v1 lut;
	private static final int cellheight = 20;
	private static final int leftCellWidth = 50;
	private static final int rightCellWidth = 20;
	public static final int height = cellheight*8;
	public static final int width = leftCellWidth + rightCellWidth;
	
	
	
	//Constructors
	public UILut3v1(){
		this(new Lut3v1() );
	}
	
	public UILut3v1(Lut3v1 lut){
		this.lut = lut;
		lut.addObserver(this);
		addMouseListener(this);
		
		Dimension d = new Dimension(width, height);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	
	//Graphics
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(leftCellWidth, 0, leftCellWidth, height); 	//Draw column separator
		for (int i=1; i<8; i++) {
			g.drawLine(0, cellheight*i, width-1, cellheight*i); //Draw row separator
		}
		for(int i=0; i<8; i++){
			//Fill the table
			String inputs = Integer.toBinaryString(8 | i).substring(1);
			String output = lut.getTruthTable().getOutputForInputs(inputs);
			g.drawString(inputs, 15, cellheight*(i+1)-5 );
			g.drawString(output, leftCellWidth+6, cellheight*(i+1)-5 );
		}
	}
	
	
	//Observer
	public void update(){
		repaint();
		System.out.println("UI update:	" + this.getClass());
	}

	
	//Mouse Listener
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(leftCellWidth<=x && x<= width && 0<=y && y<= height){
			int row = y/cellheight;
			String bin = Integer.toBinaryString(8 | row).substring(1);
			lut.getTruthTable().switchOutputForInputs(bin);
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
