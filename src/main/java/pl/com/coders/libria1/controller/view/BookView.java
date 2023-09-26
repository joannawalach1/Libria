package pl.com.coders.libria1.controller.view;

import pl.com.coders.libria1.domain.Author;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class BookView {
    private Long id;

    private String title;
    private Author author;
    private int amount;
    private BigDecimal price;
    private String description;

    private LocalDateTime created;
    private LocalDateTime updated;

    public BookView() {
    }

    public BookView(Long id, String title, Author author, int amount, BigDecimal price, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookView bookView = (BookView) o;
        return amount == bookView.amount
                && Objects.equals(id, bookView.id)
                && Objects.equals(title, bookView.title)
                && Objects.equals(author, bookView.author)
                && Objects.equals(created, bookView.created)
                && Objects.equals(updated, bookView.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, amount, created, updated);
    }

    public Object thenReturn(BookView book) { return  book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

