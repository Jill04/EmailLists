import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class EmailTest {
    private EmailList emailList;
    private EmailAddress emailAddress1;
    private EmailAddress emailAddress2;

    @Before
    public void setUp() {
        emailList = new EmailList("TestList");
        emailAddress1 = new EmailAddress("test1@example.com");
        emailAddress2 = new EmailAddress("test2@example.com");
    }

    @Test
    public void testAddEmailToList() {
        emailList.generateList(emailAddress1);
        assertEquals(1, emailList.getEmailList().size());
        assertTrue(emailList.getEmailList().contains(emailAddress1));
    }

    @Test
    public void testDeleteEmailFromList() {
        emailList.generateList(emailAddress1);
        emailList.generateList(emailAddress2);
        
        emailList.deleteEmail(0);
        assertEquals(1, emailList.getEmailList().size());
        assertFalse(emailList.getEmailList().contains(emailAddress1));
    }

    @Test
    public void testFindListByName() {
        Directory directory = new Directory();
        directory.addList(emailList);
        
        EmailList foundList = directory.findList("TestList");
        assertNotNull(foundList);
        assertEquals(emailList, foundList);
    }

    @Test
    public void testAddEmailFromUserInput() throws IOException {
        String input = "test@example.com\nn\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        EmailList emailList = new EmailList("TestList");
        emailList.addNewEmail();

        assertEquals(1, emailList.getEmailList().size());
        assertTrue(emailList.getEmailList().contains(new EmailAddress("test@example.com")));
    }

    @Test
    public void testInvalidEmailInputFromUser() throws IOException {
        String input = "invalid-email\ny\ntest@example.com\nn\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        EmailList emailList = new EmailList("TestList");
        emailList.addNewEmail();

        assertEquals(1, emailList.getEmailList().size());
        assertTrue(emailList.getEmailList().contains(new EmailAddress("test@example.com")));
    }

    @Test
    public void testLoadListsFromFile() {
        String testData = "3\nList1 test1@example.com\nList2 test2@example.com\nList3 test3@example.com";

        try {
            FileUtil.createFile("test_lists.txt", testData);
            Directory directory = new Directory();
            directory.loadListsFromFile("test_lists.txt");

            assertEquals(3, directory.getArrayList().size());
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

      @Test
    public void testDisplayList() {
        emailList.generateList(emailAddress1);
        emailList.generateList(emailAddress2);
        emailList.generateList(emailAddress3);

        String expectedOutput = "TestList : [test1@example.com, test2@example.com, test3@example.com]";
        assertEquals(expectedOutput, emailList.display());
    }

    @Test
    public void testDeleteNonexistentEmailFromList() {
        emailList.generateList(emailAddress1);
        emailList.generateList(emailAddress2);

        emailList.deleteEmail(2); // Attempt to delete an email that does not exist in the list
        assertEquals(2, emailList.getEmailList().size());
    }

}
