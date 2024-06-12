package model;

public class Novel extends BookForLoan {
    private boolean isSeries;

    public Novel(){

    }

    public Novel(String bookId, String title, String author, double bookPrice, int stock, boolean isSeries){
        super(bookId, title, author, bookPrice, stock);
        this.isSeries = isSeries;
        calculateBookLoanPrice();
    }

    public boolean isSeries() {
        return isSeries;
    }

    public void setSeries(boolean isSeries) {
        this.isSeries = isSeries;
    }

    @Override
    public String toString() {
        return "Novel [bookId=" + getBookId() + ", title=" + getTitle() + ", author=" + getAuthor()
                + ", stock=" + getStock() + ", isSeries=" + isSeries + "]";
    }

    @Override
    public void calculateBookLoanPrice() {
        double loanPrice;
        if (getStock() < 10){
            loanPrice = (STOCKUNDERTEN_PERCENTAGE + NOVEL_PERCENTAGE) * getBookPrice();
            setBookLoanPrice(loanPrice);
        }
        else if (getStock() >= 10){
            loanPrice = (STOCKABOVETEN_PERCENTAGE + NOVEL_PERCENTAGE) * getBookPrice();
            setBookLoanPrice(loanPrice);
        }
    }
}
