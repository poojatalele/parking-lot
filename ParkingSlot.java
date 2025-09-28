public class ParkingSlot {
    private String slotId;
    private SlotType type; 
    private SlotService slotService;
    private Vehicle parkedVehicle;
    private boolean isOccupied;


    public ParkingSlot(String slotId, SlotType type, SlotService slotService) {
        this.slotId = slotId;
        this.type = type;
        this.slotService = slotService;
        this.isOccupied = false;
    }

    public String getSlotId() {
        return slotId;
    }

    public SlotType getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public SlotService getSlotService() {
        return slotService;
    }

    public void setSlotService(SlotService slotService) {
        this.slotService = slotService;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return slotService.canFitVehicle(this, vehicle);
    }
}
