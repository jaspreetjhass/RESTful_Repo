package exceptionHandlers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import beans.ErrorResponse;

@Provider
public class MessengerExceptionHandler implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {

		ErrorResponse res = new ErrorResponse();
		res.setErrorCode("404");
		res.setErrorMessage("Record Not Found");
		Response response = Response.status(Status.NOT_FOUND).entity(res).build();

		return response;
	}

}
