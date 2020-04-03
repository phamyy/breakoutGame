package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class paddle extends Rectangle{
	Color currentColor = Color.red;
	static int width = 75, height = 25;
	int dx = 1;
	
	
	public paddle(int x, int y) {
		super(x,y,width,height);
	}
	
	
	public void update() {
	
		
		
	
		if(this.getX() + dx < 0) {
			dx=0;
		}
		if(this.getMaxX() + dx > breakout.WIDTH) {
			dx=0;
		}
		if(GDV5.KeysPressed[KeyEvent.VK_A]) {
			dx = -5;
		}
		if(GDV5.KeysPressed[KeyEvent.VK_D]) {
			dx = 5;
		}
	
			
			
		
		
		this.translate(dx, 0);
	}
	
	
	public void draw(Graphics2D win) {
		win.setColor(currentColor);
		win.fill(this);
	}
	
	
}
