package in.codeblog.tdms.exception;

public class DocumentIdExceptionResponse {
	String documentIdentifier;
	public DocumentIdExceptionResponse(String documentIdentifier)
	{
		super();
		this.documentIdentifier=documentIdentifier;
	}
	public String getDocumentIdentifier() {
		return documentIdentifier;
	}
	public void setDocumentIdentifier(String documentIdentifier) {
		this.documentIdentifier = documentIdentifier;
	}
	
}
