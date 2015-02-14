
public class ConvertMain {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConvertModel mainModel = new ConvertModel();
		ConvertView mainView = new ConvertView();
		mainModel.addObserver(mainView);
		ConvertController mainControl = new ConvertController(mainModel, mainView);
		mainView.addController(mainControl);
	}
}
