package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class powerUp extends Rectangle{
	
	static int height = 20, width = 20;
	static int dy = 0;
	boolean canSee = false;
	
	
	boom hit = null;
	
	
	
	public powerUp() {
		super(0,0, width,height);
		
		
		
			this.setLocation((breakout.newPaddle.x), (breakout.newPaddle.y));
			
		
		
		
	}
	
	public void update() {
		
		
		if(breakout.bricksBroken % 5 ==0  && this.dy > -10) {
			dy=-10;
			canSee = true;
		}
		
		
		if(this.y<0) {
			this.setLocation((breakout.newPaddle.x), (breakout.newPaddle.y));
			canSee = false;
			dy=0;
		}
		
		for( brick b : breakout.wall) {
			if(this.intersects(b)) {
				b.setSize(0, 0);
				breakout.bricksBroken ++;
				
			}
				
		}
		
		this.translate(0, dy);
	}
	
	
	public void draw (Graphics2D win) {
		
		if(canSee) {
		win.setColor(Color.white);
		win.fill(this);
		}
	}
	
	
}
