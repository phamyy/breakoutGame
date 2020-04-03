package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class sleigh extends Rectangle{
	
	static int height = 20, width = 20;
	int dx = 2;
	double dy = -2.00;
	
	
	
	public sleigh() {
		super(0,400,width,height);
	}
	
	public void update() {
		
		
		if(this.x > 800) {
			this.setLocation(0, 400);
		}
		
	this.translate(dx,(int) dy);	
	}
	
	public void draw(Graphics2D win) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
