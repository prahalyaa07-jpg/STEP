class LibraryCardData {
    String holderName;
    int booksIssued;
    boolean active;
}

public class LibraryCard {

    public static void main(String[] args) {

        LibraryCardData card = new LibraryCardData();

        System.out.println("Holder: " + card.holderName);
        System.out.println("Books Issued: " + card.booksIssued);
        System.out.println("Active: " + card.active);
    }
}