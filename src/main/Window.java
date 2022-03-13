package main;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Window {
	
	private Gui gui;
	private Frame frame;
	
	private String[] mode=new String[1];
	
	public Window() {
		// Creates Window
		mode[0]="Menu";
		frame=new Frame();
		gui= new Gui (this, frame, mode);
		gui.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		gui.setUndecorated(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		
	}
	
	public void update() {
		gui.redraw();
	}
	
	public void setMode(String mode) {
		this.mode[0]=mode;
	}

}
