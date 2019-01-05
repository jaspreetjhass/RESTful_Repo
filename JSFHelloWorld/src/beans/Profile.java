package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="profile")
@SessionScoped
public class Profile implements Serializable {

	private static final long serialVersionUID = 5190441410442621210L;
	private String profileId;
	private String profileName;
	private String firstName;
	private String lastName;
	private String created;
	private String isNavigation;
	private String radio;
	private String checked;
	private List<ProfileBean> profileList;

	public Profile() {

		System.out.println("profile created");

	}

	public Profile(String profileId, String profileName, String firstName, String lastName, String created) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = created;
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

	public List<ProfileBean> getProfileList() {
		return profileList;
	}

	public void setProfileList(List<ProfileBean> profileList) {
		this.profileList = profileList;
	}

	public String getIsNavigation() {
		return isNavigation;
	}

	public void setIsNavigation(String isNavigation) {
		this.isNavigation = isNavigation;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileName=" + profileName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", created=" + created + "]";
	}

}
