package clonage;

public abstract class CentreClonage {
    private String nom;
    private String ville;

    public CentreClonage(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    public abstract Clone creerClone(String espece);

    public Clone genererClone(String espece){
        Clone clone = creerClone(espece);
        return clone;
    }
}
