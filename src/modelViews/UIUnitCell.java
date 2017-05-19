package modelViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Observer;
import model.UnitCell;

public class UIUnitCell extends JPanel implements Observer{

	//Properties
	private UnitCell uc = new UnitCell();
	public static final int length = 300;
	private static final int xlut = 30;
	private static final int ylut = 40;
	private static final int xlatch = xlut + UILut3v1.width + 40;
	private static final int ylatch = ylut + UILut3v1.height * 80/100;
	private static final int xmux = xlatch + UIDLatch.width + 40;
	private static final int ymux = ylut + UILut3v1.height/2 -10;
	private static final int xgen = xmux;
	private static final int ygen = ymux - 20 - UIGenerator.height;
	
	
	//UIComponent
	private UIMux2v1 uimux = new UIMux2v1();
	private UILut3v1 uilut = new UILut3v1();
	private UIDLatch uilatch = new UIDLatch();
	private UIGenerator uigen = new UIGenerator();
	
	//Constructor
	public UIUnitCell() {
		this(new UnitCell());
	}
	
	public UIUnitCell(UnitCell uc) {
		this.uc = uc;
		uc.addObserver(this);
		
		Dimension d = new Dimension(length, length);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.green));
		
		add(uimux);
		add(uilut);
		add(uilatch);
		add(uigen);
		
		setLayout(null);
		uimux.setBounds(xmux, ymux, UIMux2v1.width, UIMux2v1.height);
		uilut.setBounds(xlut, ylut, UILut3v1.width, UILut3v1.height);
		uilatch.setBounds(xlatch, ylatch, UIDLatch.width, UIDLatch.height);
		uigen.setBounds(xgen, ygen, UIGenerator.width, UIGenerator.height);
		
	}
	
	//Observator
	public void update() {
		repaint();
	}
}
