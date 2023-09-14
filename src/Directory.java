import java.util.ArrayList;

public class Directory {
    private ArrayList<EmailList> emailLists = new ArrayList<>();

    /**
     * Adds an email list to the directory.
     *
     * @param emailList The EmailList object to add.
     */
    public void addList(EmailList emailList) {
        emailLists.add(emailList);
    }

    /**
     * Finds an email list in the directory by its name.
     *
     * @param listName The name of the email list to find.
     * @return The EmailList object if found, or null if not found.
     */
    public EmailList findList(String listName) {
        for (EmailList emailList : emailLists) {
            if (emailList.isEqual(listName)) {
                return emailList;
            }
        }
        return null;
    }

    /**
     * Displays all email lists in the directory.
     */
    public void displayAllLists() {
        for (EmailList emailList : emailLists) {
            emailList.display();
        }
    }
}
