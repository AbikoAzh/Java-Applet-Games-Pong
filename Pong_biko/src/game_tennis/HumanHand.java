package game_tennis;

import java.awt.Color;
import java.awt.Graphics;

public class HumanHand {
	
	double y,Ymove;
	int x;
	boolean goUP,goDOWN;
	final double gravity = 0.94;
	
	HumanHand(){
		x=20;
		y=210;
		Ymove=0;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(x, (int)y, 20, 80);
		
	}
	
	public void move(){
		// this is the actually method that move hand up and down
		if(goUP){
			Ymove=Ymove-3;
		}
		else if(goDOWN){
			Ymove=Ymove+3;
		}
		else if(!goUP && !goDOWN){
			Ymove=Ymove*gravity;
		}
		
		if(Ymove >= 5){
			Ymove = 5;
		}
		
		if(Ymove <= -5){
			Ymove = -5;
		}
		if(y<0){
			y=0;
		}
		if(y > 420){
			y=420;
		}
		
		y=y+Ymove;
	}
	
	// this to get if the keyboard up and down pressed
	public void setgoup(boolean input){
		goUP = input;
	}
	public void setgodown(boolean input){
		goDOWN = input;
	}
	
	public int gety(){
		return (int)y;
	}
}
