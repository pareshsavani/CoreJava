package Tasks._122823ShoppingAppDB.entity;

public class Users implements Comparable<Users>{

	private int userId;
	private String userName;
	private String password;
	private String userType;

	// constructors
	public Users() {
//		super();
	}

	public Users(int userId, String userName, String password, String userType) {
//		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	// getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	// toString() overridden
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType="
				+ userType + "]";
	}

	@Override
	public int compareTo(Users o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
