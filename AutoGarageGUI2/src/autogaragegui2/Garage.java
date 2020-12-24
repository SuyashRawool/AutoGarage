package autogaragegui2;



abstract public class Garage {
    String userName,phoneNo,segOfVehicle;
    String[] partsDamaged;
    

    public Garage(String userName,String phoneNo,String segOfVehicle) {
        
        this.userName=userName;
        this.phoneNo=phoneNo;
        this.segOfVehicle=segOfVehicle;
    }
    abstract void calcBill();
    
    
}
