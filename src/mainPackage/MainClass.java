package mainPackage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import packageForOtherClasses.*;

public class MainClass extends Application 
{
	private Scene [] scene = new Scene [10];

	public void start(Stage primaryStage) 
	{	
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label l1 = new Label("Welcome to Vaccine Assistant");
		l1.setAlignment(Pos.CENTER);
		
		pane.add(l1, 0, 0);
		
		Button b1 = new Button("Sign Up");
		
		b1.setMinHeight(100);
		b1.setMinWidth(200);

		b1.setOnAction(e -> {
			SignUp su1 = new SignUp();
			su1.operations(primaryStage, scene);
		});
		
		pane.add(b1, 0, 1);
		
		Button b2 = new Button("Sign In");
		
		b2.setMinHeight(100);
		b2.setMinWidth(200);
		
		
		b2.setOnAction(e -> {
			SignIn si1 = new SignIn();
			try {
				si1.operations(primaryStage, scene);
			} catch (IOException e1) {
			}
		});
		
		pane.add(b2, 0, 2);	
		
		
		Button b3 = new Button ("Exit App");
		GridPane.setHalignment(b3, HPos.CENTER);
		
		b3.setOnAction(e -> {
			System.exit(0);
		});
		
		pane.add(b3, 0, 3);
		
		scene[0] = new Scene(pane,400,700);
		
		scene[0].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
		
		primaryStage.setTitle("Vaccine Assistant"); 
		primaryStage.setScene(scene[0]); 
		primaryStage.show();
		
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}