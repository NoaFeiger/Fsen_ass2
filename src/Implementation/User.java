package Implementation;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String organization;
    private String username;

    public User(String firstName, String lastName, String email, String phoneNumber, String organization, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.organization = organization;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOrganization() {
        return organization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean equals(User other){
        return this.username.equals(other.getUsername()) && this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName())
                && this.getEmail().equals(other.getEmail())
                && this.getPhoneNumber().equals(other.getPhoneNumber()) && this.getPassword().equals(other.getPassword());
    }

    private String getUsername() {
        return this.username;
    }

    public void setUsername(String user) {
        this.username = user;
    }
}
