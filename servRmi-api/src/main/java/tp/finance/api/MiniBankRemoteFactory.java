package tp.finance.api;

import java.rmi.*;

public interface MiniBankRemoteFactory extends Remote {

public Converter remoteConverter() throws RemoteException;
public SimuEmprunt remoteSimulateurEmprunt() throws RemoteException;
}

