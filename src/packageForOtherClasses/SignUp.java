package packageForOtherClasses;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mainPackage.MainClass;

public class SignUp 
{
	private String userName;
	private String password;
	private int age;

	public void operations(Stage primaryStage, Scene [] scene) 
	{
		CheckBox cb1 = new CheckBox("Vaccine 1");
		cb1.setIndeterminate(false);
		
		CheckBox cb2 = new CheckBox("Vaccine 2");
		cb2.setIndeterminate(false);

		CheckBox cb3 = new CheckBox("Vaccine 3");
		cb3.setIndeterminate(false);
		
		CheckBox cb4 = new CheckBox("Vaccine 4");
		cb4.setIndeterminate(false);
		
		CheckBox cb5 = new CheckBox("Vaccine 5");
		cb5.setIndeterminate(false);
		
		CheckBox cb6 = new CheckBox("Vaccine 6");
		cb6.setIndeterminate(false);
		
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(10);
		pane.setVgap(10);

		Label l1 = new Label("User Name:");
		Label l2 = new Label("Password:");
		Label l3 = new Label("Age:");
		Label l4 = new Label("Vaccines already taken:");
		Label l5 = new Label("Have an account?");
		
		TextField t1 = new TextField();
		PasswordField t2 = new PasswordField();
		TextField t3 = new TextField();

		pane.add(l1, 0, 1);
		pane.add(l2, 0, 2);
		pane.add(l3, 0, 3);
		pane.add(l4, 0, 4);
		pane.add(t1, 1, 1);
		pane.add(t2, 1, 2);
		pane.add(t3, 1, 3);
		
		pane.add(cb1,1,4);
		pane.add(cb2,1,5);
		pane.add(cb3,1,6);
		pane.add(cb4,1,7);
		pane.add(cb5,1,8);
		pane.add(cb6,1,9);

		Button btSignIn = new Button ("SIGN IN");
		Button btSubmit = new Button("SUBMIT");
		pane.add(btSubmit, 1, 11);
		pane.add(l5,0,17);
		pane.add(btSignIn,1,17);
		GridPane.setHalignment(btSubmit, HPos.RIGHT);
		
		GridPane.setHalignment(btSignIn, HPos.LEFT);
		
		
		btSignIn.setOnAction(e -> {
			SignIn si1 = new SignIn();
			try {
				si1.operations(primaryStage, scene);
			} catch (IOException e1) {
			}
		});

		btSubmit.setOnAction(e -> {
			if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals(""))
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/packageForOtherClasses/Warning.fxml"));
				try 
				{
					loader.load();
				} 
				catch (IOException e2) 
				{
					
				}
				WarningController v1 = loader.getController();
				Stage stage = new Stage ();
				v1.setStage(stage);
				Parent root = loader.getRoot();
				scene[5] = new Scene (root);
				scene[5].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
				stage.setScene(scene[5]); 
				stage.show();
			}
			else
			{
				userName = t1.getText();
				password = t2.getText();
				age = Integer.parseInt(t3.getText());
			
				Account ac = new Account (t1.getText(),t2.getText(),Integer.parseInt(t3.getText()),
						cb1.isSelected(),cb2.isSelected(),cb3.isSelected(),
						cb4.isSelected(),cb5.isSelected(),cb6.isSelected());
			
				MainDatabase d1 = new MainDatabase();
				
				int flag = 0;
				
				for(Account a : d1.getDataBase().getAccounts())
				{
					if(a.getUserName().equals(ac.getUserName()))
					{
						flag=1;
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(getClass().getResource("/packageForOtherClasses/Warning.fxml"));
						try 
						{
							loader.load();
						} 
						catch (IOException e2) 
						{
							
						}
						WarningController v1 = loader.getController();
						Stage stage = new Stage ();
						v1.setStage(stage);
						Parent root = loader.getRoot();
						scene[5] = new Scene (root);
						scene[5].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
						stage.setScene(scene[5]); 
						stage.show();
						break;
					}
				}
				if(flag==0)
				{
					d1.getDataBase().getAccounts().add(ac);
					
					try
					{
						XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Database.xml")));
					
						enc.writeObject(d1.getDataBase());
					
						enc.close();
					}
					catch (FileNotFoundException ex)
					{
					
					}
				
					primaryStage.setScene(scene[0]); 
					primaryStage.show();
				}
				
			}
		});

		scene[2] = new Scene(pane,400,700);
		scene[2].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
		primaryStage.setTitle("Vaccine Assistant");
		primaryStage.setScene(scene[2]);
		primaryStage.show();

	}

}
