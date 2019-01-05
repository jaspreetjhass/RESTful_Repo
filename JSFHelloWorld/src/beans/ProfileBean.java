package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="profile")
public class ProfileBean implements Serializable{

	private static final long serialVersionUID = -6412155375608165503L;
	@Id
	@Column(name="id")
	private Long profileId;
	@Column(name="profileName")
	private String profileName;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="created")
	private Date created;

	public ProfileBean() {

	}

	public ProfileBean(Long profileId, String profileName, String firstName, String lastName, Date created) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = created;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileName=" + profileName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", created=" + created + "]";
	}

}
