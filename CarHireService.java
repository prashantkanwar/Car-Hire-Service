package twentytwo.fall.oop.project.M22W0379;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class CarHireService {
    private HashMap<String, Car> cars;

    private HashMap<String, User> users;
    ArrayList<RentalType> rentalTypes;
    private List<Customer> customers;
    private User currentUser;

    public CarHireService() {
        // Initialize HashMap to store cars
        cars = new HashMap<String, Car>();
        // Initialize HashMap to store users
        users = new HashMap<String, User>();
        // Initialize ArrayList to store customers
        customers = new ArrayList<Customer>();

        // Add a static admin user to the system
        users.put("admin", new User("admin", "admin", "admin"));
        // Initialize ArrayList to store rental types
        rentalTypes = new ArrayList<RentalType>();
        // Add daily and weekly rental types
        rentalTypes.add(new RentalType("daily", 2000));
        rentalTypes.add(new RentalType("weekly", 13000));
        currentUser = null;
    }

    // Get the currently logged-in user
    public User getCurrentUser() {
        return currentUser;
    }

    // Method to add a new customer
    public void addCustomer(String name) {
        // Only allow if the current user is an admin
        if (currentUser != null && currentUser.getRole().equals("admin")) {
            Customer customer = new Customer(name);
            customers.add(customer);
            System.out.println("Customer added successfully.");
        } else {
            System.out.println("Error: You do not have permission to perform this action.");
        }
    }

    // Method to add a new car
    public void addCar(String make, String model) {
        // Only allow if the current user is an admin
        if (currentUser != null && currentUser.getRole().equals("admin")) {
            Car car = new Car(make, model);
            cars.put(make + " " + model, car);
            System.out.println("Car added successfully.");
        } else {
            System.out.println("Error: You do not have permission to perform this action.");
        }
    }

    // Method to hire a car
    public void hireCar(String make, String model, RentalType rentalType) {

        // Only allow if the current user is a user
        if (currentUser != null && currentUser.getRole().equals("user")) {
            // Get the car from the HashMap using the make and model
            Car car = cars.get(make + " " + model);
            // Check if the car is not null and is available for hire
            if (car != null && car.isAvailable()) {
                // Set the availability of the car to false
                car.setAvailable(false);
                System.out.println("Car hired successfully.");
                System.out.println("Rental type: " + rentalType.getType());
                System.out.println("Total Cost: " + rentalType.getTotalCost());
            } else {
                System.out.println("Error: Car not available for hire.");
            }
        } else {
            System.out.println("Error: You do not have permission to perform this action.");
        }
    }

    // Method to return a car
    public void returnCar(String make, String model) {
        // Only allow if the current user is a user
        if (currentUser != null && currentUser.getRole().equals("user")) {
            // Retrieve the car from the HashMap using the make and model as the key
            Car car = cars.get(make + " " + model);
            // Check if the car is not null and is not available
            if (car != null && !car.isAvailable()) {
                // Set the car's availability to true
                car.setAvailable(true);
                System.out.println("Car returned successfully.");
            } else {
                System.out.println("Error: Car not available for return.");
            }
        } else {
            System.out.println("Error: You do not have permission to perform this action.");
        }
    }

    // Method to register a new user
    public void registerUser(String username, String password) {
        if (users.containsKey(username)) {
            // Check if the username already exists
            System.out.println("Error: Username already exists.");
        } else {
            // Automatically assign the role of "user" to new users
            User user = new User(username, password, "user");
            // add the user to the users HashMap
            users.put(username, user);
            System.out.println("User registered successfully.");
        }
    }

    //Method for login
    public void login(String username, String password) {
        // Check if the user exists in the system and if the provided password matches the stored password
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            // Assign the current user to the logged-in user
            currentUser = user;
            System.out.println("Login successful.");
        } else {
            System.out.println("Error: Invalid username or password.");
        }
    }

    //Method for logout
    public void logout() {
        // Only allow if the current user is logged-in
        if (currentUser != null) {
            currentUser = null;
            System.out.println("Logout successful.");
        } else {
            System.out.println("Error: No user is currently logged in.");
        }
    }
    public HashMap<String, Car> getCars() {
        return cars;
    }

    //Method to display all cars
    public void displayCars() {
        //get all keys of cars
        Set<String> keys = cars.keySet();
        for (String key : keys) {
            Car car = cars.get(key);
            System.out.println(car.getMake() + " " + car.getModel());
        }
    }
}
