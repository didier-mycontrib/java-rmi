
package tp.client;
/*
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
*/
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import tp.finance.api.Converter;
import tp.finance.api.MiniBankRemoteFactory;
import tp.finance.api.SimuEmprunt;

/* VERSION1 - RMI-over-JRMP  sans JNDI */

public class MiniBankSimpleClient {

	public static void main(String[] args) {
	
	try
	{
	String chHostname = "localhost";
	if(args.length>0){
			   chHostname = args[0];
	}
    /*	
    // OLD-STYLE :	
	if(System.getSecurityManager()==null){
		    System.setSecurityManager(new RMISecurityManager());
		    }
   
	String chUrl = "rmi://" + chHostname +"/MiniBank";
	RemoteMiniBank miniBank = (RemoteMiniBank) Naming.lookup(chUrl);	
	*/
	System.out.println("demarrage de appli MiniBankSimpleClient  ...");

	Registry rmiRegistry = LocateRegistry.getRegistry(chHostname, 1099);	
	MiniBankRemoteFactory miniBank = (MiniBankRemoteFactory) rmiRegistry.lookup("MiniBank");

	System.out.println("connexion a la factory <<MiniBank>> effectuee .");
	
	SimuEmprunt simuEmprunt = (SimuEmprunt) miniBank.remoteSimulateurEmprunt();
	System.out.println("reference obtenue vers un objet distant de type SimuEmprunt.");
	
	double mensualite = simuEmprunt.calculMensualite(100000,2,20*12);
	System.out.println("100000 E sur 20ans avec un taux de 2%\n necessite des mensualites de "
	                   + mensualite);
	
	simuEmprunt = null; // donner un coup de pouce au ramasse-miettes distribue
	
	Converter convertisseur = (Converter) miniBank.remoteConverter();
	System.out.println("reference obtenue vers un objet distant de type Converter.");
	
	double nbEuro = convertisseur.francToEuro(100);
	System.out.println("100 F = " + nbEuro + "E");
	
	String auteur = convertisseur.getAuteur();
	System.out.println("auteur = " + auteur);
		
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
		
	}
}

