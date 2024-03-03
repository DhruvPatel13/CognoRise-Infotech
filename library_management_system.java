import java.util.ArrayList;
import java.util.Scanner;

public class library_management_system {
//    TASK 3: LIBRARY MANAGEMENT SYSTEM
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryCatalog library = new LibraryCatalog();
        String ip;
        System.out.println(">>>>>>>>>> Welcome to the Central Library <<<<<<<<<<");
        do {
            System.out.println( "\n Please select one of the following options: ");
            System.out.println("1.Add Books  2.Return Books  3.Check Out Books  4.Search By Author Name  5.AvailableBooks  6.For Exit");
            ip = sc.nextLine().toLowerCase();
            try {

            switch (ip){
                case "1" -> library.addBook();
                case "2" -> library.returnBook();
                case "3" -> library.issueBooks();
                case "4" -> library.searchByAuthor();
                case "5" -> library.availableBooks();
                case "6" -> System.out.println("Thank You,for visiting your Library.");
                default -> System.out.println("Please provide a valid input!");
            }
            }catch (Exception e){
                System.out.println(e + " Error!");
            }

        }while (!ip.equals("6"));



    }
}


class LibraryCatalog {

    Scanner sc = new Scanner(System.in);

    ArrayList<Book> booksMain = new ArrayList<>();//  Main list of books.
    ArrayList<Book> issuedBooks = new ArrayList<>();// to keep record of checked out book.


    LibraryCatalog() {
        // Constructor to add some of the books
        booksMain.add(new Book("arthahastra", "kautiya", true));
        booksMain.add(new Book("a fine balance", " rohinton mistry", true));
        booksMain.add(new Book(" midnights children", "salman rushdie", true));
        booksMain.add(new Book("a suitable boy", "vikram seth", true));
    }

//  Method to add books.
    public void addBook() {
        System.out.println("Enter the book name you like to add in our library/ Note: One at a time:");
        String titleIP = sc.nextLine().toLowerCase();
        System.out.print("Enter book author name: ");
        String authorIP = sc.nextLine().toLowerCase();

        for (Book b : booksMain) {
            if (b.getTitle().equalsIgnoreCase(titleIP) && b.getAuthor().equalsIgnoreCase(authorIP)) {
                System.out.println("Entered book " + titleIP + " already exist!");
                System.out.println(booksMain.toString());
                return;
            }
        }
        this.booksMain.add(new Book(titleIP, authorIP, true));
        System.out.println("Your book has been added.");
    }

    public void searchByTitle() { // method to search books by tittle , created for practice not used in main method.
        System.out.println("Enter the book Title to search:");
        String titleIP = sc.nextLine();

        for (Book book : booksMain) {
            if (book.getTitle().equalsIgnoreCase(titleIP)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return;
            }
        }
        System.out.println("Book with title '" + titleIP + "' not found.");

    }

    public void searchByAuthor() { // method to search books by author name.
        System.out.println("Enter the book author to search:");
        String authorIP = sc.nextLine().toLowerCase();
        int index = 0;
        for (Book book : booksMain) {
            if (book.getAuthor().equalsIgnoreCase(authorIP)) {
                System.out.println(" we Found " + booksMain.get(index) );
                index++;
                return;
            }
        }
        System.out.println("No books by '" + authorIP + "' author present in library.");

    }

    public void issueBooks() { // for checking out books.
        System.out.println("Enter book title to issue or check out the book:");
        String bookIP = sc.nextLine().toLowerCase();
        boolean run = true;

        for (Book b : booksMain) {
            if (bookIP.equalsIgnoreCase(b.getTitle())) {
                issuedBooks.add(new Book(b.getTitle(), b.getAuthor(), false));
                booksMain.removeIf(book -> book.getTitle().equalsIgnoreCase(bookIP));
                System.out.println(bookIP + " Book  checked out successful.");
                return;
            } else if (true) {
                for (Book checkList : issuedBooks) {
                    if (bookIP.equalsIgnoreCase(checkList.getTitle())) {
                        System.out.println("Sorry the book has already issued to someone!");
                        return;
                    }
                }
            }
        }//for
        System.out.println("No such Book Exist in our library or check spelling!");


    }

    public void returnBook() { // for returning books.
        System.out.println("Enter book title to return book");
        String bookIP = sc.nextLine().toLowerCase();

        for (Book b : issuedBooks) {
            if (b.getTitle().equalsIgnoreCase(bookIP)) {
                booksMain.add(new Book(b.getTitle(), b.getAuthor(), true));
                issuedBooks.removeIf(book -> book.getTitle().equalsIgnoreCase(bookIP));
                System.out.println("Book " + bookIP + " return successful.");
                return;
            } else if (issuedBooks.iterator().hasNext() && !b.getTitle().equalsIgnoreCase(bookIP)) {
                for (Book checkMain : booksMain) {
                    if (checkMain.getTitle().equalsIgnoreCase(bookIP)) {
                        System.out.println("To return the book you have to first have to check out the book.");
                        return;
                    }
                }
            }
        }//for
        System.out.println("These book doesn't belong to our library or check the spelling of the book.");
        System.out.println("Books owned by our Library:\n " + booksMain + issuedBooks);

    }

    public void availableBooks() { // to print list of available books.
        System.out.println("Following is the list of available books in our Library");
        int i = 1, index = 0;
        for (Book b : booksMain) {
            if (b.getStatus()) {
                System.out.print(i + ". " + booksMain.get(index));
                i++;
                index++;
            }
        }
    }


}

class Book {
    private String title, author;
    private boolean status;

//    Constructor to set book attributes.
    Book(String title, String author, boolean status) {
        this.title = title;
        this.author = author;
        this.status = status;
    }

//    getters and setters for getting and setting the values.
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        if (this.status){
        return "Book {" + "Title: " + title + ", Author: " + author + ", Status: " + "available" + '}' + "\n";
        }
        return "Book {" + "Title: " + title + ", Author: " + author + ", Status: " + "checked out" + '}' + "\n";
    }
}
