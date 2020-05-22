package in.codeblog.tdms.exception;
/**
 * 
 * @author AjiT
 *
 */

public class GroupNameExceptionResponse {
	private String name;

	public GroupNameExceptionResponse(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
