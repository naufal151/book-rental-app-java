import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BookForLoan;
import model.LoanBookOrder;
import model.Member;
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
        for (BookForLoan book : bookList) {
            System.out.println(book);
        }
    }

    public static void loanBook(Scanner in){
        for (BookForLoan book : bookList) {
            System.out.println(book);
        }

        System.out.println("Enter your memberId: ");
        in.nextLine();
        String memberId = in.nextLine();
        System.out.println("Enter bookId you want to loan: ");
        String bookId = in.nextLine();
        System.out.println("Enter your loan duration: ");
        int loanDuration = in.nextInt();
        in.nextLine();

        // validate memberId
        boolean memberExist = false;
        Member foundMember = new Member();
        for (Member member : memberList) {
            if (memberId.equalsIgnoreCase(member.getMemberId())){
                foundMember = member;
                memberExist = true;
                break;
            }
        }

        if (!memberExist){
            System.out.println("Sorry your memberId is invalid");
        }
        else {
            // validate bookId
            boolean bookExist = false;
            for (BookForLoan book : bookList) {
                if (bookId.equalsIgnoreCase(book.getBookId())){
                    bookExist = true;
                    if (book.getStock() > 0){
                        LoanBookOrder loanBook = new LoanBookOrder(foundMember, book, loanDuration);
                        loanList.add(loanBook);
                        book.setStock(book.getStock() - 1);
                        break;
                    }
                    else {
                        System.out.println("Sorry the book is out of stock");
                    }
                }
            }

            if (!bookExist){
                System.out.println("Sorry we don't have the book you are looking for");
            }
            else {
                System.out.println("Book loaned successfully");
            }
        }
    }

    public static void allLoanOrder(){
        for (LoanBookOrder order : loanList) {
            System.out.println(order);
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
