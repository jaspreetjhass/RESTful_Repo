package pr.fixed;

import javax.faces.bean.ManagedProperty;
import javax.faces.event.ComponentSystemEvent;

import beans.Profile;

public class BaseProfileAction {

	@ManagedProperty(value = "#{profile}")
	protected Profile profile;

	protected String displayMessage;

	public String getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	protected void initialize(ComponentSystemEvent event) {

	}

	protected String search() {

		System.out.println("entered into base search");
		return null;
	}

	protected String clear() {

		System.out.println("entered into base clear");
		return null;
	}

}
