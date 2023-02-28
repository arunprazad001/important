package model;

public class TollCollect {

    private VehicleType vehicleType;
    private final String vehicleNumber;
    private FastTagVehicleDetails fastTagAccount;
    private final boolean vehicleHasFastTag;
    private final boolean hasReturned;
    private boolean paidByFastTag;

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public TollCollect(VehicleType vehicleType, String vehicleNumber, FastTagVehicleDetails fastTagVehicleDetails, boolean hasReturned ) {

        super();
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.fastTagAccount = fastTagVehicleDetails;
        this.vehicleHasFastTag = fastTagVehicleDetails != null;
        this.hasReturned = hasReturned;

    }

    public int getAmount(){

        if( vehicleHasFastTag && fastTagAccount.getFastTagBalance() >= vehicleType.getAmount()-getDiscountAmount() )
            return vehicleType.getAmount() - getDiscountAmount() ;

        return vehicleType.getFlatFees() + vehicleType.getAmount() - getDiscountAmount() ;

    }

    public boolean isVehicleHasFastTag() {
        return vehicleHasFastTag;
    }

    public boolean isHasReturned() {
        return hasReturned;
    }

    public int getDiscountAmount(){
        return hasReturned ? this.vehicleType.getAmount() / 2 : 0;
    }

    @Override
    public String toString() {
        return "TollCollect [vehicleType=" + vehicleType + ", vehicleNumber=" + vehicleNumber + " ]";
    }

    public int payByCash() {

        if( paidByFastTag ) throw new IllegalStateException("Already paid by FastTag");

        if( !this.vehicleHasFastTag ) return getAmount();
        if( fastTagAccount.getFastTagBalance() >= getAmount() ) return 0;
        return getAmount() - fastTagAccount.getFastTagBalance();

    }

    public int payByFastTag() {

        if( !this.vehicleHasFastTag ) return 0;
        paidByFastTag = true;

        if( fastTagAccount.getFastTagBalance() >=  getAmount() ) {
            int amount = getAmount();
            fastTagAccount.setFastTagBalance( fastTagAccount.getFastTagBalance() - amount );
            return amount;

        }
        int amount = fastTagAccount.getFastTagBalance();
        fastTagAccount.emptyFastTagBalance();
        return amount;
    }

}