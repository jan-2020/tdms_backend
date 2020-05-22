package in.codeblog.tdms.domain;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Entity
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String subjectName;
	private String topicName;
	private String subTopicName;
	
	
	@Column(updatable=false,unique=true)
	private String assignmentIdentifier;
	
	@NotBlank(message="Assignment Content is required")
	@Lob
	@Column(length=5124)
	private String content;
	private String level;
	
	
	@NotBlank(message="Pls provide Assignment Name")
	private String assignmentName;
	
	private Date assign_time;
	
	
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAssign_time() {
		return assign_time;
	}
	public void setAssign_time(Date assign_time) {
		this.assign_time = assign_time;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getSubTopicName() {
		return subTopicName;
	}
	public void setSubTopicName(String subTopicName) {
		this.subTopicName = subTopicName;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	
	public String getAssignmentIdentifier() {
		return assignmentIdentifier;
	}
	public void setAssignmentIdentifier(String assignmentIdentifier) {
		this.assignmentIdentifier = assignmentIdentifier;
	}
	
	
}
