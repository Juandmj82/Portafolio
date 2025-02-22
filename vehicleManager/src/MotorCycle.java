class Motorcycle extends Vehicle {
    private final float fuelCapacity;
    private final float fuelConsumption;

    Motorcycle(float fuelCapacity, float fuelConsumption){
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    void start() {
        System.out.println("Motorcycle is starting...");

    }

    @Override
    void stop() {
        System.out.println("Motorcycle is stopping...");

    }

    @Override
    float calculateFuelEfficiency() {
        return (fuelCapacity / fuelConsumption) * 100;
    }
}
