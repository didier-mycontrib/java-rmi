package tp.serveur.impl;

import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tp.finance.api.Converter;

public class ConverterImpl extends UnicastRemoteObject implements Converter {

	private static final long serialVersionUID = 1L;

	public ConverterImpl() throws RemoteException {
		super(); // pour exportation
	}
	
	public double euroToFranc(double e) throws RemoteException
	{
		return (e*6.55957);
	}

    public double francToEuro(double f) throws RemoteException
    {
    	return (f / 6.55957);
    }

	@Override
	public String getAuteur() throws RemoteException {
		String authorString = "author xy";
		try {
			java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
			authorString += ("  on " + localMachine.getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return authorString;
	}

}

