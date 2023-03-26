module HealthCareSystem {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.jfoenix;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires charm.glisten;
	
	opens application to javafx.graphics, javafx.fxml;
	opens registration to javafx.graphics, javafx.fxml;
}
