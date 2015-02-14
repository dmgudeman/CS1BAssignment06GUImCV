import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConvertController implements ActionListener {
	private ConvertModel model;
	private ConvertView view;

	/**
	 * parameterized Constructor for this controller class that takes both the
	 * model (ConvertModel) and the view (ConvertView). Allows the
	 * actionPerformed method of the ActionListener to be called from this class
	 * 
	 */
	public ConvertController(ConvertModel model, ConvertView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * This method is called when there is an action initiated from the
	 * ActionListener. This methods takes the Fahrenheit input from the view and
	 * sends it to the model where it is converted to Celsisus
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		model.convertToCelsius(view.getFahrenheit());
	}

}
