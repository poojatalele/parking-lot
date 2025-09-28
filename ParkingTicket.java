import java.time.LocalDateTime;

public class ParkingTicket {
    private String ticketId;
    private String vehicleNumber;
    private String slotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double price;
    private boolean isPaid;

    public ParkingTicket(String ticketId, String vehicleNumber, LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.exitTime = null; 
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getSlotId() {
        return slotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markPaid() {
        this.isPaid = true;
    }
}