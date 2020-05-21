package in.codeblog.tdms.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "permission is Required")
	private String permissionName;

	@NotNull
	private String moduleId;

	private int trashStatus;

	private int trainee;
	private int trainer;
	private int manager;

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

	public int getTrainee() {
		return trainee;
	}

	public void setTrainee(int trainee) {
		this.trainee = trainee;
	}

	public int getTrainer() {
		return trainer;
	}

	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

}
