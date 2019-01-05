package actions;

import javax.faces.bean.ManagedProperty;

import backingBeans.ProfileBean;

public class BaseProfileAction {

	@ManagedProperty(value = "#{profile}")
	protected ProfileBean profileBean;

	public void setProfileBean(ProfileBean profileBean) {
		this.profileBean = profileBean;
	}

	public ProfileBean getProfileBean() {
		return profileBean;
	}

	public String getProfileList() {
		return null;
	}

	public String getProfile() {
		return null;
	}

	public String addProfile() {
		return null;
	}

	public String updateProfile() {
		return null;
	}

	public String deleteProfile() {
		return null;
	}

	public String getProfileCreatedDate() {
		return null;
	}

}
