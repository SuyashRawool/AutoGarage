package autogaragegui2;

import java.util.Scanner;

public class MotorCycle extends Garage{
    public static String []partsAvailabel={"engine","brakes"};
    public static double []partsAvailabelPrices={300.0,400};
    Scanner in=new Scanner(System.in);
    public MotorCycle(String userName,String phoneNo,String segOfVehicle) {
        super(userName, phoneNo, segOfVehicle);
        
    }
    
    public void calcBill(){
        Payment Pay=new Payment(this.partsAvailabel, this.partsDamaged, this.partsAvailabelPrices);
        System.out.println("Bill:"+Pay.calcBill());
    }
    
    void setBrokenParts(String partsDamaged[]){
        this.partsDamaged=partsDamaged;    
    }
    
    String availableParts(){
        String Available=new String("");
        for(String temp:this.partsDamaged){
            for (int i = 0; i < this.partsAvailabel.length; i++) {
                if(temp.equals(this.partsAvailabel[i])){
                    Available+=temp+": Rs."+this.partsAvailabelPrices[i]+"\n";
                }               
            }
        }
        return Available;
    }
    
    String NotAvailableParts(){
        String notAvailable=new String("");
        boolean found=false;
        for(String temp:this.partsDamaged){
            for (int i = 0; i < this.partsAvailabel.length; i++) {
                if(temp.equals(this.partsAvailabel[i])){
                    found=true;
                }               
            }
            if(!found)
                //System.out.println(temp+": This item is not availabe please make an order");
                notAvailable+=temp+": This item is not availabe please make an order\n";
            found=false;
        }
        return notAvailable;
    }
    
    String display(){
        //System.out.println("details: "+this.userName+this.phoneNo+this.segOfVehicle+" ");
        return "Customer Name: "+this.userName+"\nPhone No.: "+this.phoneNo+"\nType of motorCycle:"+this.segOfVehicle+"\n";
    }
}
