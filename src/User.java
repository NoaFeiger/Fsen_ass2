public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String organization;

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
}
