import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class HourlyPricingStrategy implements PricingStrategy {
    private Map<VehicleType, Double> hourlyRates;
    private double chargingRate;

    public HourlyPricingStrategy(Map<VehicleType, Double> hourlyRates, double chargingRate) {
        this.hourlyRates = hourlyRates;
        this.chargingRate = chargingRate;
    }

    @Override
    public double calculatePrice(ParkingTicket pTicket, ParkingSlot pSlot, Vehicle vehicle) {
        LocalDateTime entry = pTicket.getEntryTime();
        LocalDateTime exit = pTicket.getExitTime() == null ? LocalDateTime.now() : pTicket.getExitTime();
        long minutes = Duration.between(entry, exit).toMinutes();
        double hours = Math.ceil(minutes / 60.0);
        double rate = hourlyRates.getOrDefault(vehicle.getType(), 0.0);
        double total = rate * hours;
        if (pSlot.getSlotService().has(ServiceType.CHARGING) && vehicle.isElectric()) {
            total += chargingRate * hours;
        }
        return total;
    }
}
