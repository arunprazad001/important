package model;

public class VehicleSummaryDetails implements Comparable<VehicleSummaryDetails> {

    private int totalAmountCollected ;
    private int countOfPassedVehicle ;
    public VehicleSummaryDetails() {}

    @Override
    public String toString() {
        return "Pair [ totalAmountCollected=" + totalAmountCollected
                + ", countOfpassedVehicle=" + countOfPassedVehicle + "]";
    }

    private void addAmount(int amount) {
        this.totalAmountCollected += amount;
    }
    private void addCountOfVehicle() {
        this.countOfPassedVehicle++;
    }

    public void updateSummary(int amount) {
        addAmount(amount);
        addCountOfVehicle();
    }

    @Override
    public int compareTo( VehicleSummaryDetails o) {
        return o.totalAmountCollected-this.totalAmountCollected;
    }
    public int getTotalAmountCollected() {
        return totalAmountCollected;
    }

    public void setTotalAmountCollected(int totalAmountCollected) {
        this.totalAmountCollected = totalAmountCollected;
    }

    public int getCountOfPassedVehicle() {
        return countOfPassedVehicle;
    }

    public void setCountOfPassedVehicle(int countOfPassedVehicle) {
        this.countOfPassedVehicle = countOfPassedVehicle;
    }

}