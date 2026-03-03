package tp.finance.api;

import tp.finance.data.Serie;
import tp.finance.data.Stat;

import java.rmi.*;

public interface SerieStat extends Remote {
    public Stat buildSerieStat(Serie serie) throws RemoteException;
}
