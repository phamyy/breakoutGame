package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class particle extends Rectangle {

	double dx, dy;
	static int size = 5;
	static double gravity = .3;
	int range = 5;

	Color col = Color.white;

	public particle(ball gameBall) {

		super(gameBall.x, gameBall.y, size, size);

		// random vectors

		Random rand = new Random();
		rand.nextGaussian();
		dx = range * rand.nextGaussian();

		dy = range * rand.nextGaussian();

	}

	public void update() {

		dy += gravity;
		this.translate((int) dx, (int) dy);

	}

	public void draw(Graphics2D win) {

		win.setColor(col);
		win.fill(this);

	}

}
