package in.codeblog.tdms.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
@Id
private Long id;

private String name;

private String userName;

private String email;

private String password;

private long contact;

private int groupId;

private int request;

private int role;

private String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}

public int getGroupId() {
	return groupId;
}

public void setGroupId(int groupId) {
	this.groupId = groupId;
}

public int getRequest() {
	return request;
}

public void setRequest(int request) {
	this.request = request;
}

public int getRole() {
	return role;
}

public void setRole(int role) {
	this.role = role;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
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


}
