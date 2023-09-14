package pl.com.coders.libria1.controller.request;

public class AuthorCreateRequest {

    private String firstName;
    private String lastName;

    public AuthorCreateRequest(String firstName, String lastName){
        this.firstName =firstName;
        this.lastName =lastName;

    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

}