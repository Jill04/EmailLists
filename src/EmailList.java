import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EmailList {
    private String listName;
    private int temp = 0;
    private Scanner scanner = new Scanner(System.in);
    private List<EmailAddress> emailList;

    /**
     * Initializes an EmailList object with a name.
     *
     * @param listName The name of the email list.
     */
    public EmailList(String listName) {
        this.listName = listName;
        this.emailList = new LinkedList<>();
    }

    /**
     * Adds an email address to the email list.
     *
     * @param email The EmailAddress object to add to the list.
     */
    public void addEmailAddress(EmailAddress email) {
        emailList.add(email);
    }

    /**
     * Checks if the list name is equal to the provided name.
     *
     * @param name The name to compare with the list name.
     * @return True if the names are equal, false otherwise.
     */
    public boolean isEqual(String name) {
        return listName.equals(name);
    }

    /**
     * Displays the list of email addresses in the email list.
     */
    public void display() {
        System.out.print(listName + " : [");
        for (EmailAddress emailAddr : emailList) {
            if (temp == 0) {
                System.out.print(emailAddr.toString());
                temp = 10;
            } else {
                System.out.print(", " + emailAddr.toString());
            }
        }
        System.out.print("]\n");
        temp = 0;
    }

    /**
     * Adds a new email address to the email list.
     *
     * @return The added EmailAddress object.
     */
    public EmailAddress addNewEmail() {
        EmailAddress newEmail = new EmailAddress();
        newEmail.addEmail(scanner, "y");
        addEmailAddress(newEmail);
        return newEmail;
    }

    /**
     * Deletes an email address from the email list.
     */
    public void deleteEmail() {
        for (int i = 0; i < emailList.size(); i++) {
            System.out.println(i + " " + emailList.get(i));
        }
        System.out.println("Enter the entry number to delete:");
        int index = scanner.nextInt();
        emailList.remove(index);
    }

    /**
     * Returns the list name as a string representation.
     *
     * @return The list name as a string.
     */
    @Override
    public String toString() {
        return listName;
    }
}
