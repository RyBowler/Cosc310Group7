package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.*;

import displays.*;

public class Display extends JPanel{
	
	Toolkit t=Toolkit.getDefaultToolkit();
	private Gui gui;
	private String[] mode;
	
	private MenuDisplay menu;
	private Mode1Display mode1Display;
	
	//game stuff
	
	public Display(Gui gui, Frame frame, String[] mode){
		this.gui=gui;
		this.mode=mode;
		menu=new MenuDisplay(gui);
		mode1Display=new Mode1Display(gui, frame);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(mode[0].equals("Menu")) {
			this.setBackground(new Color(80,80,80));
			menu.render(g);
			
		}else if(mode[0].equals("Mode1")) {
			//window background
			this.setBackground(new Color(20,20,20));
			mode1Display.render(g);
		}
	}
	
	public void redraw() {
		this.repaint();
	}
}