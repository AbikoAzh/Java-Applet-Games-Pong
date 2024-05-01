package game_tennis;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GTennis extends Applet implements Runnable,KeyListener{

	final int Width = 700, Height = 500;
	Thread thread;
	// gamestart: to know if the game start or no;
	// pause: to know and control the pause
	boolean gamestart , pause;
	HumanHand hand;
	Ball ball;
	
	// this to intilize the compount
	public void init(){
		
		ball = new Ball();
		hand=new HumanHand();
		
		this.resize(Width, Height);
		
		this.addKeyListener(this);
		
		thread = new Thread(this);
		thread.start();
		gamestart = false;
		pause = false;
	}
	
	// this is main method to draw graphics
	public void paint(Graphics g){
		if(gamestart){
			g.setColor(Color.lightGray);
			g.fillRect(0,0,Width, Height);
			
			if(!pause){
				g.setColor(Color.red);
				g.fillRect(310, 220, 8, 25);
				g.fillRect(325, 220, 8, 25);
				g.setFont(new Font("Calibri",Font.BOLD,40));
				g.drawString("Pause", 350, 245);
			}
		}else{
			g.setColor(new Color(150,150,250));
			g.fillRect(0,0,Width, Height);
		}
		
		
		if(!gamestart){
			g.setColor(Color.BLUE);
			g.setFont(new Font("Calibri",Font.BOLD,16));
			g.drawString("Please Press Enter ...", 280, 100);
			g.drawString("Designed and Developed By Abubaker Azhari", 205, 480);
		
		}
		
		if(ball.x<0){
			g.setColor(Color.red);
			g.fillRect(280, 55, 30, 10);
			g.fillRect(280, 55, 10, 30);
			g.fillRect(280, 85, 40, 10);
			g.fillRect(310, 55, 10, 30);
			
			g.fillRect(330, 55, 30, 10);
			g.fillRect(330, 55, 10, 30);
			g.fillRect(330, 85, 40, 10);
			g.fillRect(360, 55, 10, 30);
			
			g.fillRect(380, 55, 30, 10);
			g.fillRect(380, 55, 10, 30);
			g.fillRect(380, 85, 40, 10);
			g.fillRect(410, 55, 10, 30);
			
			g.setFont(new Font("Calibri",Font.BOLD,16));
			g.drawString("Game Over", 310, 200);
			g.drawString("Your Access Level "+ball.level, 283, 220);
			g.drawString("To Play Again.. Press Enter ", 255, 240);
			ball.level =1;
			ball.start=false;
			gamestart=false;
			pause = false;
			ball.x=350;
			ball.xmove =4;
			ball.speed =4;
			ball.count=0;
			g.drawString("Designed and Developed By Abubaker Azhari", 205, 480);
		}else{
		
			hand.draw(g);
			ball.drawb(g);
			
		}
	}
	

	@Override
	public void run() {
		for(;;){
			
			if(gamestart){
	
				if(pause){
					hand.move();
					ball.moveb();
					ball.checkball(hand);
					
				}
				repaint();
			}
			
			try {
				
				Thread.sleep(10);
	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			hand.setgoup(true);
			
		}else 
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			hand.setgodown(true);	
				
		}else
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			gamestart = true;
			ball.start=true;
			pause= !pause;
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			hand.setgoup(false);
			
		}else 
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			hand.setgodown(false);	
				
		}
		
	}
}
