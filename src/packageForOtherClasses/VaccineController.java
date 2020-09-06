package packageForOtherClasses;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VaccineController 
{
	private Vaccine vac;
	private Scene [] scene;
	private Stage primaryStage;
	private Account ac;
	private MainDatabase d2;
	
	public void setD2 (MainDatabase d2)
	{
		this.d2=d2;
	}
	
	@FXML private TextField t1;
	@FXML private Label l1 = new Label();
	@FXML private Label l2 = new Label();
	@FXML private Label l3 = new Label();
	@FXML private Label l4 = new Label();
	@FXML private Label l5 = new Label();
	@FXML private Label l6 = new Label();
	@FXML private Label l7 = new Label();
	@FXML private Label l8 = new Label();
	@FXML private Label [] l = new Label [3];

	public void setVac(Vaccine vac) 
	{
		this.vac = vac;
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
		primaryStage.setScene(scene[3]); 
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
	
	public void operations ()
	{
		for(int i =0; i<3; i++)
		{
			l[i]=new Label();
		}
		
		l3.textProperty().bind(l[0].textProperty());
		l4.textProperty().bind(l[1].textProperty());
		l5.textProperty().bind(l[2].textProperty());
		
		for(int i = 0; i < (vac.getNumOfDoses()-1); i++)
		{
			l[i].setText(Integer.toString(vac.getGapsBetweenDoses()[i])+" months");
		}
		
		
		l1.setText(vac.getVacName());
		l2.setText(Integer.toString(vac.getNumOfDoses()));
		
		
		
		l6.setText(Integer.toString(vac.getCurrentDoseNum()));
		if(vac.getTakenOrNot()==true)
		{
			l7.setText("Yes");
		}
		else
		{
			l7.setText("No");
		}
		
		if(vac.getCurrentDoseNum()>0&&vac.getCurrentDoseNum()<vac.getNumOfDoses()) l8.setText(Integer.toString(vac.getGapsBetweenDoses()[vac.getCurrentDoseNum()-1]
				- (int) ((new Date().getTime()-vac.getDate().getTime())/2592000000L)) + " months");
		else if(vac.getCurrentDoseNum()==vac.getNumOfDoses()) l8.setText("");
	}
	
	public void Submit (ActionEvent event)
	{
		String s1 = t1.getText();
		
		if(Integer.parseInt(s1)>vac.getNumOfDoses()||Integer.parseInt(s1)<vac.getCurrentDoseNum())
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
			for(Account a : d2.getDataBase().getAccounts())
			{
				if(a.getUserName().equals(ac.getUserName()))
				{
					for(Vaccine vaca : a.getVacArray())
					{
						if(vaca.getVacName().equals(vac.getVacName()))
						{
							vaca.setCurrentDoseNum(Integer.parseInt(s1));
							if(vaca.getCurrentDoseNum()==vaca.getNumOfDoses()) vaca.setTakenOrNot(true);
							else if(vaca.getCurrentDoseNum()==0) vaca.setTakenOrNot(false);
							if(vaca.getCurrentDoseNum()>0)
							{
								vaca.setDate(new Date());
							}
						}
					}
				}
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
}
