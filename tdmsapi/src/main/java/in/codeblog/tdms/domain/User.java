package in.codeblog.tdms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *This is the domain class that will be representing the User detail and
 * will be responsible as a data traveler object 
 * @author Vijay Solanki
 */


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * The unique id of user for the identification of user
	 * Primary key 
	 * Auto generated
	 * 
	 */
	private Long userId; 
	/**
	 *The user name 
	 */
	private String name;
	/**
	 * The user email address
	 */
	private String email;
	
	private String userName;
	/**
	 *  The user contact no
	 */
	private String contact;
	/**
	 * The unique key for the identification of group
	 * foreign key
	 */
	private int groupId;
	/**
	 * getter method for the user 
	 * @return
	 */
	
	public Long getUserId() {
		return userId;
	}
	/**
	 * The setter method for the 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * The setter method for the 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * The setter method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * The getter method for the email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * This holds a message for the user regarding the the status of the pending and the reason for 
	 * not accepting the request 
	 */
	private String message;
	/**
	 * The getter method for the   
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * The setter method for the message
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * The getter method for the userName
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * The toString for the user domain
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", userName=" + userName
				+ ", contact=" + contact + ", groupId=" + groupId + ", message=" + message + ", request=" + request
				+ ", role=" + role + "]";
	}
	/**
	 * The setter method for the userName
	 * @param userName
	 */
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * The getter method for the getContact 
	 * @return
	 */
	
	public String getContact() {
		return contact;
	}
	/**
	 * The setter method for the contact
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * The getter method for the groupId
	 * @return groupId
	 */
	public int getGroupId() {
		return groupId;
	} 
	/**
	 * The setter method for 
	 * @param groupId
	 */
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	/**
	 * The getter method for request 
	 * @return
	 */
	public int getRequest() {
		return request;
	}
	/**
	 * The setter method for setRequest
	 * @param request
	 */
	public void setRequest(int request) {
		this.request = request;
	}
	/**
	 * The getter method for the 
	 * @return
	 */
	public int getRole() {
		return role;
	}
	/**
	 * The setter method for role
	 * 
	 * @param role
	 */
	
	public void setRole(int role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * This the status regarding the regarding the request 
	 * 0  --> pending
	 * 1  -->accepted
	 * 2  -->rejected 
	 */
	private int request;
	/**
	 * The the status regarding the role 
	 * 0-->trainee
	 * 1-->traineer
	 * 2-->manager
	 */
	private int role;
	
	private String password;
}