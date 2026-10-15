
import java.util.Scanner;

public class PublicTransportFareCalculator {

    abstract static class Transport {
        double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double distance) {
            super(distance);
        }

        double calculateFare() {
            return Math.min(2 + 0.10 * distance, 10);
        }
    }

    static class Train extends Transport {
        Train(double distance) {
            super(distance);
        }

        double calculateFare() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        double peakFactor;

        Metro(double distance, double peakFactor) {
            super(distance);
            this.peakFactor = peakFactor;
        }

        double calculateFare() {
            return (1.50 + 0.20 * distance) * peakFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double distance = Double.parseDouble(input[1]);

            Transport transport;

            switch (type) {
                case "BUS":
                    transport = new Bus(distance);
                    break;

                case "TRAIN":
                    transport = new Train(distance);
                    break;

                default:
                    double peakFactor = Double.parseDouble(input[2]);
                    transport = new Metro(distance, peakFactor);
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
