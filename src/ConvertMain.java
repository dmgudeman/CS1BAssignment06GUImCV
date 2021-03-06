
public class ConvertMain {
	/**
	 * Drives the program. It instantiates members of the Model, View and Controller 
	 * classes. It registers the view to be an observer and the controller
	 * to be a listener
	 */
	public static void main(String[] args) {
		ConvertModel mainModel = new ConvertModel();
		ConvertView mainView = new ConvertView();
		ConvertController mainControl = new ConvertController(mainModel, mainView);
		
		//adds the view to be an observer
		mainModel.addObserver(mainView);
		
		// registers the controller to be a listener of the button activator on 
		// the view.
		mainView.addController(mainControl);
	}
}
