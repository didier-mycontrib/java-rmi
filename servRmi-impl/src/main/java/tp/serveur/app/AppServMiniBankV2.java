package tp.serveur.app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.naming.InitialContext;

import tp.serveur.impl.MiniBankImpl;

/* VERSION 2 - RMI-over-JRMP  avec JNDI */


// Application serveur RMI
public class AppServMiniBankV2 {

	public static void main(String[] args) {
		try {
		Registry rmiRegistry = LocateRegistry.createRegistry(1099);
		System.out.println("rmi Registry on server host :" + rmiRegistry.toString());
			
		System.out.println("demarrage du serveur RMI <<AppServMiniBank>> ...");
		System.out.println("... creation et exportation de la factory <<MiniBank>> ");
			MiniBankImpl miniBank = new MiniBankImpl();
			String chNom="MiniBank";
		System.out.println("... enregistrement sous le nom "+chNom);
		
		 java.util.Properties props = System.getProperties();
		    if(props.get("java.naming.factory.initial")==null)
		       props.put("java.naming.factory.initial","com.sun.jndi.rmi.registry.RegistryContextFactory");
		
		    if(props.get("java.naming.provider.url")==null)
		       props.put("java.naming.provider.url","rmi://localhost:1099");
		
		    InitialContext ctx = new InitialContext() ;
			ctx.rebind(chNom,miniBank);
		
		System.out.println("... serveur initialise en attente des requetes");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

