package in.codeblog.tdms.domain;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
/**
 * this Permission domain works as data traveler from layer to layer 
 * @author Govind
 *
 */
@Entity
public class Permission {
	/**
	 * This is the unique id for Permission
	 * it is primary key and auto generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * This is the name for Permission added
	 */
	@NotBlank(message = "permission is Required")
	private String permissionName;
	
	/**
	 * This is the module id for Permission
	 * it is foreign key and auto generated
	 */
	
	private String moduleId;
	/**
	 * This is the Trash for Permission
	 * status delete:0 restored:1
	 */
	private int trashStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public @NotNull String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public int getTrashStatus() {
		return trashStatus;
	}

	public void setTrashStatus(int trashStatus) {
		this.trashStatus = trashStatus;
	}

	

		
}

