package pl.coderslab.model;

public class UserGroup {
	private int id;
	private String name;
	
	public UserGroup() {
		this.id = 0;
		this.name = "";
	}
	
	public UserGroup(String name) {
		this.id = 0;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
