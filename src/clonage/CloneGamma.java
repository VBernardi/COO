package clonage;

public class CloneGamma extends Clone{

    public CloneGamma(String espece){
        super(espece);
    }

    public void alimenterEnergie(){
        super.stockEnergie = (int)(super.getMaxEnergie() * 0.5);
    }

    public void oxygener(){
        super.stockOxygene = (int)(super.getMaxOxygene() *0.5);
    }

}