class Car extends Vehicle{
    //    Attributes
    private final float fuelCapacity;
    private final float fuelConsumption;

//    Constructor
    Car(float fuelCapacity, float fuelConsumption){
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumption = fuelConsumption;
    }

//overriding methods
    @Override
    void start() {

        System.out.println("Car is starting...");
    }

    @Override
    void stop() {
        System.out.println("Car is stopping...");

    }

    @Override
    float calculateFuelEfficiency() {
        return (fuelCapacity / fuelConsumption) * 100;
    }
}
