import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BookForLoan;
import model.Comic;
import model.LoanBookOrder;
import model.Member;
import model.Novel;
import repository.RepositoryBook;
import repository.RepositoryMember;

public class MainApp {
    static List<BookForLoan> bookList = RepositoryBook.getAllBooks();
    static List<Member> memberList = RepositoryMember.getAllMembers();
    static List<LoanBookOrder> loanList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int choice = 0;

        do {
            System.out.println("Main Menu");
            System.out.println("1. Data all book for loan");
            System.out.println("2. Loan a book");
            System.out.println("3. Return a book");
            System.out.println("4. Data all loan book order");
            System.out.println("0. Exit");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    allBook();
                    break;
                case 2:
                    loanBook(in);
                    break;
                case 3:
                    returnBook(in);
                    break;
                case 4:
                    allLoanOrder();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    public static void allBook(){
    String format = "| %-13s | %-40s | %-20s | %-5s | %n";
    String line = "+---------------+------------------------------------------+----------------------+-------+";
    
    System.out.println(line);
    System.out.printf(format, "Book ID", "Title", "Author", "Stock");
    System.out.println(line);
    
    for (BookForLoan book : bookList) {
        System.out.printf(format,
            book.getBookId(),
            book.getTitle(),
            book.getAuthor(),
            book.getStock()
        );
        System.out.println(line);
    }
    }

    public static void loanBook(Scanner in){
        allBook();
        
        boolean memberExist = false;
        boolean bookExist = false;
        Member foundMember = null;
        do {
            System.out.println("Enter your memberId: ");
            String memberId = in.next();
            
            for (Member member : memberList) {
                if (memberId.equalsIgnoreCase(member.getMemberId())){
                    foundMember = member;
                    memberExist = true;
                    break;
                }
            }

            if (!memberExist){
                System.out.println("Sorry your memberId is invalid");
                System.out.println("Try input your memberId again");
            }
        } while (!memberExist);
        
        do {
            System.out.println("Enter bookId you want to loan: ");
            in.nextLine();
            String bookId = in.nextLine();

            for (BookForLoan book : bookList) {
                if (bookId.equalsIgnoreCase(book.getBookId())){
                    bookExist = true;
                    System.out.println("Enter your loan duration: ");
                    int loanDuration = in.nextInt();
                    in.nextLine();
                    if (book.getStock() > 0){
                        if (book instanceof Comic){
                            Comic comicBook = (Comic) book;
                            Comic newComic = new Comic(
                                comicBook.getBookId(), 
                                comicBook.getTitle(), 
                                comicBook.getAuthor(), 
                                comicBook.getBookPrice(), 
                                comicBook.getStock(), 
                                comicBook.getGenre()
                            );
                            LoanBookOrder loanBook = new LoanBookOrder(foundMember, newComic, loanDuration);
                            loanList.add(loanBook);
                        }
                        else if (book instanceof Novel){
                            Novel novelBook = (Novel) book;
                            Novel newNovel = new Novel(
                                novelBook.getBookId(),
                                novelBook.getTitle(),
                                novelBook.getAuthor(),
                                novelBook.getBookPrice(),
                                novelBook.getStock(),
                                novelBook.isSeries()
                            );
                            LoanBookOrder loanBook = new LoanBookOrder(foundMember, newNovel, loanDuration);
                            loanList.add(loanBook);
                        }
                        book.setStock(book.getStock() - 1);
                        book.calculateBookLoanPrice();
                        System.out.println("Book loaned successfully");
                        break;
                    }
                    else {
                        System.out.println("Sorry the book is out of stock");
                    }
                }
            }

            if (!bookExist){
                System.out.println("Sorry we don't have the book you are looking for");
                System.out.println("Try input bookId again");
            }
        } while (!bookExist);

    }

    public static void allLoanOrder(){
        String format = "| %-10s | %-13s | %-13s | %-40s | %-15s | %-13s | %-10s | %n";
    String line = "+------------+---------------+---------------+------------------------------------------+-----------------+---------------+------------+";
    
    System.out.println(line);
    System.out.printf(format, "Order ID", "Member Name", "Book ID", "Title", "Loan Book Price", "Loan Duration", "Loan Fee");
    System.out.println(line);
    
    for (LoanBookOrder order : loanList) {
        System.out.printf(format,
            order.getOrderId(),
            order.getMember().getName(),
            order.getBook().getBookId(),
            order.getBook().getTitle(),
            order.getBook().getBookLoanPrice(),
            order.getLoanDuration(),
            order.getLoanFee()
        );
        System.out.println(line);
    }
    }

    public static void returnBook(Scanner in){
        System.out.println("Masukkan orderId: ");
        in.nextLine();
        String orderId = in.nextLine();

        boolean orderExist = false;
        for (LoanBookOrder bookLoaned : loanList) {
            if (orderId.equalsIgnoreCase(bookLoaned.getOrderId())){
                orderExist = true;
                BookForLoan book = bookLoaned.getBook();
                book.setStock(book.getStock() + 1);
            }
        }

        if (!orderExist){
            System.out.println("Sorry your orderId is invalid");
        }
        else {
            loanList.removeIf(order -> order.getOrderId().equalsIgnoreCase(orderId));
            System.out.println("Book returned successfully");
        }
        
    }
}
