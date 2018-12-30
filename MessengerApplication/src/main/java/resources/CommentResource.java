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

import beans.Comment;
import beans.Message;
import exceptions.MessengerException;
import serviceLayer.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private WebApplicationContext appContext;
	private CommentService service;

	public CommentResource(@Context ServletContext context) {
		appContext = WebApplicationContextUtils.getWebApplicationContext(context);
		service = appContext.getBean(CommentService.class);
	}

	@GET
	public List<Comment> getComments(@PathParam("messageId") Long messageId) throws SQLException {

		return service.getComments(messageId);
	}

	@GET
	@Path("{commentId}")
	public Comment getComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId)
			throws SQLException {

		return service.getComment(messageId, commentId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment addComment(Comment Comment) throws SQLException {

		return service.addComment(Comment);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment updateComment(Comment Comment) throws SQLException {

		return service.updateComment(Comment);
	}

	@DELETE
	@Path("{commentId}")
	public Response removeComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) throws SQLException {

		Comment comment = service.getComment(messageId,commentId);
		if (service.removeComment(messageId,commentId))
			return Response.status(Status.PARTIAL_CONTENT).entity(comment).build();
		throw new MessengerException("error while deleting data into db");
	}

}
