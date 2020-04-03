package breakout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import utilities.GDV5;
import utilities.SoundDriverHo;

public class breakout extends GDV5 {

	static SoundDriverHo audio;
	static int rows = 3;
	static int coloums = 35;
	boolean mainScreen = true;
	boolean breakOutGame = false;
	boolean imageLoaded;
	boolean gameOver = false;
	boolean rulesPage = false;
	boolean winPage = false;
	static int bricksBroken = 1;
	
	
	
	
	
	Color gameColor = new Color(211, 211, 211);
	Color skyColor = new Color(135,206,235);

	static brick[] wall = new brick[rows * coloums];

	static paddle newPaddle = new paddle(250, 550);

	static ball gameBall = new ball(400, 425);
	
	static powerUp reinDeer = new powerUp();
	
	static sleigh Sleigh = new sleigh();

	boom hit = null;

	snow[] snowFall = new snow[25];

	BufferedImage lights;
	BufferedImage bg;
	BufferedImage Santa;
	BufferedImage keys;
	BufferedImage reindeer;
	BufferedImage sleigh;

	public breakout() {

		
		lights = this.addImage("/breakout/lightspng.png");
		bg = this.addImage("/breakout/bg.JPG");
		Santa = this.addImage("/breakout/pixel-santa-claus_41992-154.jpg");
		keys = this.addImage("/breakout/keys.png");
		reindeer = this.addImage("/breakout/reindeer.png");
		sleigh = this.addImage("/breakout/sleigh.png");

		

		// create wall

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < coloums; j++) {
				wall[i * coloums + j] = new brick(j * (brick.width + brick.BUFFER), (i * 55) + 250, 3);

			}
		}

		String[] sounds = new String[3];
		sounds[0] = "sound.wav";
		sounds[1] = "music.wav";
		sounds[2] = "bells.wav";
		audio = new SoundDriverHo(sounds, this);

		for (int a = 0; a < snowFall.length; a++) {
			snowFall[a] = new snow();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		breakout b1 = new breakout();
		b1.start();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

		if (GDV5.KeysPressed[KeyEvent.VK_1]) {
			mainScreen = false;
			breakOutGame = true;
			gameOver = false;
			winPage = false;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_2]) {
			mainScreen = false;
			breakOutGame = false;
			gameOver = false;
			rulesPage = true;
			winPage = false;
		}

		if (hit != null) {
			hit.update();

		}
		if (brick.boomTown) {
			hit = new boom(gameBall);
			brick.boomTown = false;
			audio.play(0);
			bricksBroken++;
			
		}
		if (GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			mainScreen = true;
			breakOutGame = false;
			gameOver = false;
			rulesPage = false;
			gameBall.setLocation(400, 425);
			gameBall.lives = 3;
			winPage = false;
		}
		if (gameBall.lives == 0) {
			gameOver = true;
			mainScreen = false;
			breakOutGame = false;
			winPage = false;
		}
		
		if(bricksBroken >= 65) {
			winPage = true;
			bricksBroken = 0;
		}

		for (snow p : snowFall) {
			p.update();
		}

		gameBall.update();
		newPaddle.update();
		reinDeer.update();
		Sleigh.update();

	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub

		if (breakOutGame) {
			

			win.setColor(gameColor);
			win.fillRect(0, 0, 800, 600);

			win.drawImage(Santa, null, 100, -200);
			
			
			win.setColor(Color.white);
			win.setFont(new Font("bebas neue", Font.PLAIN, 30));
			win.drawString("Lives:" + gameBall.lives, 10, 50);
			win.drawString("Bricks:" + bricksBroken, 200, 50);

			for (brick b : wall) {
				b.draw(win);
			}
			gameBall.draw(win);
			newPaddle.draw(win);

			for (snow p : snowFall) {
				p.draw(win);
			}

			if (hit != null) {
				hit.draw(win);
			}
			
			if(bricksBroken  % 5 ==0) {
				win.drawImage(reindeer, null, reinDeer.x, reinDeer.y);
				
			}
			

			if (!audio.isPlaying(1)) {
				audio.play(1);
			}

		}

		
		if (rulesPage) {
			win.setColor(gameColor);
			win.drawImage(keys, null, 100, 100);
			
			win.drawString("Use the A and D Keys to break Santa Out!", 50, 50);
			win.drawString("Every 5 bricks broken gives you the deers!", 50, 100);
			win.drawString("Press \"t\" to start game", 50, 150);
			win.drawString("use \"enter\" to exit the game", 50, 200);
			win.drawString("Break 65 bricks to win!", 50, 250);

			for (snow p : snowFall) {
				p.draw(win);
			}

		}

		if (mainScreen) {

			
			win.drawImage(bg, null, 0, 0);
			win.drawImage(lights, null, -100,0);

			for (snow p : snowFall) {
				p.draw(win);
			}

			win.setColor(Color.black);
			win.setFont(new Font("Comic Sans", Font.BOLD, 20));
			win.drawString("Press \"2\" for rules", 250, 225);
			win.drawString("Press \"1\" to play Breakout ", 250, 180);

			if (!audio.isPlaying(1)) {
				audio.play(1);
			}

		}

		if (gameOver) {
			win.setColor(Color.white);
			win.drawString("Game Over! Press \"Enter\" to go back to main menu", 200, 200);
		}
		
		if(winPage) {
			
			win.setColor(Color.white);
			win.fillRect(0, 0, 800, 600);
			win.setColor(Color.black);
			win.drawString("You Saved Christmas!!!", 50, 50);
			win.drawImage(sleigh, null, Sleigh.x, Sleigh.y);
			Sleigh.draw(win);
		}
		
		
		for (snow p : snowFall) {
			p.draw(win);
		}

	}

}
