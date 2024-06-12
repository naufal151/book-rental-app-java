package repository;

import java.util.ArrayList;
import java.util.List;

import model.BookForLoan;
import model.Comic;
import model.Novel;

public class RepositoryBook {
    public static List<BookForLoan> getAllBooks(){
        BookForLoan comic1 = new Comic("Comic - 001", "Uzumaki Naruto", "Masashi Kisimoto", 55000, 10, "Shounen");
        BookForLoan comic2 = new Comic("Comic - 002", "The Worst Client", "Masashi Kisimoto", 35000, 20, "Shounen");
        BookForLoan comic3 = new Comic("Comic - 003", "For the Sake of Dreams...!!", "Masashi Kisimoto", 35000, 15, "Shounen");
        BookForLoan comic4 = new Comic("Comic - 004", "Hunter X Hunter : The Day of Departure", "Yoshihiro Togashi", 50000, 15, "Fantasy");
        BookForLoan comic5 = new Comic("Comic - 005", "Hunter X Hunter : A Struggle in the Mist", "Yoshihiro Togashi", 80000, 25, "Fantasy");
        BookForLoan novel1 = new Novel("Novel - 001", "Harry Potter and the Philosopher's Stone", "J.K Rowling", 150000, 10, true);
        BookForLoan novel2 = new Novel("Novel - 002", "Harry Potter and the Chamber of Secrets", "J.K Rowling", 150000, 10, true);
        BookForLoan novel3 = new Novel("Novel - 003", "Harry Potter and the Prisoner of Azkaban", "J.K Rowling", 200000, 15, true);
        BookForLoan novel4 = new Novel("Novel - 004", "Ayah Aku Berbeda", "Tere Liye", 35000, 15, false);
        BookForLoan novel5 = new Novel("Novel - 005", "Madre", "Dee Lestari", 80000, 10, false);

        List<BookForLoan> bookList = new ArrayList<>();
        bookList.add(comic1);
        bookList.add(comic2);
        bookList.add(comic3);
        bookList.add(comic4);
        bookList.add(comic5);
        bookList.add(novel1);
        bookList.add(novel2);
        bookList.add(novel3);
        bookList.add(novel4);
        bookList.add(novel5);

        return bookList;
    }
}
