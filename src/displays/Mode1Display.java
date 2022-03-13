package displays;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import main.Frame;
import main.Gui;
import objects.Message;

public class Mode1Display{
	
	private Gui gui;
	private Frame frame;
	private int size,startX,startY,frameW,frameH;
	
	public Mode1Display(Gui gui, Frame frame){
		this.gui=gui;
		this.frame=frame;
		frameW=20;
		frameH=20;
	}
	
	public void render(Graphics g) {
		if((gui.getWidth()/frameW)<gui.getHeight()/frameH) {
			size=gui.getWidth()/frameW;
		}else {
			size=gui.getHeight()/frameH;
		}
		startX=(int)((gui.getWidth()/2.0)-((size*frameW)/2.0));
		startY=(int)((gui.getHeight()/2.0)-((size*frameH)/2.0));
		
		//Text background
		g.setColor(new Color(200, 200, 200));
		g.fillRect(startX, startY, size*frameW, size*frameH);
		
		//Mid takes 15 tile sizes 4-18
		
		int messageHeight=4;
		Message[] messages=frame.getMessages();
		
		for(int i=0; i<messages.length; i++) {
			messageHeight=drawMessage(g, messages[i], messageHeight)+1;
		}
		
		
		//Top takes 1 tile size
		for(int y=frameH; y>18; y--) {
			for(int x=0; x<frameW;x++) {
				g.setColor(new Color(40, 40, 50));
				g.fillRect(startX+size*x, startY+size*((frameH-1)-y), size, size);
			}
		}
		Font font=new Font("arial", Font.BOLD, (int)(size/2.0));
		g.setFont(font);
		g.setColor(new Color(200, 200, 200));
		g.drawString("Back to Menu", startX+size*9, startY+size*((frameH-1)-18)-(int)(size*0.4));
				
		//Bottom takes 3 tile sizes
		for(int y=0; y<3; y++) {
			for(int x=0; x<frameW;x++) {
				g.setColor(new Color(40, 40, 50));
				g.fillRect(startX+size*x, startY+size*((frameH-1)-y), size, size);
			}
		}
		g.setColor(new Color(100, 100, 100));
		g.fillRect(startX+(int)(size*0.5), startY+size*((frameH-1)-2)+(int)(size*0.5), size*(frameW-1), size*2);
		drawInput(g);
		
	}
	
	private int drawMessage(Graphics g, Message message, int height) {
		int h=1;
		String m=message.getText();
		
		if(message.getID()==0) {
			while(message.getText().length()/(3.0*h)>8) {
				h++;
			}
			for(int y=0; y<h; y++) {
				for(int x=1; x-1<message.getText().length()/(3.0) && x-1!=8; x++) {
					g.setColor(new Color(140, 140, 150));
					g.fillRect(startX+size*x, startY+size*((frameH-1)-height-y), size, size);
				}
			}
			for(int level=0; level<h; level++) {
				int i=0;
				for(int y=(int)(3.0*8); y!=-1; y--) {
					if(y>m.length()) {
						y=m.length();
						i=y;
						break;
					}
					if(m.charAt(y)==' ') {
						i=y;
						break;
					}
					if(y==0) {
						i=(int)(3.0*8);
						break;
						
					}
				}
				Font font=new Font("arial", Font.BOLD, (int)(size/2.0));
				g.setFont(font);
				g.setColor(new Color(0, 0, 0));
				String temp=m.substring(0, i);
				g.drawString(m.substring(0, i), startX+(int)(size*1.5), startY+size*((frameH-1)-(height+(h-1)-level-1))-((int)(0.4*size)));
				m=m.substring(i, m.length());
			}
		}else {
			while(message.getText().length()/(3.0*h)>8) {
				h++;
			}
			for(int y=0; y<h; y++) {
				for(int x=1; x-2<message.getText().length()/(3.0) && x-1!=8; x++) {
					g.setColor(new Color(80, 100, 150));
					g.fillRect(startX-size*x+size*(frameW-1), startY+size*((frameH-1)-height-y), size, size);
				}
			}
			for(int level=0; level<h; level++) {
				int i=0;
				for(int y=(int)(3.0*8); y!=-1; y--) {
					if(y>=m.length()) {
						y=m.length();
						i=y;
						break;
					}
					if(m.charAt(y)==' ') {
						i=y;
						break;
					}
					if(y==0) {
						i=(int)(3.0*8);
						break;
					}
				}
				Font font=new Font("arial", Font.BOLD, (int)(size/2.0));
				g.setFont(font);
				g.setColor(new Color(0, 0, 0));
				String temp=m.substring(0, i);
				if(message.getText().length()/(3.0)>=8) {
					g.drawString(m.substring(0, i), startX+(int)(size*1.5)+size*frameW-(10*size), startY+size*((frameH-1)-(height+(h-1)-level-1))-((int)(0.4*size)));
				}else {
					g.drawString(m.substring(0, i), startX+(int)(size*1.5)+size*frameW-size*((int)(message.getText().length()/(3.0))+3), startY+size*((frameH-1)-(height+(h-1)-level-1))-((int)(0.4*size)));
				}
				m=m.substring(i, m.length());
			}
		}
		return height+h;
	}
	
	public void drawInput(Graphics g){
		String input=gui.getInput();
		Font font=new Font("arial", Font.BOLD, (int)(size/4.0));
		g.setFont(font);
		g.setColor(new Color(0, 0, 0));
		g.drawString(input, startX+size*1, startY+size*((frameH-2)));
		if(input.equals("")) {
			g.drawString("Max of 30 characters per question.", startX+size*1, startY+size*((frameH-2)));
		}
	}
	
}