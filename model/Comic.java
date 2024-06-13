package model;

public class Comic extends BookForLoan {
    private String genre;

    public Comic(){

    }

    public Comic(String bookId, String title, String author, double bookPrice, int stock, String genre){
        super(bookId, title, author, bookPrice, stock);
        this.genre = genre;
        calculateBookLoanPrice();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Comic [bookId=" + getBookId() + ", title=" + getTitle() + ", author=" + getAuthor()
                 + ", stock=" + getStock() + ", genre=" + genre + "]";
    }

    @Override
    public void calculateBookLoanPrice(){
        double loanPrice = 0;
        if (getStock() < 10){
            loanPrice = (COMIC_PERCENTAGE + STOCKUNDERTEN_PERCENTAGE) * getBookPrice();
        }
        else {
            loanPrice = (COMIC_PERCENTAGE + STOCKABOVETEN_PERCENTAGE) * getBookPrice();
        }
        setBookLoanPrice(loanPrice);
    }

        
}
