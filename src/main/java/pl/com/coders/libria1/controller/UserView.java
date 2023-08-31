package pl.com.coders.libria1.controller;

import java.time.LocalDateTime;

public class UserView {
    private Long id;
    private String login;
    private String password;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;
    public UserView(Long id, String name, String password, String email, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.login = name;
        this.password = password;
        this.email = email;
        this.created = created;
        this.updated = updated;
    }
    public UserView() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

}
