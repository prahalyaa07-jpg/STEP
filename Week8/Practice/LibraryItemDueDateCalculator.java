
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {
    abstract static class LibraryItem {
        String title;
        LocalDate issueDate = LocalDate.of(2023, 10, 26);

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getLoanDays();

        LocalDate calculateDueDate() {
            return issueDate.plusDays(getLoanDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int getLoanDays() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }

        int getLoanDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int getLoanDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');

            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;

                case "DVD":
                    item = new DVD(title);
                    break;

                default:
                    item = new Magazine(title);
            }

            System.out.println(
                type + " \"" + item.title + "\": " + item.calculateDueDate()
            );
        }

        sc.close();
    }
}
