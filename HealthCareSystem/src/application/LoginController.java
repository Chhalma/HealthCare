package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import dbConnection.ConnectionDB;
import AlertMessage.Message;

public class LoginController implements Initializable{

	@FXML
    private AnchorPane anPane;

    @FXML
    private Label header;
    
    @FXML
    private JFXButton forgotPassBtn;

    @FXML
    private Pane leftPane;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label loginHeader;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordField;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private Label username;

    @FXML
    private TextField usernameField;
    
    private PreparedStatement pst;
    
    Connection con;
    ConnectionDB conDB = new ConnectionDB();
    Message msg =  new Message();
    @FXML
    void createLogin(ActionEvent event) {
    			try {
					con = conDB.getConnection();
					String select = "SELECT * FROM user WHERE email=? and password = ?";
					
					pst = con.prepareStatement(select);
					pst.setString(1, usernameField.getText());
					pst.setString(2, passwordField.getText());
    			
					ResultSet rs = pst.executeQuery();
					int count = 0;
					
					while(rs.next()) {
						count++;
					}
					if(count==1) {
						msg.setMessage("Liogin Successful!!");
					}
					else {
						msg.setMessage("Liogin Failed!!");
							
					}
    			
    			} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
    }
    

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	@FXML
    void createRegister(ActionEvent event)  {
	    	try {
    		registerBtn.getScene().getWindow().hide();
        	
    	Stage signUp = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/registration/Registration.fxml"));
		
    	Scene scene = new Scene(root);
    	signUp.setScene(scene);
    	signUp.show();
    	}catch(IOException ie ) {
    		System.out.println(ie);
    		 ie.printStackTrace();
    	}
    }

}
