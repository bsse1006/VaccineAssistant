package packageForOtherClasses;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SignIn
{
	private String userName;
	private String password;
	
	public void operations (Stage primaryStage, Scene [] scene) throws IOException
	{
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(10);
		pane.setVgap(10);
		
		Label l1 = new Label("User Name:");
		Label l2 = new Label("Password:");
		Label l3 = new Label("Do not have an account?");
		TextField t1 = new TextField();
		PasswordField t2 = new PasswordField();
		
		pane.add(l1, 0, 1);
		pane.add(l2, 0, 2);
		pane.add(t1, 1, 1);
		pane.add(t2, 1, 2);
		
		Button btSubmit = new Button("SUBMIT");
		pane.add(btSubmit, 1, 3);
		GridPane.setHalignment(btSubmit, HPos.RIGHT);
		
		
		pane.add(l3, 0, 6);
		Button btSignUp = new Button("SIGN UP");
		pane.add(btSignUp, 1, 6);
		GridPane.setHalignment(btSignUp, HPos.LEFT);
		
		
		btSignUp.setOnAction(e -> {
				SignUp su1 = new SignUp();
				su1.operations(primaryStage, scene);
		});
		
		btSubmit.setOnAction(e -> {
			userName = t1.getText();
			password = t2.getText();
			
			MainDatabase d2 = new MainDatabase();
			int flag = 0;
			for(Account ac : d2.getDataBase().getAccounts())
			{
				if(ac.getUserName().equals(userName)&&ac.getPassword().equals(password))
				{
					//Parent root = FXMLLoader.load(getClass().getResource("/packageForOtherClasses/Dashboard.fxml"));
					flag=1;
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("/packageForOtherClasses/Dashboard.fxml"));
					try 
					{
						loader.load();
					} 
					catch (IOException e2) 
					{
						
					}
					Dashboard d1 = loader.getController();
					d1.setAc(ac);
					d1.setScene(scene);
					d1.setD2(d2);
					
					d1.setPrimaryStage(primaryStage);
					d1.operations();
					
					Parent root = loader.getRoot();
					scene[3] = new Scene (root);
					scene[3].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
					primaryStage.setScene(scene[3]); 
					primaryStage.show();
					
				}
			}
			if(flag==0)
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
		});
		
		
		scene[1] = new Scene(pane,400,700);
		scene[1].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
		primaryStage.setTitle("Vaccine Assistant"); 
		primaryStage.setScene(scene[1]); 
		primaryStage.show();
	}

}
