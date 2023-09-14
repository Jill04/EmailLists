import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
    private String listName, email;
    private Scanner scanner = new Scanner(System.in);
    private EmailList el;
    private Directory dl = new Directory();
    
    public static void main(String[] args) throws IOException {
        Main m1 = new Main();
        m1.getMenu();
    }
    
    // Method to display the menu and handle user choices
    public void getMenu() throws IOException {
        String str;
        do {
            System.out.print("Enter c to create a new list\n" +
                    "      p to display all lists\n" +
                    "      a to add an entry to a list\n" +
                    "      d to delete from a list\n" +
                    "      l to display a list\n" +
                    "      f to load lists from a file\n" +
                    "      q to quit:");
            str = scanner.next().trim().toLowerCase();

            switch (str) {
                case "c":
                    addEmailsToList();
                    break;

                case "p":
                    dl.displayAllList();
                    break;

                case "a":
                    System.out.println("Enter the name of the list to add to:");
                    String name = scanner.next();
                    EmailList demo3 = dl.findList(name);
                    if (demo3 == null) {
                        System.out.println("List not found");
                    } else {
                        demo3.addNewEmail();
                    }
                    break;

                case "d":
                    System.out.println("Enter the name of the list to delete from:");
                    name = scanner.next();
                    EmailList demo2 = dl.findList(name);
                    if (demo2 == null) {
                        System.out.println("List not found");
                    } else {
                        demo2.deleteEmail();
                    }
                    break;

                case "l":
                    System.out.println("Enter the name of the list to display:");
                    name = scanner.next();
                    EmailList demo = dl.findList(name);
                    if (demo == null) {
                        System.out.println("List not found");
                    } else {
                        demo.display();
                    }
                    break;

                case "f":
                    System.out.println("Enter file to process");
                    String fname = scanner.next();
                    fileProcessing(fname);
                    break;

                case "q":
                    break;

                default:
                    System.out.println("Please Enter a Valid Choice:");
            }
        } while (!str.equals("q"));
    }

    // Method to add email addresses to a list
    public void addEmailsToList() {
        boolean b = false;
        System.out.println("Enter the name of the list:");
        String ans;
        listName = scanner.next();
        el = new EmailList(listName);

        while (!b) {
            EmailAddress em = new EmailAddress();
            em.addEmail(scanner, "y");
            el.generateList(em);
            System.out.println("Another? y/n:");
            ans = scanner.next().toLowerCase().trim();
            if (ans.equals("y")) {
                continue;
            } else if (ans.equals("n")) {
                b = true;
            } else {
                System.out.println("Enter a valid choice");
            }
        }
        dl.addList(el);
    }
  
   // Method to process a file containing email lists
    public void fileProcessing(String fname) {
        try {
            File f = new File(fname);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s;
            List<String> list = new ArrayList<String>();
            while ((s = br.readLine()) != null) {
                list.add(s);
            }
            String[] stringArr = list.toArray(new String[0]);
            int count = Integer.parseInt(stringArr[0]);

            for (int i = 1; i <= count; i++) {
                String[] line = stringArr[i].split(" ");
                String listn = line[0];
                EmailList el = new EmailList(listn);

                for (int j = 2; j < line.length; j++) {
                    el.generateList(new EmailAddress(line[j]));
                }
                dl.addList(el);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}