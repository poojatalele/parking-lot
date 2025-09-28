import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<ParkingSlot> slots = new ArrayList<>();
        SlotService base = new BaseSlotService();
        slots.add(new ParkingSlot("S1", SlotType.CAR, base));
        slots.add(new ParkingSlot("S2", SlotType.MOTORCYCLE, base));

        Map<VehicleType, Double> rates = new HashMap<>();
        rates.put(VehicleType.CAR, 10.0);
        rates.put(VehicleType.MOTORCYCLE, 5.0);

        PricingStrategy pricing = new HourlyPricingStrategy(rates, 2.0);
        SlotAllocationStrategy alloc = new NearestSlotStrategy();

        ParkingLot lot = new ParkingLot("LotA", slots, alloc, pricing);
        Vehicle car = new Vehicle("ABC-123", VehicleType.CAR) {
            @Override
            public boolean isElectric() { return false; }
        };

        ParkingTicket ticket = lot.parkVehicle(car);
        if (ticket != null) System.out.println("Parked with ticket " + ticket.getTicketId());
        lot.displayAvailability();

        double paid = lot.exitVehicle(ticket.getTicketId(), new CashPayment());
        System.out.println("Paid: " + paid);
        lot.displayAvailability();
    }
}
