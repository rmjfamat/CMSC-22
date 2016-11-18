import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PongGame extends JPanel {
	
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this, 535);
	Racquet rac = new Racquet(this, 15);
	int speed = 1;
	int playerScore = 0;
	int opponentScore = 0;

	//return the score of the player using the left and right keys
	private int getScorePlayer() {
		return playerScore;
	}
	
	//return the score of the player using the A and D keys
	private int getScoreOpponent() {
		return opponentScore;
	}

	public PongGame() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
				rac.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				rac.keyPressed(e);
			}
		});
		setFocusable(true);
		Sound.BACK.loop();
	}

	private void move() throws InterruptedException {
		ball.move();
		racquet.move();
		rac.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		rac.paint(g2d);

		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Verdana", Font.BOLD, 20));
		g2d.drawString("Player 1", 490  , 490);
		g2d.setColor(Color.BLUE);
		g2d.setFont(new Font("Verdana", Font.BOLD, 40));
		g2d.drawString(String.valueOf(getScorePlayer()), 520  , 530);
		
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Verdana", Font.BOLD, 20));
		g2d.drawString("Player 2", 490  , 70);
		g2d.setColor(Color.BLUE);
		g2d.setFont(new Font("Verdana", Font.BOLD, 40));
		g2d.drawString(String.valueOf(getScoreOpponent()), 520, 50);
	}

	public void gameOver() throws InterruptedException {
		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		int score = 0;
		String winner = null;
		int dialogButton = JOptionPane.YES_NO_OPTION;
		
		if(getScoreOpponent() > getScorePlayer()){
			score = getScoreOpponent();
			winner = "Player 2";
		}
		else{
			score = getScorePlayer();
			winner = "Player 2";
		}
		JOptionPane.showConfirmDialog(this, winner + " WINS!\nScore:\n" + score + "\nClick Yes to restart game.\nClick No to exit.",
				"Game Over", dialogButton);
		if(dialogButton == JOptionPane.YES_OPTION){
			restart();
		}
		else{
			System.exit(ABORT);
		}
		
	}
	
	public static void restart() throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		PongGame game = new PongGame();
		frame.add(game);
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		restart();
	}
}