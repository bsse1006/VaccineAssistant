package packageForOtherClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListOfAccounts implements Serializable
{
	private static final long serialVersionUID = -1025998266932287368L;
	
	private List<Account> accounts = new ArrayList<>();
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public ListOfAccounts()
	{
	
	}

	public List<Account> getAccounts() {
		return accounts;
	}
}
