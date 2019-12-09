import java.awt.*;
import java.util.Scanner;

public class CLI {


    private Scanner scanner;
    private Manager manager;

    public CLI(){
        this.scanner = new Scanner(System.in);
        this.manager = new Manager();
    }


    public void mainMenu(){

        System.out.println("Home page!\n" +
                            "Please choose one of the following options:");
        System.out.println("1) Login\n2) Register\n3) Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                loginMenu();
                break;
            case 2:
                register();
                break;
            case 3:
                exit();
                break;
        }
    }

    private void exit() {
        System.exit(0);

    }

    private void register() {

        System.out.println("First name:");
        String firstName = scanner.nextLine();
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Organization name:");
        String organizationName = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();


        manager.register(firstName, lastName, email, phoneNumber, organizationName, password);
        System.out.println("Registration successful");

        mainMenu();

    }

    private void loginMenu() {

        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();


        if (manager.login(email, password)){
            System.out.println("Login successful");
            loggedInMenu();
        }

        else {
            System.out.println("Details incorrect");
            mainMenu();
        }
    }

    private void loggedInMenu(){

        System.out.println("1) Add a project\n2) Check status\n3) Logout\n4) Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                addProjectMenu();
                break;
            case 2:
                checkStatus();
                break;
            case 3:
                manager.logout();
                System.out.println("Logout successful");
                mainMenu();
                break;
            case 4:
                exit();
                break;
        }
    }

    private void checkStatus() {

        System.out.println("Project code:");
        int code = Integer.parseInt(scanner.nextLine());

        Project.Status status = manager.checkStatus(code);

        if (status == null) {
            System.out.println("Error: there is no project with this code");
            loggedInMenu();
        }

        System.out.println("Status = " + status);

        loggedInMenu();

    }

    private void addProjectMenu() {

        System.out.println("Project name:");
        String projectName = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        System.out.println("Expected duration:");
        int expectedDuration = Integer.parseInt(scanner.nextLine());

        User currentUser = manager.getCurrentUser();

        System.out.println("Are you sure about that? (y/n)");
        String choice = scanner.nextLine();

        switch (choice){
            case "y":
                break;
            case "n":
                addProjectMenu();
                break;
            default:
                break;
        }

        int prodCode = manager.addProject(projectName, description, expectedDuration, currentUser);

        if (prodCode == -1) {
            System.out.println("Invalid details, sorry!");
            loggedInMenu();
        }

        System.out.println("Successful! Your project code is " + prodCode);

        loggedInMenu();
    }


}
