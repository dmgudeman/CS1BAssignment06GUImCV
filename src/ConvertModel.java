import java.util.Observable;
import java.util.Observer;
/**
 * This class is directed to take an input of a double from the
 * view convert it to Fahrenheit and return a double to the view.
 * It extends the Obserdable class so that it can be observed by the view
 * and be able to notify the view when a conversion has been done.
 */

public class ConvertModel extends Observable{
	private double celsius;
    private ConvertView modelView;
	
	/**
	 * The is a method of the class Observable that allows
	 * the model to be observed.  
	 */
	public void addObserver(Observer observe) {
		modelView = (ConvertView)observe;
	}
	/**
	 * Takes as a parameter a double from the input on the view
	 * and converts it to Celsius
	 */
	public void convertToCelsius(double fahrenheit) {	
		celsius = (5/9.0) * ((fahrenheit) - 32);
		notifyObservers();
	}
	/**
	 * This method notifies the observer view object to call 
	 * update and show the result in the output textField
	 */
	public void notifyObservers() {
		modelView.update(null, celsius);
		
	}	
}
