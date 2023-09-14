package pl.com.coders.libria1.controller.request;

import pl.com.coders.libria1.controller.BookLendView;

import java.util.List;

public class ReturnRequest {

    private Long lendId;
    private List<BookLendView> bookLendViews;

    public ReturnRequest(Long lendId, List<BookLendView> bookLendViews) {
        this.lendId = lendId;
        this.bookLendViews = bookLendViews;
    }

    public ReturnRequest() {
    }

    public Long getLendId() {
        return lendId;
    }

    public void setLendId(Long lendId) {
        this.lendId = lendId;
    }

    public List<BookLendView> getBookLendViews() {
        return bookLendViews;
    }

    public void setBookLendViews(List<BookLendView> bookLendViews) {
        this.bookLendViews = bookLendViews;
    }

}
