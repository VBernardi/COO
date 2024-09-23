package jeuNim.modele;

public class NimAvecMax extends Partie{
    private int max;

    public NimAvecMax(int nbTas, int max){
        super(nbTas);
        this.max = max;
    }

    @Override
    public void gererCoup(CoupNim coup) throws CoupInvalideException{
        int numeroTas= coup.getNumeroTas();
        int nb = coup.getNbAllumettes();

        if (nb <= this.max  &&  numeroTas >= 1 && numeroTas <= plateauJeu.length && nb >= 1 && nb <= nbAllumettes(numeroTas)) {

            plateauJeu[numeroTas - 1] -= nb;
        } else {
            throw new CoupInvalideException("Le coup est invalide, rejouez");
        }
    }
}