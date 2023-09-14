import java.util.Scanner;

public class EmailAddress {
    private String email;

    /**
     * Default constructor for EmailAddress.
     */
    public EmailAddress() {
        // Empty constructor
    }

    /**
     * Initializes an EmailAddress object with a valid email address.
     *
     * @param email The email address to initialize with.
     */
    public EmailAddress(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            System.out.println("Invalid email address");
        }
    }

    /**
     * Adds a valid email address to this EmailAddress object.
     *
     * @param sc  The Scanner object for user input.
     * @param ans The user's response to whether they want to add an email.
     * @return The valid email address.
     */
    public String addEmail(Scanner sc, String ans) {
        if (ans.equals("y")) {
            System.out.println("Enter a valid email address:");
            email = sc.next();
            while (!isValidEmail(email)) {
                System.out.print("Enter a valid email address (must contain @ and .):");
                email = sc.next();
            }
        }
        return email;
    }

    /**
     * Checks if the provided email address is valid.
     *
     * @param email The email address to validate.
     * @return True if the email is valid, false otherwise.
     */
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".") && email.length() >= 7;
    }

    /**
     * Returns the email address as a string representation.
     *
     * @return The email address as a string.
     */
    @Override
    public String toString() {
        return email;
    }
}
