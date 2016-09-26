package tp.finance.api;

import java.rmi.*;

public interface Converter extends Remote {

public double euroToFranc(double e) throws RemoteException;

public double francToEuro(double f) throws RemoteException;

public String getAuteur() throws RemoteException;
}

