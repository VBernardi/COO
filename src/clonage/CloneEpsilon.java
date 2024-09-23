package clonage;

public class CloneEpsilon extends Clone{

    public CloneEpsilon(String espece){
        super(espece);
    }

    public void alimenterEnergie(){
        super.stockEnergie = (int)(super.getMaxEnergie() * 0.3);
    }

    public void oxygener(){
        super.stockOxygene = (int)(super.getMaxOxygene() *0.3);
    }

}