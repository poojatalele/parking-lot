import java.util.List;

public interface SlotAllocationStrategy {
    ParkingSlot findSlot(List<ParkingSlot> slots, Vehicle vehicle);
}
