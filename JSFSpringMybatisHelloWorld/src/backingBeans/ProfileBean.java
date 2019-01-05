package backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="profile")
@SessionScoped
public class ProfileBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6472161866524860936L;
	private String profileId;
	private String profileName;
	private String firstName;
	private String lastName;
	private String created;
	private List profileList;

	public ProfileBean() {
		System.out.println("profile created");
	}
	
	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
	
	public List getProfileList() {
		return profileList;
	}

	public void setProfileList(List profileList) {
		this.profileList = profileList;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileName=" + profileName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", created=" + created + "]";
	}

}
