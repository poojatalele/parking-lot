# Parking Lot

This repository implements a parking lot system following the provided UML diagram.

Overview
- Models: `Vehicle` (abstract), `VehicleType`, `ParkingSlot`, `ParkingTicket`, `SlotType`, `ServiceType`.
- Strategies: `SlotAllocationStrategy` (`NearestSlotStrategy`), `PricingStrategy` (`HourlyPricingStrategy`, `FlatPricingStrategy`).
- Services: `SlotService` with `BaseSlotService` and decorator `ChargingServiceDecorator`.
- Payments: `PaymentMethod` interface with `CashPayment`, `CardPayment`, `DigitalPayment`.

Build & Run (Windows PowerShell)

1. Compile all .java files:

```powershell
javac -d out *.java
```

2. Run the demo `Main`:

```powershell
java -cp out Main
```

![UML diagram](https://www.mermaidchart.com/d/30bba854-1ab3-4a0d-8485-40deee912158)
