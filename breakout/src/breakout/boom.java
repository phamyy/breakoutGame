package breakout;

import java.awt.Graphics2D;

public class boom {

	
	particle[] parts = new particle[100];
	
	
	public boom(ball gameBall) {
		
		for(int i = 0; i < parts.length; i++) {
			parts[i] = new particle(gameBall);
			
			
		}
		
		
		
		
		
	}
	
	
	public void update() {
		for(particle p : parts) {
			p.update();
			
			
		}
		
		
	}
	
	
	
	public void draw(Graphics2D win) {
		for (particle p : parts) {
			p.draw(win);
		}
	}
	
	
	
	
	
	
	
}
