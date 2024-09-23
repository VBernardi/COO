package jeuNim.controleur;
import jeuNim.ihm.Ihm;
import jeuNim.modele.NimAvecMax;


public class ControleurNimMax extends ControleurJeuNim{

    public ControleurNimMax(Ihm ihm) {
        super(ihm);
    }

    @Override
    public void lancerPartie() {
        int nbTas = ihm.demanderNbTas();
        int max = ihm.demanderNbAllumettesARetirerMax();

        partie =  new NimAvecMax(nbTas, max);
        joueurCourant = j1;
        boolean partieFinie = false;
        while (!partieFinie) {
            ihm.afficherEtat(partie.toString());
            faireJouerJoueur(joueurCourant);
            if (partie.partieTerminee())
                partieFinie = true;
            else {
                if (joueurCourant.equals(j1))
                    joueurCourant = j2;
                else
                    joueurCourant = j1;
            }
        }
        gererVainqueur();
    }
}