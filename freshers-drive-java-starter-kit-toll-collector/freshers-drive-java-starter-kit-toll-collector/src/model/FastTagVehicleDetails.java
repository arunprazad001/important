package model;

public class FastTagVehicleDetails {

    private final String vehicleNo ;
    private int fastTagBalance ;

    public FastTagVehicleDetails(String vehicleNo, int fastTagBalance) {
        super();
        this.vehicleNo = vehicleNo;
        this.fastTagBalance = fastTagBalance;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public int getFastTagBalance() {
        return fastTagBalance;
    }
    public void setFastTagBalance(int fastTagBalance) {
        this.fastTagBalance = fastTagBalance;
    }

    public void emptyFastTagBalance() {
        fastTagBalance = 0;
    }

}