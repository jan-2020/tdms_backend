package in.codeblog.tdms.domain;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
/**
 * This assingment domain conatains all the assingment detail and act as data traveller 
 *  
 * @author Raj
 *
 */
@Entity
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Unique identification key 
	 * It will be primary key
	 * 
	 */
	private int id;
	
	/**
	 * The subject name of the assignment
	 */
	private String subjectName;
	/**
	 * The topic of the assingment 
	 */
	private String topicName;
	/**
	 * The name of the assignment
	 */
	private String assignmentName;
	/**
	 * The name of the subtopic of the assignment  
	 */
	private String subTopicName;
	/**
	 * The details of the assignment
	 */
	private String content;
	/**
	 * The list of the trainees 
	 */
	@ManyToMany(mappedBy = "assignedAssignments")
	private Set<Trainee>trainees;
	/**
	 * The getter method of id  
	 * @return id
	 */

	public int getId() {
		return id;
	}
	/**
	 * the setter method for the id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * defaut constructor for  the Assingment  
	 */
		public Assignment() {
		super();
	}
		/**
		 * Getter Method for the for the subjectName 
		 * @return
		 */
		public String getSubjectName() {
			return subjectName;
		}
		/**
		 * The subject for the asiingment 
		 * @param subjectName
		 */
		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}
		/**
		 * The setter method  topicName   
		 * @return
		 */
		public String getTopicName() {
			return topicName;
		}
		/**
		 * the setter method for the topic
		 * @param topicName
		 */
		public void setTopicName(String topicName) {
			this.topicName = topicName;
		}
		/**
		 * The getter method for the assingment  
		 * @return
		 */
		public String getAssignmentName() {
			return assignmentName;
		}
		/**
		 * the setter method for the 
		 * @param assignmentName
		 */
		public void setAssignmentName(String assignmentName) {
			this.assignmentName = assignmentName;
		}
		/**
		 * The setter method for the subTopicName
		 * @return
		 */
				public String getSubTopicName() {
			return subTopicName;
		}
		/**
		 * The setter method for the subTopic 
		 * @param subTopicName 				 
		 * 
		 */
		public void setSubTopicName(String subTopicName) {
			this.subTopicName = subTopicName;
		}
		/**
		 * The getter method for the content 
		 * @return
		 */
		public String getContent() {
			return content;
		}
		
		/**
		 *The setter method for content  
		 * @param content
		 */
		public void setContent(String content) {
			this.content = content;
		}
	
}
