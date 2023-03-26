package registration;

import java.io.IOException;

import com.gluonhq.charm.glisten.control.TextField;
//import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML
    private AnchorPane anPaneReg;

    @FXML
    private CheckBox checkBox;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label regintrationHeader;

    @FXML
    private JFXButton registerBtn;
    
    @FXML
    void gotoLogin(ActionEvent event) {
    	loginBtn.getScene().getWindow().hide();		
    	
    	try {
    		Stage login = new Stage();
        	Parent root;
    		root = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
    		Scene scene = new Scene(root);
        	login.setScene(scene);
        	login.show();
        	
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }

    @FXML
    void register(ActionEvent event) {

    }

}
