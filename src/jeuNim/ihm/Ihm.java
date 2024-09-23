package jeuNim.ihm;

import java.util.Scanner;

public class Ihm {
    Scanner sc = new Scanner(System.in);

    public String demanderNomJoueur(int num) {
        System.out.println("Saisir le nom du joueur" + num);
        return sc.nextLine();

    }

    public int demanderNbTas() {
        System.out.println("Saisir le nombre de tas du jeu");
        int nbTas = 0;

        return recupererEntierStrictPos();
    }

    public int demanderNbAllumettesARetirerMax() {
        System.out.println("Saisir le nombre d'allumette maximum à retirer par coup");
        int max = 0;

        return recupererEntierStrictPos();
    }


    public void afficherEtat(String etatPartie) {

        System.out.println(etatPartie);


    }
    public void afficherDemanderCoup(String nomJoueur) {
        System.out.println(nomJoueur + " à vous de jouer votre coup sous la forme 'm n' où m est le tas choisi et n le nombre d'allumettes à retirer dans ce tas");
    }

    public String demanderCoup() {
        int numeroTas = 0;
        int nbAllumettes = 0;
        while (numeroTas <= 0 || nbAllumettes <= 0) {
            if (sc.hasNextInt()) {
                numeroTas = sc.nextInt();
                if (sc.hasNextInt()) {
                    nbAllumettes = sc.nextInt();
                    if (numeroTas <= 0 || nbAllumettes <= 0) {
                        System.out.println("le numero de ligne et le nombre d'allumettes doit être >=0");
                    }
                } else {
                    System.out.println("Ce n'est pas un entier");
                    sc.next();
                }
            } else {
                System.out.println("Ce n'est pas un entier");
                sc.next();
            }
        }
        sc.nextLine();
        return numeroTas + " "+nbAllumettes;

    }

    public void afficherErreur(String message) {
        System.out.println("Erreur :" + message);
    }

    public void afficherVainqueurPartie(String nomVainqueur) {
        System.out.println("Le vainqueur est " + nomVainqueur);
    }

    public String demandeRejouer() {
        System.out.println("Voulez-vous rejouer? o /n");
        return  sc.nextLine();
    }

    public void afficherInfosFin(String nomJ1, int nbPartiesGagneesJ1, String nomJ2, int nbPartiesGagneesJ2, String nomVainqueur) {
        System.out.println(nomJ1 + " a gagné " + nbPartiesGagneesJ1);
        System.out.println(nomJ2 + " a gagné " + nbPartiesGagneesJ2);
        System.out.println("Résultat final "+ nomVainqueur );
    }


    public int[] demanderNbAllumettesParTas(int nbTas) {
       int[] nbAllumettesParTas = new int[nbTas];
       for (int i=0;i<nbTas;i++){
           System.out.println("Saisir le nombre d'allumettes du tas "+ (i+1));
           nbAllumettesParTas[i]=recupererEntierStrictPos();
       }
       return nbAllumettesParTas;
    }

    public String demanderJeu() {
        System.out.println("A quel jeu souhaitez-vous jouer? Nim (n) ou Fan Tan (f) ");
        return sc.nextLine();
    }
    private int recupererEntierStrictPos(){
        int nb = 0;
        while (nb <= 0) {
            if (sc.hasNextInt()) {
                nb = sc.nextInt();
                sc.nextLine();
                if (nb <= 0)
                    System.out.println("Ce n'est pas un entier strictement positif");
            } else {
                sc.next();
                System.out.println("Ce n'est pas un entier");
            }
        }
        return nb;
    }


}