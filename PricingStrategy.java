public interface PricingStrategy {
    double calculatePrice(ParkingTicket pTicket, ParkingSlot pSlot, Vehicle vehicle);
}
