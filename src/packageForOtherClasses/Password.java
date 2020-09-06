package packageForOtherClasses;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Password 
{
	@FXML PasswordField p1;
	@FXML PasswordField p2;
	private Stage stage;
	private MainDatabase d2;
	private Account ac;
	private Scene[] scene;

	public void setStage(Stage stage) {
		this.stage=stage;
		
	}
	
	public void setAc (Account ac)
	{
		this.ac = ac;
	}
	
	public void setD2 (MainDatabase d2)
	{
		this.d2 = d2;
	}
	
	public void submit (ActionEvent event)
	{
		for(Account a : d2.getDataBase().getAccounts())
		{
			if(a.getUserName().equals(ac.getUserName()))
			{
				if(a.getPassword().equals(p1.getText())&&!(p2.getText().equals("")))
				{
					a.setPassword(p2.getText());
				}
				else
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
					Stage stage1 = new Stage ();
					v1.setStage(stage1);
					Parent root = loader.getRoot();
					scene[5] = new Scene (root);
					scene[5].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
					stage1.setScene(scene[5]); 
					stage1.show();
				}
				try
				{
					XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Database.xml")));
				
					enc.writeObject(d2.getDataBase());
				
					enc.close();
				}
				catch (FileNotFoundException ex)
				{
				
				}
				stage.hide();
			}
		}
		
		
	}

	public void setScene(Scene[] scene) {
		this.scene=scene;
	}

}
