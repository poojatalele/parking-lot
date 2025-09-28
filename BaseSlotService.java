public class BaseSlotService implements SlotService {
    @Override
    public boolean has(ServiceType serviceType) {
        return false;
    }

    @Override
    public boolean canFitVehicle(ParkingSlot slot, Vehicle vehicle) {
        return slot.getType().canFit(vehicle.getType());
    }
}
