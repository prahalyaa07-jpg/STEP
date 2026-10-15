
import java.util.Scanner;

public class HostelElectricityBill {
    abstract static class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double calculate();
    }

    static class Single extends Room {
        Single(int units) {
            super(units);
        }

        double calculate() {
            return units * 8.0;
        }
    }

    static class Shared extends Room {
        int occupants;

        Shared(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }

        double calculate() {
            return units * 6.0 / occupants;
        }
    }

    static class AC extends Room {
        AC(int units) {
            super(units);
        }

        double calculate() {
            return units * 10.0 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");
            String type = input[0];
            int units = Integer.parseInt(input[1]);

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new Single(units);
                    break;

                case "SHARED":
                    room = new Shared(units, Integer.parseInt(input[2]));
                    break;

                default:
                    room = new AC(units);
            }

            double bill = room.calculate();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
