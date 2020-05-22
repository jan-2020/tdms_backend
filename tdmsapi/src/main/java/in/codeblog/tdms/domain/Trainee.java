package in.codeblog.tdms.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

@Entity
public class Trainee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;

@ManyToMany
@JoinTable(
joinColumns = @JoinColumn(name = "trainee_id"), 
inverseJoinColumns = @JoinColumn(name = "document_id"))
private Set<Document>assignedDocuments=new HashSet<>();

@ManyToMany
@JoinTable(
joinColumns = @JoinColumn(name = "trainee_id"), 
inverseJoinColumns = @JoinColumn(name = "assignment_id"))
private Set<Assignment>assignedAssignments=new HashSet<>();

@ElementCollection
@CollectionTable(name = "submitted_assignment_mapping",
joinColumns = {@JoinColumn()}
		)
@MapKeyColumn(name="assignment_id")
@Column(name="file_name")
private Map<Integer,String>submittedOne=new HashMap<>();












public Map<Integer, String> getSubmittedOne() {
	return submittedOne;
}
public void setSubmittedOne(Map<Integer, String> submittedOne) {
	this.submittedOne = submittedOne;
}
public Set<Assignment> getAssignedAssignments() {
	return assignedAssignments;
}
public void setAssignedAssignments(Set<Assignment> assignedAssignments) {
	this.assignedAssignments = assignedAssignments;
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
public Set<Document> getAssignedDocuments() {
	return assignedDocuments;
}
public void setAssignedDocuments(Set<Document>assignedDocuments) {
	this.assignedDocuments = assignedDocuments;
}
public Trainee() {
	super();
}
}
