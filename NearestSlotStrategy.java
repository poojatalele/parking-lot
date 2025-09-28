import java.util.List;

public class NearestSlotStrategy implements SlotAllocationStrategy {
    @Override
    public ParkingSlot findSlot(List<ParkingSlot> slots, Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied() && slot.canFitVehicle(vehicle)) {
                return slot;
            }
        }
        return null;
    }
}
