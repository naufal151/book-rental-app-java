package model;

public class LoanBookOrder {
    private static int count = 1;
    private String orderId;
    private Member member;
    private BookForLoan book;
    private int loanDuration;
    private double loanFee;

    public LoanBookOrder(){

    }
    
    public LoanBookOrder(Member member, BookForLoan book, int loanDuration) {
        this.orderId = "Ord-" + count;
        this.member = member;
        this.book = book;
        this.loanDuration = loanDuration;
        calculateLoanFee();
        count++;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookForLoan getBook() {
        return book;
    }

    public void setBook(BookForLoan book) {
        this.book = book;
    }

    public int getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration;
    }

    public double getLoanFee() {
        return loanFee;
    }

    public void setLoanFee(double loanFee) {
        this.loanFee = loanFee;
    }

    @Override
    public String toString() {
        return "LoanBookOrder [orderId=" + orderId + ", member=" + member.getName() + ", bookId=" + book.getBookId() 
        + ", bookTitle=" + book.getTitle() + ", bookLoanPrice=" + book.getBookLoanPrice() + ", loanDuration=" + loanDuration 
        + ", loanFee=" + loanFee + "]";
    }

    public void calculateLoanFee(){
        double loanFee = book.getBookLoanPrice() * loanDuration;
        setLoanFee(loanFee);
    }
}
