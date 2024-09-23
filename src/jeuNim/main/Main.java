package jeuNim.main;


import java.util.Scanner;

import jeuNim.controleur.ControleurFanTan;
import jeuNim.controleur.ControleurJeuNim;
import jeuNim.controleur.ControleurNimMax;
import jeuNim.ihm.Ihm;

public class Main {
    public static void main(String[] args) {

        Ihm ihm = new Ihm();
        Scanner sc = new Scanner (System.in);

        boolean continuer = true;
        while (continuer) {
            System.out.println("Choisissez votre façon de jouer");
            System.out.println("0 : classique, 1 : Fan Tan, 2 : 1 + choix nb max allumettes retirable par coup" );

        
            String jeu = sc.nextLine();
            if (jeu.equals("q"))
                    continuer=false;
            else {
                ControleurJeuNim controleurJeuNim;
                if (jeu.equals("0")){
                    controleurJeuNim = new ControleurJeuNim(ihm);
                } else if (jeu.equals("1")){
                    controleurJeuNim = new ControleurFanTan(ihm);
                } else{
                    controleurJeuNim = new ControleurNimMax(ihm);
                }
                controleurJeuNim.lancerPartie();
            }
        }

        sc.close();
    }
}
