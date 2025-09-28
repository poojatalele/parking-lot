public interface SlotService {
    boolean has(ServiceType serviceType);
    boolean canFitVehicle(ParkingSlot slot, Vehicle vehicle);
}
