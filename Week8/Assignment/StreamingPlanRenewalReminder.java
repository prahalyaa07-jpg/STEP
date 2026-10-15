
import java.time.LocalDate;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {
    static class Plan {
        String type;
        String name;
        LocalDate startDate;

        Plan(String type, String name, LocalDate startDate) {
            this.type = type;
            this.name = name;
            this.startDate = startDate;
        }

        LocalDate calculateRenewalDate() {
            switch (type) {
                case "BASIC":
                    return startDate.plusDays(30);
                case "STANDARD":
                    return startDate.plusDays(90);
                default:
                    return startDate.plusDays(365);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0];
            String name = input[1];
            LocalDate startDate = LocalDate.parse(input[2]);

            Plan plan = new Plan(type, name, startDate);

            System.out.println(
                name + ": " + plan.calculateRenewalDate()
            );
        }

        sc.close();
    }
}