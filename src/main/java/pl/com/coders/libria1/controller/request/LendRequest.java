package pl.com.coders.libria1.controller.request;

import pl.com.coders.libria1.controller.BookLendView;
import pl.com.coders.libria1.domain.User;

import java.time.LocalDateTime;
import java.util.List;

public class LendRequest {

    private String username;
    private List<BookLendView> bookLendViews;

    public LendRequest(String userName, List<BookLendView> bookLendViews) {
        this.username = userName;
        this.bookLendViews = bookLendViews;
    }

    public LendRequest() {


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BookLendView> getBookLendViews() {
        return bookLendViews;
    }

    public void setBookLendViews(List<BookLendView> bookLendViews) {
        this.bookLendViews = bookLendViews;
    }

}
