package jeuNim.modele;


/**
 * <p>La classe Tas représente l'état courant de la partie
 * Elle est caractérisée par un tableau. Chaque case du tableau enregistre le nombre d'allumettes de chaque tas.
 * Le nombre d'allumettes du premier tas étant dans la case 0.
 * </p>
 *
 * @author Kahlem
 */
public class Partie {

    /**
     * représente l'état courant de la partie
     */
    protected int[] plateauJeu;
    public Partie() {
    }

    /**
     * crée un ensemble de nbTas tas avec 0 allumettes dans chaque tas
     * @param nbTas le nombre de tas de la partie
     */
    public Partie(int nbTas){
        plateauJeu = new int[nbTas];
        for (int i = 0; i < plateauJeu.length; i++) {
            plateauJeu[i] = 2 * i + 1;
        }
    }

    /**
     * ajoute les allumettes dans chacun des tas de la manière suivante :
     * dans le ième tas, on place 2*i - 1 allumettes.
     */
   /* public void initialiser(){
            for (int i = 0; i < plateau.length; i++) {
                plateau[i] = 2 * i + 1;
            }
    }*/

    

    /**
     * Retourne vrai si la partie est terminée et faux sinon
     * @return
     */
    public boolean partieTerminee() {
        return nbAllumette() == 0;
    }

    /**
     * Nombre d'allumettes par tas
     */
    public int nbAllumettes(int numeroTas) {
        return plateauJeu[numeroTas - 1];
    }

    /**
     * Retourne le nombre total d'allumettes de la partie
     */
    public int nbAllumette(){

    int total = 0;
    for (int nb : plateauJeu)
        total+=nb;
    return total;
    }

    /**
     * retourne l'état de la partie sous forme d'une chaîne de caractères constituées des batons correspondant au nombre d'allumettes pour chaque tas.
     *
     */
    @Override
    public String toString() {
        String s="";
        for (int nbAllumettes : plateauJeu) {
            for (int i = 1; i <= nbAllumettes; i++) {
                s+="| ";
            }
           s+="\n";
        }
        return s;
    }

    /**
     * modifie l'état de la partie en fonction du coup passé en paramètre
     * @param coup
     * @throws CoupInvalideException si le coup est invalide
     */
    public void gererCoup(CoupNim coup) throws CoupInvalideException {
        int numeroTas= coup.getNumeroTas();
        int nb = coup.getNbAllumettes();

        if (numeroTas >= 1 && numeroTas <= plateauJeu.length && nb >= 1 && nb <= nbAllumettes(numeroTas)) {
            plateauJeu[numeroTas - 1] -= nb;

        } else {
            throw new CoupInvalideException("Le coup est invalide, rejouez");
        }
    }
}
