import java.util.Map;

public class FlatPricingStrategy implements PricingStrategy {
    private Map<VehicleType, Double> flatRates;
    private double chargingRate;

    public FlatPricingStrategy(Map<VehicleType, Double> flatRates, double chargingRate) {
        this.flatRates = flatRates;
        this.chargingRate = chargingRate;
    }

    @Override
    public double calculatePrice(ParkingTicket pTicket, ParkingSlot pSlot, Vehicle vehicle) {
        double base = flatRates.getOrDefault(vehicle.getType(), 0.0);
        double extra = (pSlot.getSlotService().has(ServiceType.CHARGING) && vehicle.isElectric()) ? chargingRate : 0.0;
        return base + extra;
    }
}
