package tp.serveur.impl;

import tp.finance.api.SerieStat;
import tp.finance.data.Serie;
import tp.finance.data.Stat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SerieStatImpl extends UnicastRemoteObject implements SerieStat {

    private static final long serialVersionUID = 1L;

    public SerieStatImpl() throws RemoteException {
        super(); // pour exportation
    }

    @Override
    public Stat buildSerieStat(Serie serie) throws RemoteException {
        int taille = serie.getTaille();
        double somme = 0;
        for(double v : serie.getValues()){
            somme += v;
        }
        return new Stat("stat_" + serie.getLabel() ,taille , somme / taille);
    }
}
