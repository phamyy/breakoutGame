package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class snow extends Rectangle{

	Color col = Color.white;
	static double gravity = .3;
	static double dx;
	static double dy = 5.0;
	static double randomX;
	static double randomY;
	static int size = 5;
	Random rand = new Random();
	int startX = rand.nextInt(800);
	int startY = rand.nextInt(800);
	
	
		
	
	public snow() {
		
		super(0,0,size,size);
		
		this.setLocation(startX, startY);
		
		
	}
	
	public void update() {		
		
		
		if(rand.nextInt(2) ==1) {
			dx = 2* rand.nextDouble();
		}else {
			dx = -2 * rand.nextDouble();
		}
		
		dy = 2*rand.nextInt(2);
		
		dy+=gravity;
		
		this.translate((int) dx, (int)dy);
		
		if(this.y>600) {
			this.setLocation(this.startX,0);
		}
		
		
	}
	
	
	
	public void draw (Graphics2D win ) {
		
		win.setColor(col);
		win.fill(this);
	}
	
	
	
	
	
	
	
}
