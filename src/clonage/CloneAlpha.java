package clonage;

public class CloneAlpha extends Clone{

    public CloneAlpha(String espece){
        super(espece);
    }

    public void alimenterEnergie(){
        super.stockEnergie = super.getMaxEnergie();
    }

    public void oxygener(){
        super.stockOxygene = super.getMaxOxygene();
    }
}