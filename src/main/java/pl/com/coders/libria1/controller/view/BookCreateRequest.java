package pl.com.coders.libria1.controller.view;

import pl.com.coders.libria1.domain.Author;

import java.util.Objects;

public class BookCreateRequest {

    private String title;
    private Author author;
    private int amount;
    private CategoryName categoryName;

    public BookCreateRequest(Long id, String title, Author author, int amount, CategoryName categoryName) {
        this.title = title;
        this.author = author;
        this.amount = amount;
        this.categoryName = categoryName;
    }

    public BookCreateRequest() {
    }

    public BookCreateRequest(Long id, String title, String author, int amount) {
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }


    public int getAmount() {
        return amount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCreateRequest that = (BookCreateRequest) o;
        return amount == that.amount && Objects.equals(title, that.title) && Objects.equals(author, that.author) && categoryName == that.categoryName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, amount, categoryName);
    }

}