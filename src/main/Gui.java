package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Gui extends JFrame{ 
	
	private Display display;
	private Window window;
	private String[] mode;
	private String input;
	private int max;
	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Gui(Window window, Frame frame, String[] mode) {
		super("Title");
		this.window=window;
		this.mode=mode;
		input="";
		max=70;
		
		display =new Display(this, frame, mode);
		add(display,BorderLayout.CENTER);
		
		//Mouse Handler
		HandlerClass handler=new HandlerClass();
		display.addMouseListener(handler);
		display.addMouseMotionListener(handler);
		
		//Exit key
		addKeyListener(
				new KeyAdapter() {
					public void keyPressed(KeyEvent ke) {  // handler
						if(ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
							if(mode[0].equals("Menu")) {
								System.exit(0);
							}else {
								window.setMode("Menu");
							}
							
						}
						if(mode[0].equals("Mode1")&&input.length()<max) {
							char c = ke.getKeyChar();
							if(Character.isLetterOrDigit(c)) {
								input=input+c;
							}
				        }
						if(mode[0].equals("Mode1")&&ke.getKeyCode() == KeyEvent.VK_BACK_SPACE&&input.length()!=0) {
				        	input=input.substring(0, input.length()-1);
				        }
				        if(mode[0].equals("Mode1")&&ke.getKeyCode() == KeyEvent.VK_SPACE&&input.length()<max) {
				        	input=input+" ";
				        }
				        if(mode[0].equals("Mode1")&&ke.getKeyCode() == KeyEvent.VK_ENTER) {
				        	frame.sendMessage(input, 1);
				        	input="";
				        }
				        if(mode[0].equals("Mode1")&&ke.getKeyCode() == KeyEvent.VK_COMMA&&input.length()<max) {
				        	input=input+",";
				        }
				        if(mode[0].equals("Mode1")&&ke.getKeyCode() == KeyEvent.VK_PERIOD&&input.length()<max) {
				        	input=input+".";
				        }
				        if(mode[0].equals("Mode1")&&ke.getKeyChar()=='?' &&input.length()<max) {
				        	input=input+"?";
				        }
					}
				}
		);
	}
	
	public void redraw() {
		display.redraw();
	}
	
	private class HandlerClass implements MouseListener,MouseMotionListener{

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}

		public void mousePressed(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			double x=e.getX();
			double y=e.getY(); 
			int size;
			int startX, startY;
			if(mode[0].equals("Menu")) {
				if((getWidth()/(3))<getHeight()/54) {
					size=getWidth()/(3);
				}else {
					size=getHeight()/(4);
				}
				startX=(int)((getWidth()/2.0)-((size*3)/2.0));
				startY=(int)((getHeight()/2.0)-((size*4)/2.0));
				
				if((x>startX&&x<(startX+(size*3)))&&(y>startY+(size*2)&&y<(startY+(size*4)))) {
					if(y<startY+(size*3)) {
						window.setMode("Mode1");
					}else if(y<startY+(size*4)) {
						System.exit(0);
					}
				}
			}else if(mode[0].equals("Mode1")) {
				int frameW=20;
				int frameH=20;
				if((getWidth()/frameW)<getHeight()/frameH) {
					size=getWidth()/frameW;
				}else {
					size=getHeight()/frameH;
				}
				startX=(int)((getWidth()/2.0)-((size*frameW)/2.0));
				startY=(int)((getHeight()/2.0)-((size*frameH)/2.0));
				
				if((y>startY&&y<startY+frameH*size) && (x>startX && x<startX+frameW*size)) {
					
					if(y<startY+size) {
						window.setMode("Menu");
					}else if(y>startY+size*(frameH-2)) {
						
					}
				}
			}
		}
		
		public void mouseMoved(MouseEvent arg0) {
			
		}
		
		public void mouseDragged(MouseEvent e) {
			
		}
	}
}
