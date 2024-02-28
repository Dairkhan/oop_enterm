import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {
    private String make;
    private String model;
    private int year;
    private double price;

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }
}

class SedanCar extends Car {
    private int numSeats;

    public SedanCar(String make, String model, int year, double price, int numSeats) {
        super(make, model, year, price);
        this.numSeats = numSeats;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Seats: " + numSeats);
    }
}

interface CarSelling {
    void sellCar();
    double calculatePrice();
}

class SedanCarSelling implements CarSelling {
    private SedanCar car;
    private double discountPercentage;

    public SedanCarSelling(SedanCar car, double discountPercentage) {
        this.car = car;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void sellCar() {
        System.out.println("Selling Sedan Car - " + car.getMake() + " " + car.getModel());
    }

    @Override
    public double calculatePrice() {
        double discountAmount = car.getPrice() * (discountPercentage / 100);
        return car.getPrice() - discountAmount;
    }
}

