package clonage;

import java.util.HashMap;
import java.util.Map;

public abstract class Clone {
    private int numero;
    private String nom;
    private String espece;
    protected int stockEnergie;
    protected int stockOxygene;
    private final static int MAXENERGIE = 100;
    private final static int MAXOXYGENE = 200;

    private static Map<String, Integer> lesNumerosSuivants = new HashMap<>();

    public Clone(String espece) {
        this.espece = espece;
        Integer num =lesNumerosSuivants.putIfAbsent(espece,1);
        if (num == null)
            numero= 1;
        else {
            numero =++num;
            lesNumerosSuivants.put(espece,num++);
        }
        nom = espece+numero;
    }

    public abstract void alimenterEnergie();
    public abstract void oxygener();

    public int getMaxEnergie(){
        return MAXENERGIE;
    }
    public int getMaxOxygene(){
        return MAXOXYGENE;
    }

    @Override
    public String toString() {
        return "Clone{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                ", espece='" + espece + '\'' +
                ", stockEnergie=" + stockEnergie +
                ", stockOxygene=" + stockOxygene +
                '}';
    }
}
