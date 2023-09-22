package pl.com.coders.libria1.controller.view;


import java.time.LocalDateTime;
import java.util.Objects;

public class AuthorView {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDateTime created;
    private LocalDateTime updated;

    public AuthorView(Long id, String firstName, String lastName, LocalDateTime created, LocalDateTime updated){
        this.id =id;
        this.firstName =firstName;
        this.lastName =lastName;
        this.created =created;
        this.updated = updated;
    }
    public AuthorView(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public LocalDateTime getCreated() {return created;}
    public void setCreated(LocalDateTime created) {this.created = created;}
    public LocalDateTime getUpdated() {return updated;}
    public void setUpdated(LocalDateTime updated) {this.updated = updated;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorView that = (AuthorView) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(created, that.created) && Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, created, updated);
    }
}
