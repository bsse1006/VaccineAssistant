package packageForOtherClasses;

import java.io.Serializable;
import java.util.Date;

public class Vaccine implements Serializable
{
	private static final long serialVersionUID = 3436936989372348025L;
	private String vacName;
	private String disName;
	private int numOfDoses;
	private int preAgeToStart;
	private int [] gapsBetweenDoses;
	private int highestAgeToFinish;
	private Date date;
	

	private boolean takenOrNot = false;
	private int currentDoseNum = 0;
	
	public Vaccine ()
	{
		
	}
	
	
	public Vaccine(String vacName, String disName, int numOfDoses, int preAgeToStart, int highestAgeToFinish, int[] gapsBetweenDoses,
			boolean takenOrNot) 
	{
		this.vacName = vacName;
		this.disName = disName;
		this.numOfDoses = numOfDoses;
		this.preAgeToStart = preAgeToStart;
		this.gapsBetweenDoses = gapsBetweenDoses;
		this.takenOrNot = takenOrNot;
		this.highestAgeToFinish = highestAgeToFinish;
		if(this.takenOrNot==true) this.currentDoseNum = this.numOfDoses;
	}

	public int getCurrentDoseNum() {
		return currentDoseNum;
	}

	public void setCurrentDoseNum(int currentDoseNum) {
		this.currentDoseNum = currentDoseNum;
	}
	
	public String getVacName() {
		return vacName;
	}

	public void setVacName(String vacName) {
		this.vacName = vacName;
	}

	public String getDisName() {
		return disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

	public int getNumOfDoses() {
		return numOfDoses;
	}

	public void setNumOfDoses(int numOfDoses) {
		this.numOfDoses = numOfDoses;
	}

	public int getPreAgeToStart() {
		return preAgeToStart;
	}

	public void setPreAgeToStart(int preAgeToStart) {
		this.preAgeToStart = preAgeToStart;
	}

	public int[] getGapsBetweenDoses() {
		return gapsBetweenDoses;
	}

	public void setGapsBetweenDoses(int[] gapsBetweenDoses) {
		this.gapsBetweenDoses = gapsBetweenDoses;
	}

	public boolean getTakenOrNot() {
		return takenOrNot;
	}

	public void setTakenOrNot(boolean takenOrNot) 
	{
		this.takenOrNot = takenOrNot;
	}


	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public Date getDate ()
	{
		return date;
	}
}
