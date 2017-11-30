package pl.coderslab.model;

import java.util.Date;

public class SolutionDto {
	private String excerciseTitle;
	private String userName;
	private Date creationDate;
	private int solutionId;

	
	
	public SolutionDto() {
		super();
		this.excerciseTitle = "";
		this.userName = "";
		this.creationDate = new Date();
		this.solutionId = 0;
		
	}

	public SolutionDto(String excerciseTitle, String userName, Date creationDate, int solutionId) {
		super();
		this.excerciseTitle = excerciseTitle;
		this.userName = userName;
		this.creationDate = creationDate;
		this.solutionId = solutionId;
	}

	public String getExcerciseTitle() {
		return excerciseTitle;
	}

	public void setExcerciseTitle(String excerciseTitle) {
		this.excerciseTitle = excerciseTitle;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getSolutionId() {
		return solutionId;
	}

	public void setSolutionId(int solutionId) {
		this.solutionId = solutionId;
	}
	
	

}
