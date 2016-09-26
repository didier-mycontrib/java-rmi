package tp.serveur.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tp.finance.api.SimuEmprunt;

public class SimuEmpruntImpl extends UnicastRemoteObject implements SimuEmprunt {


	private static final long serialVersionUID = 1L;

	public SimuEmpruntImpl() throws RemoteException {
		super();//for rmi export (visible outside)
	}


	public double calculMensualite(double capitalEmprunte,double tauxAnnuelPct,int nbMois)
		throws RemoteException {
		double tauxMensuel = (tauxAnnuelPct /12)  / 100;	
		double res=0;
		res = capitalEmprunte * tauxMensuel / (1 - Math.pow(1.0+tauxMensuel,-nbMois)) ;
		return res;
	}

}

