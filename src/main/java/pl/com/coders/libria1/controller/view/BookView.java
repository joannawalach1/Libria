package pl.com.coders.libria1.controller.view;

import java.time.LocalDateTime;
import java.util.Objects;

public class BookView {
    private Long id;
    private CategoryName categoryName;

    private String title;
    private String author;
    private int amount;

    private LocalDateTime created;
    private LocalDateTime updated;

    public BookView(Long id, String title, String author, int amount, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.created = created;
        this.updated = updated;
    }

    public BookView() {
    }

    public BookView(Long id, String title, String author, int amount) {
        this(id, title, author, amount, LocalDateTime.now(), LocalDateTime.now());
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
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

    public void setAuthor(String author) {
        this.author = author;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookView bookView = (BookView) o;
        return amount == bookView.amount
                && Objects.equals(id, bookView.id)
                && categoryName == bookView.categoryName
                && Objects.equals(title, bookView.title)
                && Objects.equals(author, bookView.author)
                && Objects.equals(created, bookView.created)
                && Objects.equals(updated, bookView.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, title, author, amount, created, updated);
    }

    public Object thenReturn(BookView book) { return  book;
    }
}

