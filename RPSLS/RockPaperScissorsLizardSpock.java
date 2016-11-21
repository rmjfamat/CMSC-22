import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

public class RockPaperScissorsLizardSpock extends Frame implements ActionListener{
	 private Label lblChoice;
	 private TextField txtResult;
	 private TextField txtPlayerResult;
	 private TextField txtComputerResult;
	 private Button btnRPSLS;
	 CheckboxGroup cbg = new CheckboxGroup();
	 Checkbox rock;
	 Checkbox paper;
	 Checkbox scissors;
	 Checkbox lizard;
	 Checkbox spock;
	 private int scoreofPlayer = 0;
	 private int scoreofComputer = 0;
	 
	 public  RockPaperScissorsLizardSpock() {
		 setLayout(new FlowLayout());
		 setLayout(new GridLayout(15, 5));
		 lblChoice = new Label("Your choice:");
		 add(lblChoice);
		 
		 rock = (new Checkbox("Rock", cbg, false));
		 add(rock);
		 paper = (new Checkbox("Paper", cbg, false));
		 add(paper);
		 scissors = (new Checkbox("Scissors", cbg, false));
		 add(scissors);
		 lizard = (new Checkbox("Lizard", cbg, false));
		 add(lizard);
		 
		 spock = (new Checkbox("Spock", cbg, false));
		 add(spock);
		 
		 txtResult = new TextField("Result", 50);
		 add(txtResult);
		 
		 btnRPSLS = new Button("RockPaperScissorsLizardSpock");
		 add(btnRPSLS);
		 btnRPSLS.addActionListener(this);
		 
		 lblChoice = new Label("Player's Score");
		 add(lblChoice);
		 txtPlayerResult = new TextField("0", 10);
		 add(txtPlayerResult);
		 txtPlayerResult.setEditable(false); 
		 
		 lblChoice = new Label("Computer's Score");
		 add(lblChoice);
		 txtComputerResult = new TextField("0", 10);
		 add(txtComputerResult);
		 txtComputerResult.setEditable(false); 
		 
		 setTitle("RockPaperScissorsLizardSpock");
	     setSize(250, 100); 
	     setVisible(true); 
	 }
	 
	 
	 public static void main(String[] args)  {
		 new RockPaperScissorsLizardSpock();
	}
	 
	 public void actionPerformed(ActionEvent evt) {
		 Random choiceOfComputer = new Random();
		 int getChoice = choiceOfComputer.nextInt(5) + 1;
		 int win = 0;
		 Checkbox box = cbg.getSelectedCheckbox();
		 
		 //if win = 0, computer and player have same choice; if win = 1, player wins; if win = -1, computer wins
		 
		 //check if players choice is rock
		 if(box == rock && getChoice == 1){
			 win = 0;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose ROCK.\n Computer chose ROCK. NO ONE WINS THIS ROUND!");
		 }
		 
		 else if(box == rock && getChoice == 2){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose ROCK. Computer chose PAPER. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == rock && getChoice == 3){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose ROCK. Computer chose SCISSORS. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == rock && getChoice == 4){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose ROCK. Computer chose LIZARD. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == rock && getChoice == 5){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose ROCK. Computer chose SPOCK. COMPUTER WINS THIS ROUND!");
		 }
		 
		 //check if players choice is paper
		 else if(box == paper && getChoice == 1){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose PAPER. Computer chose SPOCK. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == paper && getChoice == 2){
			 win = 0;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose PAPER. Computer chose PAPER. NO ONE WINS THIS ROUND!");
		 }
		 
		 else if(box == paper && getChoice == 3){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose PAPER. Computer chose SCISSORS. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == paper && getChoice == 4){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose PAPER. Computer chose LIZARD. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == paper && getChoice == 5){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose PAPER. Computer chose SPOCK. YOU WIN THIS ROUND!");
		 }
		 
		 //check if players choice is scissors
		 else if(box == scissors && getChoice == 1){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SCISSORS. Computer chose ROCK. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == scissors && getChoice == 2){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SCISSORS. Computer chose PAPER. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == scissors && getChoice == 3){
			 win = 0;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SCISSORS. Computer chose SCISSORS. NO ONE WINS THIS ROUND!");
		 }
		 
		 else if(box == scissors && getChoice == 4){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SCISSORS. Computer chose LIZARD. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == scissors && getChoice == 5){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SCISSORS. Computer chose SPOCK. COMPUTER WINS THIS ROUND!");
		 
		 }
		 
		 //check if players choice is lizard
		 else if(box == lizard && getChoice == 1){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose LIZARD. Computer chose ROCK. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == lizard && getChoice == 2){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose LIZARD. Computer chose PAPER. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == lizard && getChoice == 3){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose LIZARD. Computer chose SCISSORS. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == lizard && getChoice == 4){
			 win = 0;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose LIZARD. Computer chose LIZARD. NO ONE WINS THIS ROUND!");
		 }
		 
		 else if(box == lizard && getChoice == 5){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose LIZARD. Computer chose SPOCK. YOU WIN THIS ROUND!");
		 }	 
		 
		//check if players choice is spock
		 else if(box == spock && getChoice == 1){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SPOCK. Computer chose ROCK. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == spock && getChoice == 2){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SPOCK. Computer chose ROCK. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == spock && getChoice == 3){
			 win = 1;
			 scoreofPlayer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SPOCK. Computer chose PAPER. YOU WIN THIS ROUND!");
		 }
		 
		 else if(box == spock && getChoice == 4){
			 win = -1;
			 scoreofComputer++;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SPOCK. Computer chose LIZARD. COMPUTER WINS THIS ROUND!");
		 }
		 
		 else if(box == spock && getChoice == 5){
			 win = 0;
			 txtResult.setText(" ");
			 txtResult.setText("Results: Player chose SPOCK. Computer chose SPOCK. NO ONE WINS THIS ROUND!");
		 }	 
		 
		 txtPlayerResult.setText(scoreofPlayer + "");
		 txtComputerResult.setText(scoreofComputer + "");
		 
		 if(scoreofPlayer == 5 || scoreofComputer == 5){
			 if(scoreofComputer == 5){
				 JOptionPane.showMessageDialog(this, "COMPUTER WINS!");
			 }
			 else {
				 JOptionPane.showMessageDialog(this, "YOU WIN!");
			 }
			 setVisible(false);
			 main(null);
			 
		 }
		 
	 }
	 
	
}
