package jeuNim.controleur;



import jeuNim.ihm.Ihm;
import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.CoupNim;
import jeuNim.modele.Joueur;
import jeuNim.modele.NimAvecMax;
import jeuNim.modele.Partie;

import java.util.Scanner;

public class ControleurJeuNim {
    protected Ihm ihm;
    protected Joueur j1;
    protected Joueur j2;
    protected Joueur joueurCourant;
    protected String nomVainqueur;
    protected Partie partie;


    public ControleurJeuNim(Ihm ihm) {
        this.ihm = ihm;
        gererJoueurs();

    }

    public void gererJoueurs() {
        j1 = creerJoueur1(ihm.demanderNomJoueur(1));
        j2 = creerJoueur2(ihm.demanderNomJoueur(2));
    }

    public Joueur creerJoueur1(String nom) {
        return new Joueur(nom);
    }

    public Joueur creerJoueur2(String nom) {
        return new Joueur(nom);
    }


    public void gererVainqueur() {
        nomVainqueur = joueurCourant.getNom();
        joueurCourant.gagnePartie();
        ihm.afficherVainqueurPartie(nomVainqueur);
    }


    public void lancerPartie() {
        int nbTas = ihm.demanderNbTas();

        partie =  new Partie(nbTas);
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


    public void faireJouerJoueur(Joueur joueurCourant) {
        boolean joueurAJoue = false;
        while (!joueurAJoue) {
            ihm.afficherDemanderCoup(joueurCourant.getNom());
            CoupNim coup = demanderCoup();
            try {
                partie.gererCoup(coup);
                joueurAJoue = true;

            } catch (CoupInvalideException e) {
                ihm.afficherErreur(e.getMessage());
            }
        }
    }

    public CoupNim demanderCoup() {
        String coup = ihm.demanderCoup();
        Scanner sc = new Scanner(coup);
        return new CoupNim(sc.nextInt(), sc.nextInt());
    }


    public void finirJeu() {

        int nbPartiesGagneesJ1 = j1.getNbPartiesGagnees();
        int nbPartiesGagneesJ2 = j2.getNbPartiesGagnees();

        String nomJ1 = j1.getNom();
        String nomJ2 = j2.getNom();
        if (nbPartiesGagneesJ1 > nbPartiesGagneesJ2)
            nomVainqueur = nomJ1;
        else if (nbPartiesGagneesJ1 < nbPartiesGagneesJ2)
            nomVainqueur = nomJ2;
        else
            nomVainqueur = "ex aequo";
        ihm.afficherInfosFin(nomJ1, nbPartiesGagneesJ1, nomJ2, nbPartiesGagneesJ2, nomVainqueur);

    }
}
