package resources;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import beans.Profile;
import exceptions.MessengerException;
import serviceLayer.ProfileService;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private WebApplicationContext appContext;
	private ProfileService service;

	public ProfileResource(@Context ServletContext context) {
		appContext = WebApplicationContextUtils.getWebApplicationContext(context);
		service = appContext.getBean(ProfileService.class);
	}

	@GET
	public List<Profile> getProfiles() throws SQLException {

		return service.getProfiles();
	}

	@GET
	@Path("{profileName}")
	public Profile getProfileByName(@PathParam("profileName") String profileName) throws SQLException {

		return service.getProfileByName(profileName);
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProfile(Profile profile) throws SQLException {

		Response response = Response.status(Status.CREATED).entity(service.addProfile(profile)).build();
		return response;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(Profile profile) throws SQLException {

		return service.updateProfile(profile);
	}

	@DELETE
	@Path("{profileId}")
	public Response removeProfile(@PathParam(value="profileId")Long profileId) throws SQLException {

		Profile profile = service.getProfile(profileId);
		if (service.removeProfile(profileId))
			return Response.status(Status.PARTIAL_CONTENT).entity(profile).build();
		throw new MessengerException("error while deleting data into db");
	}

}
