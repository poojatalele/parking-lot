public abstract class SlotServiceDecorator implements SlotService {
    protected SlotService wrapped;

    public SlotServiceDecorator(SlotService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public boolean has(ServiceType serviceType) {
        return wrapped.has(serviceType);
    }

    @Override
    public boolean canFitVehicle(ParkingSlot slot, Vehicle vehicle) {
        return wrapped.canFitVehicle(slot, vehicle);
    }
}
