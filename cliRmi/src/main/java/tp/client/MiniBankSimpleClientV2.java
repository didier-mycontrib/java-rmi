
package tp.client;
/*import java.rmi.RMISecurityManager;*/

import javax.naming.InitialContext;

import tp.finance.api.Converter;
import tp.finance.api.MiniBankRemoteFactory;
import tp.finance.api.SimuEmprunt;

/* VERSION 2 - RMI-over-JRMP  avec JNDI */

public class MiniBankSimpleClientV2 {

	public static void main(String[] args) {
	
	try
	{
	/*	
	if(System.getSecurityManager()==null){
		    System.setSecurityManager(new RMISecurityManager()); //now deprecated
		    }
	*/	
		
	System.out.println("demarrage de appli MiniBankSimpleClient  ...");
	String chHostname = "localhost";
	if(args.length>0){
	   chHostname = args[0];
	}

	java.util.Properties props = System.getProperties();
	if(props.get("java.naming.factory.initial")==null)
		props.put("java.naming.factory.initial","com.sun.jndi.rmi.registry.RegistryContextFactory");
		
	if(props.get("java.naming.provider.url")==null)
		props.put("java.naming.provider.url","rmi://"+chHostname+":1099");
		
	
	InitialContext ctx = new InitialContext() ;
	
	MiniBankRemoteFactory miniBank = (MiniBankRemoteFactory) ctx.lookup("MiniBank");
	/*Object obj = ctx.lookup("MiniBank");
	MiniBank miniBank =
              (MiniBank) PortableRemoteObject.narrow(obj,MiniBank.class);*/
	
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

