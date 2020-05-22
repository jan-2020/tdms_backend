package in.codeblog.tdms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Entity
public class Document {
	
		/**
		 * This is the unique id for document.
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long documentId;
		
		/**
		 * This is the name of the subject for which document is added.
		 */
		@NotBlank(message = "Subject Name should not be blank")
		String subject;
		
		/**
		 * This is the topic name for the added document.
		 */
		@NotBlank(message = "Topic should not be blank")
		//@Column(updatable = false,unique = true)
		String topic;
		
		/**
		 * This is the name of subTopic for document.
		 */
		String subTopic;
		
		/**
		 * This is the content for a particular topic or subTopic.
		 */
		@Column(columnDefinition="BLOB")
		String content;
		
		//tag to categorize doc according to entered keyword
		String tag;
		
		/**
		 * whether the document is active or hidden
		 * 0=hidden
		 * 1=active
		 */
		int status=0;
		
		/**
		 * Date of creation of a particular document
		 */
		@JsonFormat(pattern = "dd-MM-yyyy")
		Date created_At;
		
		/**
		 * Date of update of the document.
		 */
		@JsonFormat(pattern = "dd-MM-yyyy")
		Date updated_At;	
		
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}		
		public Long getDocumentId() {
			return documentId;
		}
		public void setDocumentId(Long documentId) {
			this.documentId = documentId;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getTopic() {
			return topic;
		}
		public void setTopic(String topic) {
			this.topic = topic;
		}
		public String getSubTopic() {
			return subTopic;
		}
		public void setSubTopic(String subTopic) {
			this.subTopic = subTopic;
		}
		public Date getCreated_At() {
			return created_At;
		}
		public void setCreated_At(Date created_At) {
			this.created_At = created_At;
		}
		public Date getUpdated_At() {
			return updated_At;
		}
		public void setUpdated_At(Date updated_At) {
			this.updated_At = updated_At;
		}
		public Document() {
			super();
		}
		@PrePersist
		protected void onCreate() {
			this.created_At=new Date();
		}
		@PreUpdate
		protected void onUpdate() {
			this.updated_At=new Date();
		}
		
}
