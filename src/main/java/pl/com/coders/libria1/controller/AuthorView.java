package pl.com.coders.libria1.controller;


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

}
