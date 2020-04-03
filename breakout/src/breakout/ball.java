package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;

import utilities.GDV5;

public class ball extends Rectangle {

	Color currentColor = Color.red;
	
	static int width = 15, height =15;
	static int ballDx = 0, ballDy = 0;
	int lives = 3;
	
	

	public ball(int x, int y ) {
		super(x,y,width,height);
		
		this.lives =lives;
	}
	
	Random rand = new Random();
	
	
	public int collisionDirection(Rectangle stationary, Rectangle projectile, int dx, int dy) {

		// calculate previous location
		int previousXPos = (int) projectile.getX() - dx;
		int previousYPos = (int) projectile.getY() - dy;
		int height = (int) projectile.getHeight();
		int width = (int) projectile.getWidth();
		int result = 0; // default intersects from right

		if (previousYPos + height <= stationary.getY() && projectile.getY() + height >= stationary.getY()) {
			// intersects from top
			result = 1;
		} else if (previousXPos + width <= stationary.getX() && projectile.getX() + width >= stationary.getX()) {
			// intersects from left
			result = 2;
		} else if (previousYPos >= stationary.getY() + stationary.height
				&& projectile.getY() <= stationary.getY() + stationary.height) {
			// intersects from bottom
			result = 3;
		}

		return result;

	}
	
	
	


	
	
	public void update() {
		
		//ball reset
		if(this.getMaxY()>600){
			this.setLocation(400,400);
			ballDx = 0;
			ballDy = 0;
			lives--;
		}
		//bounce of paddle
		if(this.intersects(breakout.newPaddle)) {
			this.ballDy = -this.ballDy;
		}
		
		//bounce off wall
		if(this.x + ballDx < 0 || this.getX() + ballDx > 785) {
					ballDx = -ballDx;
		}
		//bounce off ceiling
		if(this.y<0) {
			ballDy=-ballDy;
		}
		if(GDV5.KeysPressed[KeyEvent.VK_T]) {
			ballDx = rand.nextInt(2)- 3;
			ballDy = rand.nextInt(2)- 3;
		}
		
		

		
		
		
		
		for(brick b: breakout.wall) {
			if(this.intersects(b) && b.lives > 0) {
				
				int dir = collisionDirection(b, breakout.gameBall, ballDx, ballDy); 
				
				b.hit();
				
				
				// 0 or 2
				
				if (dir == 0 || dir == 2) {
					
					ballDx *= -1.15;
					breakout.audio.play(2);
					
					
				} else {
					
					ballDy *= -1.15;
					breakout.audio.play(2);
					
				}
				

			}
		}
		
				
				
		this.translate(ballDx, ballDy);
	}
	
	
	
	public void draw(Graphics2D win) {
	
		win.setColor(currentColor);
		//win.fill(this);
		win.fillOval(this.x, y, width, height);
		
		
		
		
		
	}
}
