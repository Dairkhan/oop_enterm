import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSellingProgram {
    private static Scanner scanner = new Scanner(System.in);

    public static Car promptForCar(List<Car> carList) {
        System.out.println("Choose a car from the list:");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println((i + 1) + ". " + carList.get(i).getMake() + " " + carList.get(i).getModel());
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        return carList.get(choice - 1);
    }

    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        carList.add(new SedanCar("Nissan", "Patrol", 2014, 50000, 8));
        carList.add(new SedanCar("Toyota", "Camry 75", 2021, 27000, 5));
        carList.add(new SedanCar("BMW", "M5", 2022, 110000, 5));
        carList.add(new SedanCar("Mercedes-Benz", "S-Class", 2021, 90000, 5));
        carList.add(new SedanCar("Audi", "Q6", 2021, 87000, 5));

        boolean continueShopping = true;

        while (continueShopping) {
            Car selectedCar = promptForCar(carList);
            double discountPercentage = 10.0;
            CarSelling carSelling = new SedanCarSelling((SedanCar) selectedCar, discountPercentage);

            selectedCar.displayDetails();
            carSelling.sellCar();

            double sellingPrice = carSelling.calculatePrice();
            System.out.println("Selling Price: $" + sellingPrice);

            System.out.println("Would you like to purchase this car? (yes/no)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("Congratulations on your purchase!");
            } else {
                System.out.println("Thank you for considering our car.");
            }

            System.out.println("Would you like to continue shopping? (yes/no)");
            String continueAnswer = scanner.nextLine();
            continueShopping = continueAnswer.equalsIgnoreCase("yes");
        }
    }
}
