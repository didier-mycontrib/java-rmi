package tp.serveur.app;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import tp.serveur.impl.MiniBankImpl;

/* VERSION1 - RMI-over-JRMP  sans JNDI */


// Application serveur RMI
public class AppServMiniBank {

	public static void main(String[] args) {
		try {
		Registry rmiRegistry = LocateRegistry.createRegistry(1099);	
			
		System.out.println("demarrage du serveur RMI <<AppServMiniBank>> ...");
		System.out.println("... creation et exportation de la factory <<MiniBank>> ");
			MiniBankImpl miniBank = new MiniBankImpl();
			String chNom="MiniBank";
		System.out.println("... enregistrement sous le nom "+chNom);
			//Naming.rebind(chNom,miniBank);
		    rmiRegistry.rebind(chNom,miniBank);
		System.out.println("... serveur initialise en attente des requetes");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

