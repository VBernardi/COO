package clonage;

public class CentreClonageGamma extends CentreClonage{

    public CentreClonageGamma(String nom, String ville){
        super(nom, ville);
    }

    public Clone creerClone(String espece){
        Clone clone = new CloneGamma(espece);
        clone.alimenterEnergie();
        clone.oxygener();
        return clone;
    }
}