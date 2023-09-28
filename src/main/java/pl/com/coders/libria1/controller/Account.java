package pl.com.coders.libria1.controller;

public class Account
{
    private String login;

    public Account(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
