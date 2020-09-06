package packageForOtherClasses;

import java.io.Serializable;

public class Account implements Serializable
{
	private static final long serialVersionUID = 6468712106990670803L;
	private String userName;
	private String password;
	private int age;
	Vaccine [] vacArray = new Vaccine [6];
	
	
	public Account ()
	{
		
	}
	
	public Account (String userName,String password,int age, 
			boolean cb1,boolean cb2,boolean cb3,boolean cb4,
			boolean cb5,boolean cb6)
	{
		this.userName = userName;
		this.password = password;
		this.age = age;
		
		int [] arr = new int [2];
		arr[0]=2;
		arr[1]=3;
		vacArray[0] = new Vaccine("Vaccine 1", "Disease 1",3,1,200,arr,cb1);
		
		arr = new int [3];
		arr[0]=3;
		arr[1]=6;
		arr[2]=12;
		vacArray[1] = new Vaccine("Vaccine 2", "Disease 2",4,6,18,arr,cb2);
		
		arr = new int [1];
		arr[0]=1;
		vacArray[2] = new Vaccine("Vaccine 3", "Disease 3",2,6,200,arr,cb3);
		
		arr = new int [0];
		vacArray[3] = new Vaccine("Vaccine 4", "Disease 4",1,72,200,arr,cb4);
		
		arr = new int [2];
		arr[0]=6;
		arr[1]=12;
		vacArray[4] = new Vaccine("Vaccine 5", "Disease 5",3,12,200,arr,cb5);
		
		arr = new int [2];
		arr[0]=1;
		arr[1]=2;
		vacArray[5] = new Vaccine("Vaccine 6", "Disease 6",3,12,200,arr,cb6);
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vaccine[] getVacArray() {
		return vacArray;
	}

	public void setVacArray(Vaccine[] vacArray) {
		this.vacArray = vacArray;
	}
}
