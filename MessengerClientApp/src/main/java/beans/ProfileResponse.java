package beans;

import java.util.Date;

public class ProfileResponse {

	private Long profileId;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;

	public ProfileResponse() {
	}

	public ProfileResponse(Long profileId, String profileName, String firstName, String lastName, Date created) {
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
		return "ProfileResponse [profileId=" + profileId + ", profileName=" + profileName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", created=" + created + "]";
	}

}
