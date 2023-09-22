package pl.com.coders.libria1.exception;

public class BookNotExistException extends RuntimeException {

    public BookNotExistException(String title) {
        super("Book not exist with title:" + title);
    }
}
