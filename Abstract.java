package Abstract;
import java.util.HashSet;

public class Abstract {
    public static void main(String[] args) {
        // Test Case 1: Create a valid Book object
        System.out.println("Test Case 1: Create a valid Book object");
        Book book1 = new Book("B001", "Effective Java", "Addison-Wesley", "Joshua Bloch", "978-0134685991", 412);
        book1.displayDetails();

        // Test Case 2: Create a Book with duplicate ID
        System.out.println("Test Case 2: Create a Book with duplicate ID");
        Book book2 = new Book("B001", "Clean Code", "Prentice Hall", "Robert C. Martin", "978-0132350884", 464);
        book2.displayDetails();

        // Test Case 3: Create a Book with duplicate ISBN
        System.out.println("Test Case 3: Create a Book with duplicate ISBN");
        Book book3 = new Book("B002", "Java Concurrency in Practice", "Addison-Wesley", "Brian Goetz", "978-0134685991", 384);
        book3.displayDetails();

        // Test Case 4: Create a Magazine with valid data
        System.out.println("Test Case 4: Create a Magazine with valid data");
        Magazine magazine1 = new Magazine("M001", "National Geographic", "National Geographic Partners", 1, "Monthly");
        magazine1.displayDetails();

        // Test Case 5: Create a Magazine with negative issue number
        System.out.println("Test Case 5: Create a Magazine with negative issue number");
        Magazine magazine2 = new Magazine("M002", "Scientific American", "Springer Nature", -5, "Monthly");
        magazine2.displayDetails();

        // Test Case 6: Create a DVD with valid data
        System.out.println("Test Case 6: Create a DVD with valid data");
        DVD dvd1 = new DVD("D001", "Inception", "Warner Bros.", "Christopher Nolan", 148);
        dvd1.displayDetails();

        // Test Case 7: Create a DVD with a negative duration
        System.out.println("Test Case 7: Create a DVD with a negative duration");
        DVD dvd2 = new DVD("D002", "Interstellar", "Paramount Pictures", "Christopher Nolan", -169);
        dvd2.displayDetails();

        // Test Case 8: Create an item with null or empty values
        System.out.println("Test Case 8: Create items with null or empty values");
        Book book4 = new Book("", "Head First Java", "O'Reilly Media", null, "978-0596009205", 720);
        book4.displayDetails();

        // Test Case 9: Verify unique ID across all items
        System.out.println("Test Case 9: Verify unique ID across all items");
        DVD dvd3 = new DVD("B001", "Tenet", "Warner Bros.", "Christopher Nolan", 150);
        dvd3.displayDetails();
    }
}

abstract class LibraryItem {
    private String id;
    private String title;
    private String publisher;
    private static final HashSet<String> idCollections = new HashSet<String>();

    public LibraryItem(String id, String title, String publisher) {
        setId(id);
        setTitle(title);
        setPublisher(publisher);
    }

    private boolean validateString(String value) {
        return value == null || value.isEmpty();
    }

    public void setId(String id) {
        if (validateString(id) || idCollections.contains(id)) {
            System.out.println("Error: ID must not be null or empty and should be unique");
        } else {
            this.id = id;
            idCollections.add(id);
        }
    }

    public void setTitle(String title) {
        if (validateString(title)) {
            System.out.println("Error: Title must not be null or empty");
        } else {
            this.title = title;
        }
    }

    public void setPublisher(String publisher) {
        if (validateString(publisher)) {
            System.out.println("Error: Publisher must not be null or empty");
        } else {
            this.publisher = publisher;
        }
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    abstract void displayDetails();
}

class Book extends LibraryItem {
    private String author;
    private String isbn;
    private int totalPages;
    private static final HashSet<String> isbnCollections = new HashSet<String>();

    public Book(String id, String title, String publisher, String author, String isbn, int totalPages) {
        super(id, title, publisher);
        setAuthor(author);
        setIsbn(isbn);
        setTotalPages(totalPages);
    }

    private boolean validateString(String value) {
        return value == null || value.isEmpty();
    }

    public void setAuthor(String author) {
        if (validateString(author)) {
            System.out.println("Error: Author must not be null or empty");
        } else {
            this.author = author;
        }
    }

    public void setIsbn(String isbn) {
        if (validateString(isbn) || isbnCollections.contains(isbn)) {
            System.out.println("Error: ISBN must not be null or empty and should be unique");
        } else {
            this.isbn = isbn;
            isbnCollections.add(isbn);
        }
    }

    public void setTotalPages(int totalPages) {
        if (totalPages < 0) {
            System.out.println("Error: Total pages cannot be negative value");
        } else {
            this.totalPages = totalPages;
        }
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    @Override
    public void displayDetails() {
        System.out.printf("ID           : %s\n", getId());
        System.out.printf("Title        : %s\n", getTitle());
        System.out.printf("Publisher    : %s\n", getPublisher());
        System.out.printf("Author       : %s\n", author);
        System.out.printf("ISBN         : %s\n", isbn);
        System.out.printf("Total pages  : %,d\n\n", totalPages);
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;
    private String frequency;

    public Magazine(String id, String title, String publisher, int issueNumber, String frequency) {
        super(id, title, publisher);
        setIssueNumber(issueNumber);
        setFrequency(frequency);
    }

    private boolean validateString(String value) {
        return value == null || value.isEmpty();
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber < 0) {
            System.out.println("Error: Issue number cannot be negative value");
        } else {
            this.issueNumber = issueNumber;
        }
    }

    public void setFrequency(String frequency) {
        if (validateString(frequency)) {
            System.out.println("Error: Frequency must not be null or empty");
        } else {
            this.frequency = frequency;
        }
    }

    public int getIssueNumber() {
        return this.issueNumber;
    }

    public String getFrequency() {
        return this.frequency;
    }

    @Override
    public void  displayDetails() {
        System.out.printf("ID           : %s\n", getId());
        System.out.printf("Title        : %s\n", getTitle());
        System.out.printf("Publisher    : %s\n", getPublisher());
        System.out.printf("Issue number : %,d\n", issueNumber);
        System.out.printf("Frequency    : %s\n\n", frequency);
    }
}

class DVD extends LibraryItem {
    private String director;
    private int duration;

    public DVD(String id, String title, String publisher, String director, int duration) {
        super(id, title, publisher);
        setDirector(director);
        setDuration(duration);
    }

    private boolean validateString(String value) {
        return value == null || value.isEmpty();
    }

    public void setDirector(String director) {
        if (validateString(director)) {
            System.out.println("Error: Director must not be null or empty");
        } else {
            this.director = director;
        }
    }

    public void setDuration(int duration) {
        if (duration < 0) {
            System.out.println("Error: Duration cannot be negative value");
        } else {
            this.duration = duration;
        }
    }

    @Override
    public void displayDetails() {
        System.out.printf("ID           : %s\n", getId());
        System.out.printf("Title        : %s\n", getTitle());
        System.out.printf("Publisher    : %s\n", getPublisher());
        System.out.printf("Director     : %s\n", director);
        System.out.printf("Duration     : %,d\n\n",duration);
    }
}