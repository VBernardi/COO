package refuge;
public class Chien{
    private final int id;
    private final String nom;
    private final String sexe; // 'f' ou 'm'
    // private final Date dob; 
    private final String proprietaire;
    private final String[] couleurs;

    public Chien(int id, String nom, String sexe, String[] couleurs){
        this.id = id;
        this.nom = nom;
        this.sexe = sexe;
        // this.dob = "";
        this.proprietaire = "";
        this.couleurs = couleurs;
    }

    public Chien creerAvecDOB(int id, String nom, String sexe, String[] couleurs, Date dob){
        return new Chien(id, nom, sexe, couleurs)
    }
}