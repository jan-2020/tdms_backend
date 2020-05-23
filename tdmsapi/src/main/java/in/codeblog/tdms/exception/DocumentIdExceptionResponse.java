package in.codeblog.tdms.exception;

public class DocumentIdExceptionResponse {
	String projectIdentifier;
	public DocumentIdExceptionResponse(String projectIdentifier)
	{
		super();
		this.projectIdentifier=projectIdentifier;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	
}
