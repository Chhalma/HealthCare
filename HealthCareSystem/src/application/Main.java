package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	@Override 
	public void start(Stage primaryStage) {
		try {
		//	Parent root = FXMLLoader.load(getClass().getResource("/registration/Registration.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root,720,450);
			scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
		//	scene.getStylesheets().add(getClass().getResource("/registration/registration.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Health Care System" );
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
