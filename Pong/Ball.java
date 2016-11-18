import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Ball {
	private static final int DIAMETER = 30;
	
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private PongGame game;
	int collide = 0;	// will be used to determine in which racquet hits the ball

	public Ball(PongGame game) {
		this.game = game;
	}

	void move() throws InterruptedException {
		boolean changeDirection = true;
		
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		else if (y + ya < 0){
			game.playerScore++;
			x = 0;	//the game will restart. Since the opponent missed the ball, the ball will favor to player1
			y = 0;
			game.speed = 1;
			ya = game.speed;
			JOptionPane.showMessageDialog(game, "Player 2 Missed. Continue?", null, JOptionPane.YES_NO_OPTION);
			
		}
		else if (y + ya > game.getHeight() - DIAMETER){
			game.opponentScore++;
			x = 0;	
			y = 500;
			game.speed = 1;
			ya = -game.speed;
			JOptionPane.showMessageDialog(game, "Player 1 Missed. Continue?", null, JOptionPane.YES_NO_OPTION);
			
			
		}
		else if (collision()){
			if(collide == 1){
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			}else{
				ya = game.speed;
			}
			game.speed++;
		}
		else if(game.playerScore == 3 || game.opponentScore == 3){	//if one player already got 5 points, game will end and declares the one who got the 5 points first as the winner 
			game.gameOver();
		}
		else {
			changeDirection = false;
		}
		
		if (changeDirection) {
			Sound.BALL.play();
		}
		
		x = x + xa;
		y = y + ya;
	}
	

	private boolean collision() {
		
		if(game.racquet.getBounds().intersects(getBounds()) == true){
			collide = 1;
			return true;
		}
		if(game.rac.getBounds().intersects(getBounds()) == true){
			collide = 2;
			return true;
		}
		return false;
	}

	public void paint(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}