package packageForOtherClasses;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class Dashboard implements Initializable
{
	private Account ac;
	private Scene [] scene;
	private Stage primaryStage;
	private MainDatabase d2;
	
	public void setD2 (MainDatabase d2)
	{
		this.d2=d2;
	}
	
	@FXML MenuButton m1;
	 
	Label [] l1 = new Label [6];
	Label [] l2 = new Label [6];
	Label [] l3 = new Label [6];
	Label [] l4 = new Label [6];
	
	@FXML MenuItem l11;
	@FXML MenuItem l12;
	@FXML MenuItem l13;
	@FXML MenuItem l21;
	@FXML MenuItem l22;
	@FXML MenuItem l23;
	@FXML MenuItem l31;
	@FXML MenuItem l32;
	@FXML MenuItem l33;
	@FXML MenuItem l41;
	@FXML MenuItem l42;
	@FXML MenuItem l43;
	@FXML MenuItem l14;
	@FXML MenuItem l15;
	@FXML MenuItem l16;
	@FXML MenuItem l24;
	@FXML MenuItem l25;
	@FXML MenuItem l26;
	@FXML MenuItem l34;
	@FXML MenuItem l35;
	@FXML MenuItem l36;
	@FXML MenuItem l44;
	@FXML MenuItem l45;
	@FXML MenuItem l46;
	
	public void operations ()
	{
		l1[0]=new Label ();
		l1[1]=new Label ();
		l1[2]=new Label ();
		l2[0]=new Label ();
		l2[1]=new Label ();
		l2[2]=new Label ();
		l3[0]=new Label ();
		l3[1]=new Label ();
		l3[2]=new Label ();
		l4[0]=new Label ();
		l4[1]=new Label ();
		l4[2]=new Label ();
		l1[4]=new Label ();
		l1[5]=new Label ();
		l1[3]=new Label ();
		l2[4]=new Label ();
		l2[5]=new Label ();
		l2[3]=new Label ();
		l3[4]=new Label ();
		l3[5]=new Label ();
		l3[3]=new Label ();
		l4[4]=new Label ();
		l4[5]=new Label ();
		l4[3]=new Label ();
		
		int i = 0, j = 0, k = 0;
		for(Vaccine v : ac.vacArray)
		{
			if(v.getCurrentDoseNum()>0&&v.getTakenOrNot()==false)
			{
				l3[k].setText(v.getVacName());
				k=k+1;
			}
			else if(v.getTakenOrNot()==true)
			{
				l1[i].setText(v.getVacName());
				i=i+1;
			}
			else
			{
				l2[j].setText(v.getVacName());
				j=j+1;
			}
		}
		
		l11.setText(l1[0].getText());
		l12.setText(l1[1].getText());
		l13.setText(l1[2].getText());
		l21.setText(l2[0].getText());
		l22.setText(l2[1].getText());
		l23.setText(l2[2].getText());
		l31.setText(l3[0].getText());
		l32.setText(l3[1].getText());
		l33.setText(l3[2].getText());
		l41.setText("Change password");
		l42.setText(l4[1].getText());
		l43.setText(l4[2].getText());
		l14.setText(l1[3].getText());
		l15.setText(l1[4].getText());
		l16.setText(l1[5].getText());
		l24.setText(l2[3].getText());
		l25.setText(l2[4].getText());
		l26.setText(l2[5].getText());
		l34.setText(l3[3].getText());
		l35.setText(l3[4].getText());
		l36.setText(l3[5].getText());
		l44.setText(l4[3].getText());
		l45.setText(l4[4].getText());
		l46.setText(l4[5].getText());
		
	}
	
	public void setAc (Account ac)
	{
		this.ac = ac;
	}
	
	public void setScene (Scene [] scene)
	{
		this.scene = scene;
	}
	
	public void setPrimaryStage (Stage primaryStage)
	{
		this.primaryStage = primaryStage;
	}
	
	public void back (ActionEvent event)
	{
		primaryStage.setTitle("Vaccine Assistant"); 
		primaryStage.setScene(scene[1]); 
		primaryStage.show();
	}
	
	public void mainMenu (ActionEvent event)
	{
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Vaccine Assistant"); 
		window.setScene(scene[0]); 
		window.show();
	}
	
	public void exitApp (ActionEvent event)
	{
		System.exit(0);
	}
	
	public void change (ActionEvent event)
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/packageForOtherClasses/Password.fxml"));
		try 
		{
			loader.load();
		} 
		catch (IOException e2) 
		{
			
		}
		Password v1 = loader.getController();
		Stage stage = new Stage ();
		v1.setStage(stage);
		v1.setD2(d2);
		v1.setAc(ac);
		v1.setScene(scene);
		Parent root = loader.getRoot();
		scene[6] = new Scene (root);
		scene[6].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
		stage.setScene(scene[6]); 
		stage.show();
	}
	
	public void vaccine (ActionEvent event)
	{
		for(Vaccine v: ac.getVacArray())
		{
			if(((MenuItem)event.getSource()).getText().equals(v.getVacName()))
			{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/packageForOtherClasses/Vaccine.fxml"));
				try 
				{
					loader.load();
				} 
				catch (IOException e2) 
				{
					
				}
				VaccineController v1 = loader.getController();
				v1.setVac(v);
				v1.setAc(ac);
				v1.setD2(d2);
				v1.setPrimaryStage(primaryStage);
				v1.setScene(scene);
				v1.operations();
				
				Parent root = loader.getRoot();
				scene[4] = new Scene (root);
				scene[4].getStylesheets().add(getClass().getResource("App.css").toExternalForm());
				primaryStage.setScene(scene[4]); 
				primaryStage.show();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
	}
}
