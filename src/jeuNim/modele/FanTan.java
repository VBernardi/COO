package jeuNim.modele;

public class FanTan extends Partie{
    private int[] nbAllumette;

    public FanTan(int nbTas, int[] nbAllumette){
        super(nbTas);
        this.nbAllumette = nbAllumette;

        // création du plateau
        plateauJeu = super.plateauJeu;
        for (int i = 0; i < plateauJeu.length; i++) {
            plateauJeu[i] = nbAllumette[i];
        }
    }
}