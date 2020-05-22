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
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Document {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long documentId;
		@NotBlank(message = "Subject Name should not be blank")
		String subject;
		@NotBlank(message = "Topic should not be blank")
		//@Column(updatable = false,unique = true)
		String topic;
		String subTopic;
		@Column(columnDefinition="BLOB")
		String content;
		//tag to categorized doc acc to entered keyword
		String tag;
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
		int status=0;
		@JsonFormat(pattern = "dd-MM-yyyy")
		Date created_At;
		@JsonFormat(pattern = "dd-MM-yyyy")
		Date updated_At;		
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