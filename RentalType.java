package twentytwo.fall.oop.project.M22W0379;

public class RentalType {
    private String type;
    private double totalCost;

    // Constructor to initialize the rental type and cost per day
    public RentalType(String type, double totalCost) {
        this.type = type;
        this.totalCost = totalCost;
    }

    // Getter method to return the rental type
    public String getType() {
        return type;
    }

    // Getter method to return the cost per day of rental
    public double getTotalCost() {
        return totalCost;
    }
}
