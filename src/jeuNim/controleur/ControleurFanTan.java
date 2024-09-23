package jeuNim.controleur;
import jeuNim.ihm.Ihm;
import jeuNim.modele.FanTan;
import jeuNim.modele.Partie;


public class ControleurFanTan extends ControleurJeuNim{

    public ControleurFanTan(Ihm ihm) {
        super(ihm);
    }

    @Override
    public void lancerPartie() {
        int nbTas = ihm.demanderNbTas();
        int[] nbAllumette = ihm.demanderNbAllumettesParTas(nbTas);


        partie =  new FanTan(nbTas, nbAllumette);
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