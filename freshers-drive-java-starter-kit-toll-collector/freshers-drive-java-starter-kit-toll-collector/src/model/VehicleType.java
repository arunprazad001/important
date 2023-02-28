package model;

public enum VehicleType {

    TRUCK,
    BUS,
    VAN,
    CAR ,
    RICKSHAW,
    SCOOTER ,
    MOTORBIKE;
    VehicleType() {}

    private final static int TRUCK_FEES = 200;
    private final static int BUS_FEES = 200;
    private final static int VAN_FEES = 100;
    private final static int CAR_FEES = 100;
    private final static int RICKSHAW_FEES = 100;
    private final static int SCOOTER_FEES = 50;
    private final static int MOTORBIKE_FEES = 50;
    private final static int FLAT_FEES = 40;
    public int getAmount() {
        switch (this){
            case TRUCK:
                return TRUCK_FEES;
            case BUS:
                return BUS_FEES;
            case VAN:
                return VAN_FEES;
            case CAR:
                return CAR_FEES;
            case RICKSHAW:
                return RICKSHAW_FEES;
            case SCOOTER:
                return SCOOTER_FEES;
            case MOTORBIKE:
                return MOTORBIKE_FEES;
            default:
                return 0;
        }
    }
    public int getFlatFees() {
        return FLAT_FEES;
    }

}

