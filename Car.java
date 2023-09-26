package twentytwo.fall.oop.project.M22W0379;

public class Car {
    private String make;
    private String model;
    private boolean available;

    // Constructor for creating a new car
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        this.available = true;
    }

    // Getter method for car's make
    public String getMake() {
        return make;
    }

    // Getter method for car's model
    public String getModel() {
        return model;
    }

    // Getter method for car's availability status
    public boolean isAvailable() {
        return available;
    }

    // Setter method for car's availability status
    public void setAvailable(boolean available) {
        this.available = available;
    }
}


