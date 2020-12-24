package autogaragegui2;

import java.util.Scanner;

public class Payment {
    String[] partsAvailabel;
    String[] partsDamaged;
    double[] partsAvailPrices;
    Scanner in=new Scanner(System.in);
    public Payment(String[] pAvail,String[] pDam,double [] pAvPrices) {
        this.partsAvailabel=pAvail;
        this.partsDamaged=pDam;
        this.partsAvailPrices=pAvPrices;
    }
    public double calcBill(){
        double Bill=0.0;       
        boolean found= false;
        for(String temp:this.partsDamaged){
            for (int i = 0; i < this.partsAvailabel.length; i++) {
                if(temp.equals(this.partsAvailabel[i])){
                    found=true;
                    Bill+=this.partsAvailPrices[i];
                }               
            }
            if(!found)
                System.out.println(temp+": This item is not availabe please make an order");
            found=false;
        }
        return (Bill+this.labourCharge());
    }
    double labourCharge(){
        if(GarageManagementGUI.click==1)
            return 100;
        else
            return 250;
    }
}
