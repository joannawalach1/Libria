package pl.com.coders.libria1.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "LEND")
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "lend", cascade = CascadeType.ALL)
    private List<BookLend> bookLends;

    private LocalDateTime lendDate;

    private LendStatus status;

    private LocalDateTime returnDate;

    public Lend(User user, List<BookLend> bookLends) {
        this.user = user;
        this.bookLends = bookLends;
        this.status = LendStatus.LEND_IN_PROGRESS;
    }

    public Lend() {
        this.status = LendStatus.LEND_IN_PROGRESS;
    }

    public LocalDateTime getLendDate() {
        return lendDate;
    }

    public void setLendDate(LocalDateTime lendDate) {
        this.lendDate = lendDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BookLend> getBookLends() {
        return bookLends;
    }

    public void setBookLends(List<BookLend> bookLends) {
        this.bookLends = bookLends;
    }

    public void addLend(BookLend bookLend) {
        this.bookLends.add(bookLend);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LendStatus getStatus() {
        return status;
    }

    public void setStatus(LendStatus status) {
        this.status = status;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
