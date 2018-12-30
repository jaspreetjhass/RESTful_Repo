package resources;

import java.net.URI;
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
import javax.ws.rs.core.UriInfo;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import beans.Message;
import exceptions.MessengerException;
import serviceLayer.MessageService;

@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	private WebApplicationContext appContext;
	private MessageService service;
	private ServletContext context;
	private UriInfo uriInfo;

	public MessageResource(@Context ServletContext context, @Context UriInfo uriInfo) {
		this.context = context;
		this.uriInfo = uriInfo;
		appContext = WebApplicationContextUtils.getWebApplicationContext(context);
		service = appContext.getBean(MessageService.class);
	}

	@GET
	public List<Message> getMessages() throws SQLException {

		return service.getMessages();
	}

	@GET
	@Path("{messageId}")
	public Message getMessage(@PathParam("messageId") Long MessageId) throws SQLException {

		Message message = service.getMessage(MessageId);
		URI selfURI = uriInfo.getAbsolutePathBuilder().build();
		URI profileURI = uriInfo.getBaseUriBuilder().path(ProfileResource.class)
				.path(ProfileResource.class, "getProfileByName").resolveTemplate("profileName", message.getAuthor())
				.build();

		message.addUrl("self", selfURI.toString());
		message.addUrl("profile", profileURI.toString());
		return message;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message Message) throws SQLException {

		Response response = Response.status(Status.CREATED).entity(service.addMessage(Message)).build();
		return response;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message Message) throws SQLException {

		return service.updateMessage(Message);
	}

	@DELETE
	@Path("{messageId}")
	public Response removeMessage(@PathParam(value = "messageId") Long MessageId) throws SQLException {

		Message Message = service.getMessage(MessageId);
		if (service.removeMessage(MessageId))
			return Response.status(Status.PARTIAL_CONTENT).entity(Message).build();
		throw new MessengerException("error while deleting data into db");
	}

	@Path("{messageId}/comments")
	public CommentResource getComments() {

		return new CommentResource(context);
	}

}
