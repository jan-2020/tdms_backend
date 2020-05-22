/*
 * this is domain 
 * which travel from layer to layet
 */
package in.codeblog.tdms.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Document {
	   //id of the document
		@Id
		@GeneratedValue
		private Long documentId;
		@NotBlank(message = "Subject Name required")
		// subjetc of the documet.
		private String subject;
		@NotBlank(message = "Topic name required")
		//topic of the document
		private String topic;
		@NotBlank(message = "Topic should required")
		//sub toic of the document
		private String subTopic;
		@Column(columnDefinition="MEDIUMTEXT")
		//content of the document
		private String content;
		@JsonFormat(pattern = "dd-MM-yyyy")
		
		private  String tag;
		
		@NotBlank(message = "document name  required")
		//name of the document
		private String name;
		//status of the document
		int status=0;
		//date of creation
		Date created_At;
		@JsonFormat(pattern = "dd-MM-yyyy")
		//date of upsation
		Date updated_At;
		
		public Document() {
			super();
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
		
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
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
