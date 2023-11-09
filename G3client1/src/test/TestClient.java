package test;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDao;
import entities.Etudiant;
import entities.Role;

public class TestClient{
	
	@SuppressWarnings("unchecked")
	public static IDao<Etudiant> lookUpEtudiantRemote() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (IDao<Etudiant>) context.lookup("ejb:G3EAR/G3Serveur/EtudiantService!dao.IDao");

	}


	public static void main(String[] args) {
		
		try {
			IDao<Etudiant> dao = lookUpEtudiantRemote();
			//dao.delete(dao.findById(1));
			for(Etudiant e : dao.findAll())
				System.out.println(e);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

