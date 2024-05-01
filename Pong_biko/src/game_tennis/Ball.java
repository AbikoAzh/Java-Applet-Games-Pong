package game_tennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Ball {

	int x,y;
	int xmove, ymove;
	int count, speed, level;
	// chkball: to check if the circle touch the hand
	// start: to check if the game start to display the info about game 
	boolean chkball,start;
	
	HumanHand hand = new HumanHand();
	
	Ball(){
		x=350;
		y=250;
		xmove=4;
		ymove=1;
		count = 0;
		level=1;
		speed=4;
		start = false;
	}
	
	public void drawb(Graphics g){
		if(chkball){
			g.setColor(Color.red);
			g.fillOval(x-10, y-10, 20, 20);
		}else{
			g.setColor(Color.BLACK);
			g.fillOval(x-10, y-10, 20, 20);
			if(start){
				g.setFont(new Font("Calibri",Font.BOLD,15));
				g.drawString("#Level: "+level+"  #Speed: "+speed, 320, 20);
			}
			
		}
	}
	
	public void moveb(){
		
		x=x+ xmove;
		y=y+ ymove;
		
		System.out.println("move before "+" x= "+x+" y= "+y+" ,counnt= "+count+" ,xmove= "+xmove);
			if(y<10){
				ymove=-ymove;
			}else
			if(y>490){
				ymove=-ymove;
			}else
			if(x>690){
				xmove=-xmove;
			}
			System.out.println("move after "+" x= "+x+" y= "+y+" ,counnt= "+count+" ,xmove= "+xmove);
	}
	
	// this method for increase speed over time
	public void speed(){
		if(count >6 && count < 8 ){
			System.out.println("speed#2 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#2 ######## done after ,xmove= "+xmove);
			
		}else if(count >16 && count < 18){
			System.out.println("speed#3 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#3 ######## done after ,xmove= "+xmove);
			
		}else if(count >34 && count < 36){
			System.out.println("speed#4 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#4 ######## done after ,xmove= "+xmove);
			
		}else if(count >59 && count < 61){
			System.out.println("speed#5 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#5 ######## done after ,xmove= "+xmove);
		}else if(count >84 && count < 86){
			System.out.println("speed#6 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#6 ######## done after ,xmove= "+xmove);
		}else if(count >109 && count < 111){
			System.out.println("speed#7 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#7 ######## done after ,xmove= "+xmove);
		}else if(count >134 && count < 136){
			System.out.println("speed#8 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#8 ######## done after ,xmove= "+xmove);
		}else if(count >159 && count < 161){
			System.out.println("speed#9 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#9 ######## done after ,xmove= "+xmove);
		}else if(count >184 && count < 186){
			System.out.println("speed#10 ######## done before ,xmove= "+xmove);
			
			if(chkball){
				xmove +=1;
				speed +=1;
				level+=1;
				chkball =false;
			}
			System.out.println("speed#10 ######## done after ,xmove= "+xmove);
		}
	}
	
	public void checkball(HumanHand p1){
		chkball = false;
		if(y>= p1.gety()-10 && y<=p1.gety()+90){
			if(x==50){
				xmove=-xmove;
				count +=1;
				System.out.println("########## count= "+count);
				chkball =true;
			}
		}
		speed();
	}
	
	public int gety(){
		return y;
	}
	
	public int getx(){
		return x;
	}
}
