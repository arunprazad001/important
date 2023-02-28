package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentSummaryDetails {

    private int fastTagAmountCollected;
    private int cashAmountCollected;
    private int totalAmountCollected;
    private int totalDiscountGiven;
    private HashMap< VehicleType, VehicleSummaryDetails> vechiclesummary;
    public VehicleSummaryDetails getVehicleSummarySet(VehicleType vehicleType ) {
        return vechiclesummary.get( vehicleType );
    }
    public PaymentSummaryDetails() {
        vechiclesummary = new HashMap<>();
        reset();
    }

    public void collectToll( TollCollect tollCollect ) {

        VehicleSummaryDetails vehicleSummary = vechiclesummary.get( tollCollect.getVehicleType() );
        vehicleSummary.updateSummary( tollCollect.getAmount() );

        this.totalAmountCollected += tollCollect.getAmount();
        this.totalDiscountGiven += tollCollect.getDiscountAmount();
        this.cashAmountCollected += tollCollect.payByCash();
        this.fastTagAmountCollected += tollCollect.payByFastTag();

    }

    public int getFastTagAmountCollected() {
        return fastTagAmountCollected;
    }

    public void setFastTagAmountCollected(int fastTagAmountCollected) {
        this.fastTagAmountCollected = fastTagAmountCollected;
    }

    public int getCashAmountCollected() {
        return cashAmountCollected;
    }

    public void setCashAmountCollected(int cashAmountCollected) {
        this.cashAmountCollected = cashAmountCollected;
    }

    public int getTotalAmountCollected() {
        return totalAmountCollected;
    }

    public void setTotalAmountCollected(int totalAmountCollected) {
        this.totalAmountCollected = totalAmountCollected;
    }

    public int getTotalDiscountGiven() {
        return totalDiscountGiven;
    }

    public void setTotalDiscountGiven(int totalDiscountGiven) {
        this.totalDiscountGiven = totalDiscountGiven;
    }

    private final void reset(){
        vechiclesummary.put( VehicleType.BUS ,       new VehicleSummaryDetails()  );
        vechiclesummary.put( VehicleType.TRUCK ,     new VehicleSummaryDetails()  );
        vechiclesummary.put( VehicleType.CAR ,       new VehicleSummaryDetails()  );
        vechiclesummary.put( VehicleType.VAN ,       new VehicleSummaryDetails()  );
        vechiclesummary.put( VehicleType.MOTORBIKE , new VehicleSummaryDetails()  );
        vechiclesummary.put( VehicleType.SCOOTER ,   new VehicleSummaryDetails()  );
        vechiclesummary.put( VehicleType.RICKSHAW ,  new VehicleSummaryDetails()  );

    }

    public String getSummary(){

        StringBuilder sb = new StringBuilder();
        List< Map.Entry< VehicleType, VehicleSummaryDetails> > list = getSortedVehicleSummary();

        sb.append("TOTAL_COLLECTION ").append(totalAmountCollected).append(" ").append(totalDiscountGiven).append("\n");
        sb.append("PAYMENT_SUMMARY ").append(fastTagAmountCollected).append(" ").append(cashAmountCollected).append("\n");
        sb.append("VEHICLE_TYPE_SUMMARY").append("\n");

        list.forEach( entry -> {
            if( entry.getValue().getTotalAmountCollected()!=0 )
                sb.append( entry.getKey() ).append(" ")
                        .append(entry.getValue().getCountOfPassedVehicle()).append("\n");
        });

        return sb.toString();
    }
    private List< Map.Entry<VehicleType, VehicleSummaryDetails> > getSortedVehicleSummary(){

        List< Map.Entry<VehicleType, VehicleSummaryDetails> > list = new ArrayList<>( vechiclesummary.entrySet() );

        list.sort( (o1, o2) -> {

            int val1 = o2.getValue().getTotalAmountCollected();
            int val2 = o1.getValue().getTotalAmountCollected();

            return val1 == val2 ? o1.getKey().toString().compareTo( o2.getKey().toString() ) : val1 - val2;

        });

        return list;
    }

}