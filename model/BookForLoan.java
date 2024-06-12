package model;

import interfaces.ILoanPrice;

public class BookForLoan implements ILoanPrice {
    private String bookId;
    private String title;
    private String author;
    private double bookPrice;
    private double bookLoanPrice;
    private int stock;

    public BookForLoan(){

    }

    public BookForLoan(String bookId, String title, String author, double bookPrice, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.bookPrice = bookPrice;
        this.stock = stock;
        calculateBookLoanPrice();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public double getBookLoanPrice() {
        return bookLoanPrice;
    }

    public void setBookLoanPrice(double bookLoanPrice) {
        this.bookLoanPrice = bookLoanPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "BookForLoan [bookId=" + bookId + ", title=" + title + ", author=" + author + ", stock=" + stock + "]";
    }

    @Override
    public void calculateBookLoanPrice() {
        setBookLoanPrice(bookLoanPrice);
    }
}