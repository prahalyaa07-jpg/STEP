
import java.util.Scanner;

public class DeliveryFeeCalculator {
    abstract static class Delivery {
        double weight;
        double distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract double calculateFee();
    }

    static class Standard extends Delivery {
        Standard(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class Express extends Delivery {
        Express(double weight, double distance) {
            super(weight, distance);
        }

        double calculateFee() {
            return 15 + 1.0 * weight + 0.20 * distance;
        }
    }

    static class International extends Delivery {
        double customsFee;

        International(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }

        double calculateFee() {
            return 25 + 2.0 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double weight = Double.parseDouble(input[1]);
            double distance = Double.parseDouble(input[2]);

            Delivery delivery;

            switch (type) {
                case "STANDARD":
                    delivery = new Standard(weight, distance);
                    break;

                case "EXPRESS":
                    delivery = new Express(weight, distance);
                    break;

                default:
                    double customsFee = Double.parseDouble(input[3]);
                    delivery = new International(weight, distance, customsFee);
            }

            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
