package tp.finance.api;

import java.rmi.*;

public interface SimuEmprunt extends Remote {
	
public	double calculMensualite(double capitalEmprunte,double tauxAnnuelPct,int nbMois)
	     throws RemoteException; 

}

