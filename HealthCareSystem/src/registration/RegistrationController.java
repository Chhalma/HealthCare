package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbConnection.ConnectionDB;

//import com.gluonhq.charm.glisten.control.TextField;
//import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrationController {

	 @FXML
	    private TextField userName;

	    @FXML
	    private AnchorPane anPaneReg;

	    @FXML
	    private CheckBox checkBox;

	    @FXML
	    private TextField email;

	    @FXML
	    private JFXButton loginBtn;

	    @FXML
	    private PasswordField password;

	    @FXML
	    private Label regintrationHeader;

	    @FXML
	    private JFXButton registerBtn;

	    ConnectionDB conObj = new ConnectionDB();
    Connection con;
    
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
    	try {
			con = conObj.getConnection();
			
			String insert = "INSERT INTO `user` ( `user_name`, `password`, `email`)"+
			"VALUES (?,?,?); ";
			PreparedStatement ps = con.prepareStatement(insert);
			
			ps.setString(1, userName.getText() );
			ps.setString(2, password.getText());
			ps.setString(3, email.getText());
			
			ps.executeUpdate();
			
			/*java.sql.Statement st = con.createStatement();
			String str = "INSERT INTO `user` ( `user_name`, `password`, `role`, `active`) VALUES ( 'saifur', '1234', 'admin', '1'); ";
			st.execute(str);
			System.out.println("Data Inserted.");
			
			String str2 = "select * from user";
			ResultSet rs = st.executeQuery(str2);
			while(rs.next()) {
				System.out.println("User_name: "+ rs.getString("user_name")+", Password: "+rs.getString("password"));
			}
			st.close();
			con.close();
		*/
			
			System.out.println(con);
			System.out.println("Connected..." );
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

}
