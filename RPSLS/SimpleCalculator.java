import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleCalculator extends JFrame implements ActionListener, KeyListener {

	JTextField txtInput = new JTextField(31);
	JButton clear = new JButton("AC");
	JButton frac = new JButton("+/-");
	JButton mod = new JButton("%");
	JButton div = new JButton("/");
	JButton one = new JButton("1");
	JButton two = new JButton("2");
	JButton three = new JButton("3");
	JButton four = new JButton("4");
	JButton five = new JButton("5");
	JButton six = new JButton("6");
	JButton sev = new JButton("7");
	JButton eight = new JButton("8");
	JButton nine = new JButton("9");
	JButton zero = new JButton("0");
	JButton add = new JButton("+");
	JButton sub = new JButton("-");
	JButton mul = new JButton("x");
	JButton equals = new JButton("=");
	JButton dec = new JButton(".");
	JButton off = new JButton("OFF");
	JPanel text = new JPanel();
    JPanel numOp = new JPanel();
    
   boolean pressedOperator = false;
   boolean isDec = false;
   char operator;
   double first = 0d;
   double second = 0d;
   double result = 0d;
   double resultDoub;
	
  public SimpleCalculator() {
	 
	setTitle("Simple Calculator");
	
	txtInput.setFont(new Font("monospaced", Font.PLAIN, 20));
    txtInput.setHorizontalAlignment(JTextField.RIGHT);
    text.setBackground(Color.BLACK);
	text.add(txtInput);
	
		
	numOp.setLayout(new GridLayout(5, 4, 2, 2));
	numOp.setFont(new Font("monospaced", Font.BOLD, 21));
	numOp.setBackground(Color.BLUE);
	numOp.add(clear);
	numOp.add(frac);
	numOp.add(mod);
	numOp.add(div);
	numOp.add(one);
	numOp.add(two);
	numOp.add(three);
	numOp.add(mul);
	numOp.add(four);
	numOp.add(five);
	numOp.add(six);
	numOp.add(add);
	numOp.add(sev);
	numOp.add(eight);
	numOp.add(nine);
	numOp.add(sub);
	numOp.add(zero);
	numOp.add(dec);
	numOp.add(equals);
	numOp.add(off);
	
	clear.addActionListener(this);
	clear.addKeyListener(this);
	frac.addActionListener(this);
	frac.addKeyListener(this);
	mod.addActionListener(this);
	mod.addKeyListener(this);
	div.addActionListener(this);
	div.addKeyListener(this);
	one.addActionListener(this);
	one.addKeyListener(this);
	two.addActionListener(this);
	two.addKeyListener(this);
	three.addActionListener(this);
	three.addKeyListener(this);
	four.addActionListener(this);
	four.addKeyListener(this);
	five.addActionListener(this);
	five.addKeyListener(this);
	six.addActionListener(this);
	six.addKeyListener(this);
	sev.addActionListener(this);
	sev.addKeyListener(this);
	eight.addActionListener(this);
	eight.addKeyListener(this);
	nine.addActionListener(this);
	nine.addKeyListener(this);
	zero.addActionListener(this);
	zero.addKeyListener(this);
	add.addActionListener(this);
	add.addKeyListener(this);
	sub.addActionListener(this);
	sub.addKeyListener(this);
	mul.addActionListener(this);
	mul.addKeyListener(this);
	equals.addActionListener(this);
	this.addKeyListener(this);
	off.addActionListener(this);
	off.addKeyListener(this);
	dec.addActionListener(this);
	dec.addKeyListener(this);
	
	add(text, BorderLayout.NORTH);
    add(numOp, BorderLayout.CENTER);
    txtInput.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            e.consume();
        }
    });
  }

  public void actionPerformed(ActionEvent evt) {
	  switch (evt.getActionCommand()){
		case "0": setInput("0");
					break;
		case "1": setInput("1");
					break;
		case "2": setInput("2");
					break;
		case "3": setInput("3");
					break;
		case "4": setInput("4");
					break;
		case "5": setInput("5");
					break;
		case "6": setInput("6");
					break;
		case "7": setInput("7");
					break;
		case "8": setInput("8");
					break;
		case "9": setInput("9");
					break;
		case("+"): operator = '+';
					operate(operator);
					break;
		case("-"): operator = '-';
					operate(operator);
					break;
		case("x"): operator = 'x';
					operate(operator);
					break;
		case("/"): operator = '/';
					operate(operator);
					break;
		case("="): getResult();
					break;
		case("%"): operator = '%';
					operate(operator);
					break;
		case("."): setInput(".");
					break;
		case("AC"): txtInput.setText(null);
					break;
		case("+/-"): setInput("-");
					break;
		
		case("OFF"): System.exit(ABORT);
					 break;
	  }
	  
  }
  
  public void keyTyped(KeyEvent evt) {
	  
	  switch (evt.getKeyChar()){
		case '0': setInput("0");
					break;
		case '1': setInput("1");
					break;
		case '2': setInput("2");
					break;
		case '3': setInput("3");
					break;
		case '4': setInput("4");
					break;
		case '5': setInput("5");
					break;
		case '6': setInput("6");
					break;
		case '7': setInput("7");
					break;
		case '8': setInput("8");
					break;
		case '9': setInput("9");
					break;
		case '+': operator = '+';
					operate(operator);
					break;
		case '-': operator = '-';
					operate(operator);
					break;
		case 'x': operator = 'x';
					operate(operator);
					break;
		case '/': operator = '/';
					operate(operator);
					break;
		case '=': getResult();
					break;
		case '.': setInput(".");
					break;
			//space for AC
		case ' ': txtInput.setText(null);
					break;
	  }
	  
  }
  
  public void setInput(String num){
	  if(pressedOperator){
		  if(num == "."){
			  isDec = true;
		  }
		  else{
			  isDec = false;
		  }
		  
		  txtInput.setText(null);
		  pressedOperator = false;
	        txtInput.setText(txtInput.getText() + num);
	    } else {
	    	txtInput.setText(txtInput.getText() + num);
	    }
  }
  
  public void operate(Character op){
		  pressedOperator = true;
		  first = Double.parseDouble(txtInput.getText());
		
  }
  
  public void getResult(){
	  
		  second = Double.parseDouble(txtInput.getText());
		  switch (operator) {
	        case '+': result = first + second; 
	        			break;
	        case '-': result = first - second;
	        			break;
	        case 'x': result = first * second; 
	        			break;
	        case '/': result = first / second;
	        			break;
	        case '%': result = first % second;
						break;
		  }
		txtInput.setText(String.valueOf(result));
  }
  

  public static void main(String[] args) {
	  SimpleCalculator gst = new SimpleCalculator();
	  gst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  gst.setSize(400, 400);
      gst.setFocusable(true);
	  gst.setVisible(true);
  }

@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}

}