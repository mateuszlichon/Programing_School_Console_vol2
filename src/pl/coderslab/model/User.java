package pl.coderslab.model;

public class User {
	private long id;
	private String username;
	private String email;
	private String password;
	private int userGroupId;
	
	public User() {
		super();
		this.id = 0l;
		this.username = "";
		this.email = "";
		this.password = "";
		this.userGroupId = 0;
	}
	
	public User(String username, String email, String password) {
		super();
		this.id = 0l;
		this.username = username;
		this.email = email;
		this.password = password;
		this.userGroupId = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}
	
}

