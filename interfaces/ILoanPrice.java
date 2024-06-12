package interfaces;

public interface ILoanPrice {
    double STOCKUNDERTEN_PERCENTAGE = 0.05;
    double STOCKABOVETEN_PERCENTAGE = 0.03;
    double COMIC_PERCENTAGE = 0.1;
    double NOVEL_PERCENTAGE = 0.05;
    
    public void calculateBookLoanPrice();
}
