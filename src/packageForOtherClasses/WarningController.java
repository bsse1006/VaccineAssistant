package packageForOtherClasses;

import javafx.stage.Stage;

public class WarningController 
{
	private Stage stage;
	
	public void setStage (Stage stage)
	{
		this.stage=stage;
	}
	public void ok()
	{
		stage.hide();
	}
}
