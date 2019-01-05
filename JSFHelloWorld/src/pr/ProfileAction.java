package pr;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ap.ProfileMainControl;
import pr.fixed.BaseProfileAction;

@ManagedBean
@RequestScoped
public class ProfileAction extends BaseProfileAction implements Serializable {

	private static final long serialVersionUID = -5872248035543925472L;

	public ProfileAction() {
		System.out.println("ProfileAction created");
	}

	@Override
	public void initialize(ComponentSystemEvent event) {

		if (!("false").equals(profile.getIsNavigation())) {
			System.out.println("entered into profileAction");
			displayMessage = "Welcome to profile Management Application";
			profile.setChecked("true");
			profile.setRadio("Red");
		}

	}

	@Override
	public String clear() {

		System.out.println("enter into clear");

		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("requestParam");
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("profileAction");
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("employee");
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("employee");
		System.out.println("request param value is " + value);

		profile.setProfileId(null);
		profile.setProfileName(null);
		profile.setFirstName(null);
		profile.setLastName(null);
		profile.setCreated(null);
		profile.setProfileList(null);
		profile.setIsNavigation("false");

		return null;
	}

	@Override
	public String search() {

		System.out.println("enter into search");
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(context);

		Employee employee = appContext.getBean(Employee.class);
		ProfileAction action = appContext.getBean(ProfileAction.class);

		ProfileMainControl profileService = appContext.getBean(ProfileMainControl.class);
		profile.setProfileList(profileService.getProfileList());
		profile.setIsNavigation("false");

		return null;
	}
}
