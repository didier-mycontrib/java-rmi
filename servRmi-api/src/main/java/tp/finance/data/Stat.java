package tp.finance.data;

public class Stat  implements java.io.Serializable {
    private String label;
    private int taille;
    private double moyenne;
    //...


    public Stat(String label, int taille, double moyenne) {
        this.label = label;
        this.taille = taille;
        this.moyenne = moyenne;
    }

    public Stat(String label){
        this(label,0,0.0);
    }

    public Stat(){
        this("stat");
    }

    @Override
    public String toString() {
        return "Stat{" +
                "label='" + label + '\'' +
                ", taille=" + taille +
                ", moyenne=" + moyenne +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
}
