package usyd.elec5619.petsh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pet")
public class Pet implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "PetId")
	private Long petId;

	@Column(name = "petName")
	private String petName;

	@Column(name = "petColor")
	private String petColor;

	@Column(name = "petAge")
	private Double petAge;
	
	@Column(name = "petGender")
	private String petGender;
	
	@Column(name = "petCategory")
	private String petCategory;
	
	@Column(name = "petDescription")
	private String petDescription;
	
	@Column(name = "petURL")
	private String petURL;
	
	
	@Column(name = "isAdopted")
	private Boolean isAdopted;
	
	@Column(name = "adoptPersonId")
	private Long adoptPersonId;
	
	
	@Column(name = "adoptTime")
	private String adoptTime;

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetColor() {
		return petColor;
	}

	public void setPetColor(String petColor) {
		this.petColor = petColor;
	}

	public Double getPetAge() {
		return petAge;
	}

	public void setPetAge(Double petAge) {
		this.petAge = petAge;
	}
	
	

	public String getPetURL() {
		return petURL;
	}

	public void setPetURL(String petURL) {
		this.petURL = petURL;
	}

	

	public Boolean getIsAdopted() {
		return isAdopted;
	}

	public void setIsAdopted(Boolean isAdopted) {
		this.isAdopted = isAdopted;
	}

	
	
	public Long getAdoptPersonId() {
		return adoptPersonId;
	}

	public void setAdoptPersonId(Long adoptPersonId) {
		this.adoptPersonId = adoptPersonId;
	}

	public String getAdoptTime() {
		return adoptTime;
	}

	public void setAdoptTime(String adoptTime) {
		this.adoptTime = adoptTime;
	}
	
	
	

	
	
	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public String getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}

	public String getPetDescription() {
		return petDescription;
	}

	public void setPetDescription(String petDescription) {
		this.petDescription = petDescription;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", petColor=" + petColor + ", petAge=" + petAge
				+ ", petURL=" + petURL + ", isAdopted=" + isAdopted + ", adoptPersonId=" + adoptPersonId
				+ ", adoptTime=" + adoptTime + "]";
	}
	
	
	
	
}
