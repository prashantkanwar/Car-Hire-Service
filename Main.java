package twentytwo.fall.oop.project.M22W0379;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CarHireService service = new CarHireService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Car Hire Service!");

        while (true) {
            System.out.println("1. Register user");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            if (service.getCurrentUser() != null && service.getCurrentUser().getRole().equals("admin")) {
                System.out.println("4. Add car (admin)");
                System.out.println("5. Add customer (admin)");
            }
            if (service.getCurrentUser() != null && service.getCurrentUser().getRole().equals("user")) {
                System.out.println("6. Hire car (user)");
                System.out.println("7. Return car (user)");
            }
            System.out.println("8. Display Car");
            System.out.println("9. Exit");

            System.out.print("Enter a number (1-9): ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();

                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                service.registerUser(username, password);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                service.login(username, password);
            } else if (choice == 3) {
                service.logout();
            } else if (choice == 4) {
                System.out.print("Enter make: ");
                String make = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                service.addCar(make, model);
            } else if (choice == 5) {
                if (service.getCurrentUser() != null && service.getCurrentUser().getRole().equals("admin")) {
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    service.addCustomer(name);
                }
            } else if (choice == 6) {
                System.out.print("Enter make: ");
                String make = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                System.out.print("Select rental type: ");
                for (int i = 0; i < service.rentalTypes.size(); i++) {
                    System.out.println((i + 1) + "." + service.rentalTypes.get(i).getType());
                }
                int rentalTypeChoice = scanner.nextInt();
                service.hireCar(make, model, service.rentalTypes.get(rentalTypeChoice - 1));
            } else if (choice == 7) {
                System.out.print("Enter make: ");
                String make = scanner.nextLine();
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                service.returnCar(make, model);
            } else if (choice == 8) {
                if (service.getCars().isEmpty()) {
                    System.out.println("No cars are available.");
                } else {
                    service.displayCars();
                }

            } else if (choice == 9) {
                break;
            }

        }
        scanner.close();
    }
}


