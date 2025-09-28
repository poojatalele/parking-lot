import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private String name;
    private List<ParkingSlot> slots;
    private Map<String, ParkingTicket> activeTickets;
    private PricingStrategy pricingStrategy;
    private SlotAllocationStrategy slotAllocationStrategy;

    public ParkingLot(String name, List<ParkingSlot> slots, SlotAllocationStrategy allocationStrategy, PricingStrategy pricingStrategy) {
        this.name = name;
        this.slots = slots;
        this.slotAllocationStrategy = allocationStrategy;
        this.pricingStrategy = pricingStrategy;
        this.activeTickets = new HashMap<>();
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSlot slot = slotAllocationStrategy.findSlot(slots, vehicle);
        if (slot == null) return null;
        slot.parkVehicle(vehicle);
        ParkingTicket ticket = new ParkingTicket(UUID.randomUUID().toString(), vehicle.getLicensePlate(), LocalDateTime.now());
        ticket.setSlotId(slot.getSlotId());
        activeTickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public double exitVehicle(String ticketId, PaymentMethod paymentMethod) {
        ParkingTicket ticket = activeTickets.get(ticketId);
        if (ticket == null) return -1;
        ticket.setExitTime(LocalDateTime.now());
        ParkingSlot slot = findSlotById(ticket.getSlotId());
        double amount = pricingStrategy.calculatePrice(ticket, slot, slot.getParkedVehicle());
        boolean paid = paymentMethod.processPayment(amount);
        if (paid) {
            ticket.setPrice(amount);
            ticket.markPaid();
            slot.removeVehicle();
            activeTickets.remove(ticketId);
            return amount;
        }
        return -1;
    }

    private ParkingSlot findSlotById(String slotId) {
        for (ParkingSlot s : slots) if (s.getSlotId().equals(slotId)) return s;
        return null;
    }

    public void displayAvailability() {
        System.out.println("Parking availability for " + name + ":");
        for (ParkingSlot s : slots) {
            System.out.println(s.getSlotId() + " - " + s.getType() + " - " + (s.isOccupied() ? "OCCUPIED" : "FREE") + " services:" + (s.getSlotService() == null ? "none" : s.getSlotService().has(ServiceType.CHARGING)));
        }
    }

    public void setAllocationStrategy(SlotAllocationStrategy allocationStrategy) {
        this.slotAllocationStrategy = allocationStrategy;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
