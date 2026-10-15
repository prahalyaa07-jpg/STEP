
import java.util.Scanner;

public class CampusParkingCalculator {
    abstract static class Vehicle {
        int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double calculate();
    }

    static class Bike extends Vehicle {
        Bike(int hours) {
            super(hours);
        }

        double calculate() {
            return hours * 10.0;
        }
    }

    static class Car extends Vehicle {
        Car(int hours) {
            super(hours);
        }

        double calculate() {
            return 30 + (hours - 1) * 20.0;
        }
    }

    static class Truck extends Vehicle {
        Truck(int hours) {
            super(hours);
        }

        double calculate() {
            return Math.max(100, hours * 50.0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            int hours = Integer.parseInt(input[1]);
            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                default:
                    vehicle = new Truck(hours);
            }

            double charge = vehicle.calculate();
            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
