public enum SlotType {
    MOTORCYCLE,
    CAR,
    TRUCK;

    public boolean canFit(VehicleType vehicleType) {
        switch (this) {
            case MOTORCYCLE:
                return vehicleType == VehicleType.MOTORCYCLE || vehicleType == VehicleType.ELECTRIC_MOTORCYCLE;
            case CAR:
                return vehicleType == VehicleType.CAR || vehicleType == VehicleType.ELECTRIC_CAR || vehicleType == VehicleType.MOTORCYCLE || vehicleType == VehicleType.ELECTRIC_MOTORCYCLE;
            case TRUCK:
                return vehicleType == VehicleType.TRUCK;
            default:
                return false;
        }
    }
}
