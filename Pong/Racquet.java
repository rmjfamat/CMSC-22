import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	private int Y;
	private static final int WITH = 90;
	private static final int HEIGHT = 15;
	int x = 250;
	int xa = 0;
	private PongGame game;

	public Racquet(PongGame game, int Y) {
		this.game = game;
		this.Y = Y;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WITH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect(x, Y, WITH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if(Y == 535){
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				xa = -game.speed;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				xa = game.speed;
		}else{
			if (e.getKeyCode() == KeyEvent.VK_A)
				xa = -game.speed;
			if (e.getKeyCode() == KeyEvent.VK_D)
				xa = game.speed;
		}
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WITH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
}