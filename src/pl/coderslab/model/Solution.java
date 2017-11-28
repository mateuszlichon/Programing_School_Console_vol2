package pl.coderslab.model;

import java.util.Date;

public class Solution {
	private int id;
	private Date created;
	private Date updated;
	private String description;
	private int excerciseId;
	private long usersId;
	
/*	public Solution() {
		this.id = 0;
		this.created = Date;
		this.updated;
		this.description = "";
		this.excerciseId = 0;
		this.usersId = 0l;
	}*/
	
	public Solution(Date created, Date updated, String description, int excerciseId, long usersId) {
		this.id = 0;
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.excerciseId = excerciseId;
		this.usersId = usersId;
	}
	
	public Solution(int id, Date created, Date updated, String description, int excerciseId, long usersId) {
		this.id = id;
		this.created = created;
		this.updated = updated;
		this.description = description;
		this.excerciseId = excerciseId;
		this.usersId = usersId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExcerciseId() {
		return excerciseId;
	}

	public void setExcerciseId(int excerciseId) {
		this.excerciseId = excerciseId;
	}

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}
	
}
