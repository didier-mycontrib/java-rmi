package tp.finance.data;

import java.util.ArrayList;
import java.util.List;

/*
NB: si oubli implements Serializable alors
erreur de type java.rmi.MarshalException: error marshalling arguments;
 */

public class Serie implements java.io.Serializable {
    private String label;
    private List<Double> values ;

    public Serie(String label, List<Double> values) {
        this.label = label;
        this.values = values;
    }

    public Serie(String label){
        this(label,new ArrayList<>());
    }

    public int getTaille(){
        return (this.values!=null)?this.values.size():0;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "label='" + label + '\'' +
                ", values=" + values +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Double> getValues() {
        return values;
    }

    public void setValues(List<Double> values) {
        this.values = values;
    }
}
