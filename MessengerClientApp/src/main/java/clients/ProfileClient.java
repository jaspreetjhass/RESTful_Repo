package clients;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import beans.ProfileResponse;
import customBodyReaders.CustomProfileReader;

public class ProfileClient {

	public static void main(String[] args) throws SQLException {
		System.out.println("Enter your choice :");
		System.out.println("1: get all profiles");
		System.out.println("2: get profile by profile name");
		System.out.println("3: add profile");
		System.out.println("4: update profile");
		System.out.println("5: remove profile");

		Scanner scanner = new Scanner(System.in);
		Integer choice = scanner.nextInt();

		Client client = ClientBuilder.newClient();
		client.register(CustomProfileReader.class);

		WebTarget baseTarget = client.target("http://localhost:7001/MessagerApplication/REST");
		WebTarget profileTarget = baseTarget.path("profiles");
		Builder builder = profileTarget.request();

		Invocation profileInvocation = builder.buildGet();

		switch (choice) {
		case 1:
			getProfiles(profileInvocation);
			break;
		case 2:
			getProfileByName("jaspreetjhass", profileTarget);
			break;
		case 3:
			addProfile(profileTarget);
			break;
		case 4:
			updateProfile(profileTarget);
			break;
		case 5:
			removeProfile(2018123104l, profileTarget);
			break;
		default:
			break;
		}
		scanner.close();
	}

	private static List<ProfileResponse> getProfiles(Invocation profileInvocation) throws SQLException {

		Response response = profileInvocation.invoke();

		if (response.getStatus() == Status.OK.getStatusCode()) {
			List<ProfileResponse> list = response.readEntity(List.class);
			list.forEach(System.out::println);
			return list;
		}

		return null;

	}

	/*
	 * easy way of above method
	 * private static void getProfiles(Invocation profileInvocation) throws SQLException {

		List<ProfileResponse> list = profileInvocation.invoke(new GenericType<List<ProfileResponse>>() {
		});

		list.forEach(System.out::println);

	}
*/
	
	private static void getProfileByName(String profileName, WebTarget profileTarget) throws SQLException {

		ProfileResponse profile = profileTarget.path("{profileName}").resolveTemplate("profileName", profileName)
				.request().get(ProfileResponse.class);

		System.out.println(profile);

	}

	private static void addProfile(WebTarget profileTarget) throws SQLException {

		ProfileResponse profile = new ProfileResponse(2018123104l, "priyaS", "priya", "singh", new Date());
		Response response = profileTarget.request().post(Entity.json(profile));
		System.out.println("add status is " + response.getStatus());
	}

	private static void updateProfile(WebTarget profileTarget) throws SQLException {
		ProfileResponse profile = new ProfileResponse(2018123104l, "priyaSingh", "priya", "kaur", new Date());
		Response response = profileTarget.request().accept(MediaType.APPLICATION_JSON).put(Entity.json(profile));
		System.out.println("update status is status is " + response.getStatus());
	}

	private static void removeProfile(Long profileId, WebTarget profileTarget) throws SQLException {

		Response response = profileTarget.path(String.valueOf(profileId)).request().accept(MediaType.APPLICATION_JSON)
				.delete();
		System.out.println("delete status is status is " + response.getStatus());

	}

}
