package componentsViews;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import componentsModels.Observer;
import componentsModels.UnitCell;

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
	private UIMux2v1 uimux;
	private UILut3v1 uilut;
	private UIDLatch uilatch;
	private UIGenerator uigen;
	
	//Constructor
	public UIUnitCell() {
		this(new UnitCell());
	}
	
	public UIUnitCell(UnitCell uc) {
		this.uc = uc;
		uc.addObserver(this);
		
		//Init subviews
		uimux = new UIMux2v1(uc.getMux());
		uilut = new UILut3v1(uc.getLut());
		uilatch = new UIDLatch(uc.getLatch());
		uigen = new UIGenerator(uc.getMuxSelector());
		
		//JPanel config
		Dimension d = new Dimension(length, length);
		setPreferredSize(d);
		setBorder(BorderFactory.createLineBorder(Color.green));
		
		//Add subviews
		add(uimux);
		add(uilut);
		add(uilatch);
		add(uigen);
		
		//Place subviews
		setLayout(null);
		uimux.setBounds(xmux, ymux, UIMux2v1.width, UIMux2v1.height);
		uilut.setBounds(xlut, ylut, UILut3v1.width, UILut3v1.height);
		uilatch.setBounds(xlatch, ylatch, UIDLatch.width, UIDLatch.height);
		uigen.setBounds(xgen, ygen, UIGenerator.width, UIGenerator.height);
		
	}
	
	
	//Get
	public UnitCell getUc() {
		return uc;
	}

	//Observer
	public void update() {
		repaint();
		System.out.println("UI update:	" + this.getClass());
	}
}
