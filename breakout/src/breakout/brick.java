package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class brick extends Rectangle {

	boolean isVisible = true;

	// instance fields(for one brick)

	Color currentColor;
	Color sage = new Color(128,128,0);
	Color crimson = new Color(123,17,19);
	
	int lives = 3;

	// static fields (all bricks)
	static int width = 35, height = 20, BUFFER = 5;
	static boolean boomTown = false;

	// constructor
	public brick(int x, int y, int lives) {

		// super refers to the parent class - rectangle in this case
		super(x, y, width, height);

		this.lives = lives;

	}

	public void update() {

	}

	public void hit() {

		lives--;
		if (lives==0) {
			boomTown = true;
			
		}

	}

	public void draw(Graphics2D win) {

		if (this.lives == 3) {
			currentColor = crimson;
		}
		if (this.lives == 2) {
			currentColor = sage;
		}
		if (this.lives == 1) {
			currentColor = Color.white;
		}
		if (lives > 0) {
			win.setColor(this.currentColor);
			win.fill(this);
		}
	}

}
