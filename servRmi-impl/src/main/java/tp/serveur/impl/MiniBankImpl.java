package tp.serveur.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tp.finance.api.Converter;
import tp.finance.api.MiniBankRemoteFactory;
import tp.finance.api.SimuEmprunt;


public class MiniBankImpl extends UnicastRemoteObject implements MiniBankRemoteFactory {

	private static final long serialVersionUID = 1L;


	public MiniBankImpl() throws RemoteException {
		super(); // pour exportation
	}


	
	public Converter remoteConverter() throws RemoteException {
		return new ConverterImpl();
	}


	public SimuEmprunt remoteSimulateurEmprunt() throws RemoteException {
		return new SimuEmpruntImpl();
	}

}

