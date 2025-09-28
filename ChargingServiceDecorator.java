public class ChargingServiceDecorator extends SlotServiceDecorator {
    public ChargingServiceDecorator(SlotService wrapped) {
        super(wrapped);
    }

    @Override
    public boolean has(ServiceType serviceType) {
        if (serviceType == ServiceType.CHARGING) return true;
        return super.has(serviceType);
    }
}
