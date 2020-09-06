package packageForOtherClasses;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class MainDatabase 
{
	private ListOfAccounts dataBase = new ListOfAccounts();
	
	public MainDatabase()
	{
		try
		{
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream("Database.xml")));
			
			dataBase.setAccounts(((ListOfAccounts) dec.readObject()).getAccounts());
			
			dec.close();
		}
		catch (FileNotFoundException ex)
		{
			
		}
	}

	public ListOfAccounts getDataBase() 
	{
		return dataBase;
	}

	public void setDataBase(ListOfAccounts dataBase) 
	{
		this.dataBase = dataBase;
	}
}
