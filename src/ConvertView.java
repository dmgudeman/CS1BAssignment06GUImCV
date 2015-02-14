import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

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
     * Non parametrized constructer for this class
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
		
		// adds the intialized elements to the frame
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

	public void addController(ActionListener controller) {
		convertButton.addActionListener(controller);
	}
	/**
	 * 
	 */
	@Override
	public void update(Observable o, Object arg) {
		double celsius = (double) arg;
		DecimalFormat df = new DecimalFormat("#.00");
		celsOutput.setText(df.format(celsius));
	}

	public double getFahrenheit() {
		return Double.parseDouble(fahrInput.getText().trim());
	}
}
