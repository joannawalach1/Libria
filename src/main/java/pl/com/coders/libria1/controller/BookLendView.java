package pl.com.coders.libria1.controller;

public class BookLendView {
    private String bookTitle;
    private int amount;

    public BookLendView(String bookTitle, int amount) {
        this.bookTitle = bookTitle;
        this.amount = amount;
    }

    public BookLendView() {
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
