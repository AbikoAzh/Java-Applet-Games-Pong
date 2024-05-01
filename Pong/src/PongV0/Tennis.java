package PongV0;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// any java applet must content graphics and applet class

public class Tennis extends Applet implements Runnable,KeyListener{
	
	// this for rectangle
	final int WIDTH = 700 , HEIGHT = 500;
	
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	boolean gameStarted;
	
	// this for last amazing enhance
	Graphics gfx;
	Image img;
	
	
	//basic method
	public void init(){
		this.resize(WIDTH,HEIGHT);
		gameStarted = false;
		this.addKeyListener(this);
		
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2,b1);
		
		// here amazing enhance - we can remove it
		img = createImage(WIDTH,HEIGHT);
		gfx = img.getGraphics();
		
		thread = new Thread(this);
		thread.start();
	}
	
	//basic method
	public void paint(Graphics g){
		
		// here amazing enhance: by using gfx instead of g
		// like here: g.setColor(Color.black); then gfx.setColor(Color.black);
		// we can remove gfx and using just g
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(b1.getX() < -10 || b1.getX() > 710){
			gfx.setColor(Color.red);
			gfx.drawString("Game Over", 340, 250);
			gfx.drawString("Designed And Developed By Abubaker Azhari", 240, 490);
		}else{
			p1.draw(gfx);
			b1.draw(gfx);
			p2.draw(gfx);
			gfx.drawString("Designed And Developed By Abubaker Azhari", 240, 490);
		}
		
		if(!gameStarted){
			gfx.setColor(Color.white);
			gfx.drawString("Tennis", 340, 100);
			gfx.drawString("Press Enter to Begin.. ", 310, 130);
			gfx.drawString("Designed And Developed By Abubaker Azhari", 240, 490);
		}
		
		// this for amazing enhance - we can remove it all
		g.drawImage(img, 0, 0, this);
	}
	
	//basic method
	public void update(Graphics g){
		paint(g);
		
	}

	// this to run in time
	public void run() {
		for(;;){
			if(gameStarted ){
				p1.movs();
				p2.movs();
				b1.move();
				b1.checkpaddlecollision(p1, p2);
			}
			repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// if i pressed the up key
		if(e.getKeyCode() == KeyEvent.VK_UP){
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			p1.setDownAccel(true);
		}else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			gameStarted = true;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// if we pressed and released
		if(e.getKeyCode() == KeyEvent.VK_UP){
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
		p1.setDownAccel(false);	
		}
	}

}