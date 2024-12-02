package LearnSE.Model;

public class UserRegistrationModel {
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String userPwd;
    private String userConfirmPwd;
    private String secQuestion1;
    private String secAnswer1;
    private String secQuestion2;
    private String secAnswer2;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserConfirmPwd() {
		return userConfirmPwd;
	}
	public void setUserConfirmPwd(String userConfirmPwd) {
		this.userConfirmPwd = userConfirmPwd;
	}
	public String getSecQuestion1() {
		return secQuestion1;
	}
	public void setSecQuestion1(String secQuestion1) {
		this.secQuestion1 = secQuestion1;
	}
	public String getSecAnswer1() {
		return secAnswer1;
	}
	public void setSecAnswer1(String secAnswer1) {
		this.secAnswer1 = secAnswer1;
	}
	public String getSecQuestion2() {
		return secQuestion2;
	}
	public void setSecQuestion2(String secQuestion2) {
		this.secQuestion2 = secQuestion2;
	}
	public String getSecAnswer2() {
		return secAnswer2;
	}
	public void setSecAnswer2(String secAnswer2) {
		this.secAnswer2 = secAnswer2;
	}
	@Override
	public String toString() {
		return "UserRegistrationModel [email=" + email + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", userName=" + userName + ", userPwd=" + userPwd + ", userConfirmPwd="
				+ userConfirmPwd + ", secQuestion1=" + secQuestion1 + ", secAnswer1=" + secAnswer1 + ", secQuestion2="
				+ secQuestion2 + ", secAnswer2=" + secAnswer2 + "]";
	}



}



