package clonage;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);

        boolean continuer = true;
        while (continuer) {
            System.out.println("Choisissez l'espèce du clone");
            String espece = sc.nextLine();
            if (espece.equals("q"))
                 continuer=false;
            else {
                CentreClonage centreClonage;
                if (espece.equals("a")){
                    centreClonage = new CentreClonageAlpha("LeCloneLabAlpha","Orleans");
                }else if (espece.equals("e")){
                    centreClonage = new CentreClonageEpsilon("LeCloneLabEpsilon","Orleans");
                }else{
                    centreClonage = new CentreClonageGamma("LeCloneLabGamma","Orleans");
                }
                Clone c = centreClonage.genererClone(espece);
                System.out.println(c);
            }
        }

        sc.close();
    }
}
