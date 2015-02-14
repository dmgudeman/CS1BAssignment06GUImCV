import java.util.Observable;
import java.util.Observer;
/**
 * 
 * @author davidgudeman
 *
 */

public class ConvertModel extends Observable{
	private double celsius;
    private ConvertView modelView;
	
	/**
	 * 
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
	 * 
	 */
	public void notifyObservers() {
		modelView.update(null, celsius);
		
	}	
}
