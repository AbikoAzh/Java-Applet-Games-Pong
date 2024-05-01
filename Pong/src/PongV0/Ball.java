package PongV0;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	double xVel, yVel, x,y;
	
	public Ball(){
		x = 350;
		y = 250;
		xVel = getRandomSpeed() * getRandomDirection();
		yVel = getRandomSpeed() * getRandomDirection();
	}
	
	public double getRandomSpeed(){
		double mrs = Math.random();
		double rmsum = mrs * 3 +2;
		System.out.println("math random s= "+mrs);
		System.out.println("math random s*3+2="+rmsum);
		return(rmsum);
		
	}
	
	// we need from this method to dermind the direction of
	public int getRandomDirection(){
		double mrd =  Math.random();
		int rand =(int)(mrd * 2);
		System.out.println("math random d= "+mrd);
		System.out.println("math random d*2= "+mrd*2);
		System.out.println("rand int(mrd*2)= "+rand);
		if(rand == 1){
			System.out.println("rand 1 done");
			return 1;
		}else{
			System.out.println("rand -1 done");
			return -1;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10 , 20, 20);
		
	}
	
	
	public void checkpaddlecollision(Paddle p1, Paddle p2){
		if(x <= 50){
			if(y >= p1.getY() && y <= p1.getY() + 80){
				xVel= -xVel;
			}
		}
		else if(x >= 650){
			if(y >= p2.getY() && y <= p2.getY()+80){
				xVel = -xVel;
			}
		}
	}
	
	
	public void move(){
		x +=xVel;
		y +=yVel;
		if(y<10){
			yVel = -yVel;
		}
		
		if(y> 490){
			yVel = -yVel;
		}
	}
	
	public int getX(){

		return (int)x;
	}
	
	public int getY(){
		return (int)y;
	}
}
