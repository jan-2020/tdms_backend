package in.codeblog.tdms.domain;

import java.util.*;
import java.util.LinkedList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
/**
 * The document POJO will act as a data traveller   
 * @author Raj
 *
 */
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * The unique key for the identification of document
	 */
	private int documentId;
	/**
	 * The name of the document
	 */
	private String name;
	/**
	 * The content of the document
	 */
	private String content;
	/**
	 * The subject of the document
	 */
	private String subject;
	/**
	 * The getter method for the subject
	 * @return
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * The setter method for the subject
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * The getter method for the getTopic
	 * @return
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * The setter method for the topic
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * The getter method for the subTopic
	 * @return
	 */
	public String getSubtopic() {
		return subtopic;
	}
	/**
	 * The setter method for the Subtopic
	 * @param subtopic
	 */
	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}
	/**
	 * The topic of the document
	 */

	private String topic;
	/**
	 * The subtopic of the document
	 */
	private String subtopic;
	
	
	/**
	 * The getter method of the document
	 * @return
	 */
	public int getDocumentId() {
		return documentId;
	}
	/**
	 * The setter method of the document
	 * @param documentId
	 */
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	/**
	 * The getter method of the content 
	 * @return
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * The setter method for the content 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * The set for the trainnes
	 */

	@ManyToMany(mappedBy = "assignedDocuments")
	private Set<Trainee>trainees;
	/**
	 * The getter method for the name
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * The setter method name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * The default constructor for the document
	 */
	public Document() {
		super();
	}
	
}
