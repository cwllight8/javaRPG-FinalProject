package edu.neumont.light.javarpg;

import java.net.URL;

import edu.neumont.light.javarpg.view.RpgView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaRPG extends Application {

	public static void main(String[] args) {
		Application.launch(JavaRPG.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		URL location = this.getClass().getClassLoader().getResource("RpgView.fxml");
		FXMLLoader loader = new FXMLLoader(location);
		Parent root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		RpgView viewController = loader.getController();
//		viewController.setStage(stage);
		
	}

}
