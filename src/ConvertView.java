import java.awt.FlowLayout;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
/**
 * This class creates a JFrame to take user input, provides a button
 * to notify the controller and takes a double return value that has 
 * been converted and displays the result of a temperature 
 * conversion from F to C.
 */
public class ConvertView extends JFrame implements Observer {
	// set constants for the frame
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	private static final int FRAME_X_ORIGIN = 150;
	private static final int FRAME_Y_ORIGIN = 250;
	
	// initialize the elements in the frame
	private JLabel prompt;
	private JTextField fahrInput;
	private JLabel response;
	private JTextField celsOutput;
	private JButton convertButton;
    /**
     * Non parameterized constructor for this class, creates a
     * JFrame and places buttons in the frame
     */
	public ConvertView() {
		//creates frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setTitle("F to C temperature converter");
		setLocation(FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		this.setLayout(new FlowLayout());
		
		// declares the elements in the frame
		prompt = new JLabel("Please type a Fahrenheit number in");
		fahrInput = new JTextField("            ");
		response = new JLabel("The converted temperature in C is");
		celsOutput = new JTextField("            ");
		convertButton = new JButton("CONVERT");
		
		// adds the initialized elements to the frame
		this.add(prompt);
		this.add(fahrInput);
		this.add(celsOutput);
		this.add(convertButton);
		this.add(response);
		this.add(celsOutput);
		this.setVisible(true);
		
		// makes frame visible and exits on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * Takes in a controller Object as a parameter registers
	 * the controller object as a listener for the convertButton
	 * to be enacted 
	 */
	public void addController(ActionListener controller) {
		convertButton.addActionListener(controller);
	}
	/**
	 * This is a method necessary to implement the Observer interface.
	 * It takes two parameters o is the observable object and 
	 * arg an argument passed to the notifyObservers method.
	 */
	@Override
	public void update(Observable o, Object arg) {
		double celsius = (double) arg;
		DecimalFormat df = new DecimalFormat("#.00");
		celsOutput.setText(df.format(celsius));
	}
    /**
     * Returns a Double from the textField input of the JFrame
     * Uses getText method (inherited from javax.swing.JComponent), 
     * then trims it and then parses it into a Double. 
     */
	public double getFahrenheit() {
		return Double.parseDouble(fahrInput.getText().trim());
	}
}
