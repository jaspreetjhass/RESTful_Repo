package staticConcepts;

public class SessionFactory {

	private static SessionFactory sessonFactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessonFactory==null)
		{
			sessonFactory = new SessionFactory();
			return sessonFactory;
		}
		return sessonFactory;
	}
}
