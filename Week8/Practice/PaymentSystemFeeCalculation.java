
import java.util.Scanner;

public class PaymentSystemFeeCalculation {
    abstract static class Payment {
        double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract double calculate();
    }

    static class Card extends Payment {
        Card(double amount) {
            super(amount);
        }

        double calculate() {
            return amount * 1.02;
        }
    }

    static class Wallet extends Payment {
        Wallet(double amount) {
            super(amount);
        }

        double calculate() {
            return amount * 1.01;
        }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }

        double calculate() {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            double amount = Double.parseDouble(input[1]);

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new Card(amount);
                    break;

                case "WALLET":
                    payment = new Wallet(amount);
                    break;

                default:
                    payment = new BankTransfer(amount);
            }

            double result = payment.calculate();

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}