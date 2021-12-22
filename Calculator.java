package calculator;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * This class implements a simple calculator with basic operations: +, -, /, *,
 * sin, cos, tan, cosec, sec, cot, log, square AC button is used to clear the
 * screen
 * 
 * @author Thao Phung
 * @version 12/5/2018
 */

public class Calculator extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	// create a JButton type array to store the buttons.
	private JButton buttons[] = new JButton[24];
	// create a String type array to store the caption of button.
	private String captions[] = { "sin", "cos", "tan", "cosec", "sec", "cot", "log", "square", "1",
			"2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "/", "0", "=", "AC", "*" };
	private double firstNumb;
	private double secondNumb;
	private double answer;
	private String operator = "";
	private JPanel buttonPanel = new JPanel(new GridLayout(6, 4));
	private JTextField output = new JTextField(20);
	Container frame;
	private DecimalFormat decimalFormat = new DecimalFormat("##.##########");

	/*
	 * Constructor to construct a calculator
	 */
	public Calculator() {
		// Make the text field read-only
		output.setEditable(false);
		frame = getContentPane();

		// Create the buttons
		for (int count = 0; count < 24; count++) {
			buttons[count] = new JButton(captions[count]);
			buttonPanel.add(buttons[count]);
		}

		// Add an action to the buttons
		for (JButton b : buttons) {
			b.setBounds(10, 230, 60, 40);
			b.addActionListener(this);
		}
		frame.setLayout(new BorderLayout());
		frame.setBounds(100, 100, 300, 440);
		frame.add(output, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * perform action in response to an event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			/*
			 * check if the event is input a number, display that number to the textfield
			 */
			// if the button pressed is 1, display 1 to the textfield
			if (event.getSource() == buttons[8])
				output.setText(output.getText().concat("1"));
			// if the button pressed is 2, display 2 to the textfield
			else if (event.getSource() == buttons[9])
				output.setText(output.getText().concat("2"));
			// if the button pressed is 3, display 3 to the textfield
			else if (event.getSource() == buttons[10])
				output.setText(output.getText().concat("3"));
			// if the button pressed is 4, display 4 to the textfield
			else if (event.getSource() == buttons[12])
				output.setText(output.getText().concat("4"));
			// if the button pressed is 5, display 5 to the textfield
			else if (event.getSource() == buttons[13])
				output.setText(output.getText().concat("5"));
			// if the button pressed is 6, display 6 to the textfield
			else if (event.getSource() == buttons[14])
				output.setText(output.getText().concat("6"));
			// if the button pressed is 7, display 7 to the textfield
			else if (event.getSource() == buttons[16])
				output.setText(output.getText().concat("7"));
			// if the button pressed is 8, display 8 to the textfield
			else if (event.getSource() == buttons[17])
				output.setText(output.getText().concat("8"));
			// if the button pressed is 9, display 9 to the textfield
			else if (event.getSource() == buttons[18])
				output.setText(output.getText().concat("9"));
			// if the button pressed is 0, display 0 to the textfield
			else if (event.getSource() == buttons[20])
				output.setText(output.getText().concat("0"));

			/* check if the event is an operator */
			// if the button pressed is "+" , get another number from the text field
			// process addition operation on 2 numbers
			else if (event.getSource() == buttons[11]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "add";
			}
			// if the button pressed is "-" , get another number from the text field
			// process subtraction operation on 2 numbers
			else if (event.getSource() == buttons[15]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "subtract";
			}
			// if the button pressed is "*" , get another number from the text field
			// process multiplication operation on 2 numbers
			else if (event.getSource() == buttons[23]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "multiply";
			}
			// if the button pressed is "/" , get another number from the text field
			// process division operation on 2 numbers
			else if (event.getSource() == buttons[19]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "divide";
			}
			// if the button pressed is "AC" , clear the textfield
			else if (event.getSource() == buttons[22]) {
				output.setText("");
			}
			// if the button pressed is "sin" , process sin operation
			else if (event.getSource() == buttons[0]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "sin";
			}
			// if the button pressed is "cos" , process cos operation
			else if (event.getSource() == buttons[1]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "cos";
			}
			// if the button pressed is "tan" , process tan operation
			else if (event.getSource() == buttons[2]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "tan";
			}
			// if the button pressed is "cosec" , process cosec operation
			else if (event.getSource() == buttons[3]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "cosec";
			}
			// if the button pressed is "sec" , process sec operation
			else if (event.getSource() == buttons[4]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "sec";
			}
			// if the button pressed is "cot" , process cot operation
			else if (event.getSource() == buttons[5]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "cot";
			}
			// if the button pressed is "log" , process log operation
			else if (event.getSource() == buttons[6]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "log";
			}
			// if the button pressed is "square" , process square operation
			else if (event.getSource() == buttons[7]) {
				firstNumb = Double.parseDouble(output.getText());
				output.setText("");
				operator = "square";
			}

			/* if the button pressed is "=" , process result */
			else if (event.getSource() == buttons[21]) {
				switch (operator) {
					case "add":
						secondNumb = Double.parseDouble(output.getText());
						answer = firstNumb + secondNumb;
						break;
					case "subtract":
						secondNumb = Double.parseDouble(output.getText());
						answer = firstNumb - secondNumb;
						break;
					case "multiply":
						secondNumb = Double.parseDouble(output.getText());
						answer = firstNumb * secondNumb;
						break;
					case "divide":
						secondNumb = Double.parseDouble(output.getText());
						answer = firstNumb / secondNumb;
						break;
					case "sin":
						answer = Math.sin(Math.toRadians(firstNumb));
						break;
					case "cos":
						answer = Math.cos(Math.toRadians(firstNumb));
						break;
					case "tan":
						answer = Math.tan(Math.toRadians(firstNumb));
						break;
					case "cosec":
						answer = 1 / (Math.sin(Math.toRadians(firstNumb)));
						break;
					case "sec":
						answer = 1 / (Math.cos(Math.toRadians(firstNumb)));
						break;
					case "cot":
						answer = Math.cos(Math.toRadians(firstNumb))
							/ Math.sin(Math.toRadians(firstNumb));
						break;
					case "log":
						answer = Math.log10(firstNumb);
						break;
					case "square":
						answer = firstNumb * firstNumb;
						break;
					default:
						break;
				}
				operator = "";
				output.setText(decimalFormat.format(answer));
			}
		} catch (Exception exception) {
			System.out.println("Wrong format, try again");
		}
	}

}