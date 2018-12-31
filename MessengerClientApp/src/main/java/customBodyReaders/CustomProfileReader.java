package customBodyReaders;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import beans.ProfileResponse;

@Provider
public class CustomProfileReader implements MessageBodyReader<List<ProfileResponse>> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		return type.getName().equals(List.class.getName());
	}

	@Override
	public List<ProfileResponse> readFrom(Class<List<ProfileResponse>> type, Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		int ch;
		StringBuilder sb = new StringBuilder();
		while ((ch = entityStream.read()) != -1)
			sb.append((char) ch);

		Type listType = new TypeToken<List<ProfileResponse>>() {
		}.getType();
		List<ProfileResponse> outputList = new Gson().fromJson(sb.toString(), listType);

		return outputList;
	}

}
