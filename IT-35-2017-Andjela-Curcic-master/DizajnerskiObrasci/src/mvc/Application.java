package mvc;

public class Application {

	public static void main(String[] args) {
		AppModel model = new AppModel();
		AppFrame frame = new AppFrame();
		frame.getView().setModel(model);
		AppController controller = new AppController(model,frame);
		frame.setController(controller);
		frame.getBtnColorEdge().setBackground(controller.getEdgeColor());
		frame.getBtnColorInner().setBackground(controller.getInnerColor());
		frame.setVisible(true);
	}

}
