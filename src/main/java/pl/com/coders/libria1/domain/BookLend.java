package pl.com.coders.libria1.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "BOOK_LEND")
public class BookLend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lend_id", nullable = false)
    private Lend lend;

    @OneToOne
    private Book book;

    @Column(nullable = false)
    private int amount;

    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public BookLend(Lend lend, Book book, int amount) {
        this.lend = lend;
        this.book = book;
        this.amount = amount;
    }

    public BookLend() {
    }

    public Lend getLend() {
        return lend;
    }

    public void setLend(Lend lend) {
        this.lend = lend;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
