
package src;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class EmailList 
{
        private String Listname;
        int temp=0;
        Scanner sc =new Scanner(System.in);
        private List<EmailAddress> emaillist;

        //*****************  initial constructor  ******************************************
        EmailList(String Listname)
        {
            this.Listname=Listname; 
            this.emaillist= new LinkedList<EmailAddress>();/* creating LinkedList of EmailAddress*/

        }
        //*****************  generateList  *********************************************
        public void generatelist(EmailAddress email)
        {
                emaillist.add(email);

        }
        //*****************  isEqual  **************************************************
        boolean isEqual(String Listname)
        {
            if(this.Listname.equals(Listname))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
          //*****************  display  **************************************************
          public void display()
             {
                  System.out.print(Listname+" : [");
                  for (EmailAddress emailaddr : emaillist)
                   {
                      if(temp == 0)
                        {
                          System.out.print(emailaddr.toString()); temp=10;
                        }
                       else
                        {
                          System.out.print(", " +emailaddr.toString());
                        }
                    }
                  System.out.print("]"+"\n");
                  temp=0;

             }
          //*****************  addNewEmail  **************************************************
          public EmailAddress addNewEmail()
          {    

               EmailAddress em=new EmailAddress();
               em.addEmail(sc,"y");
               generatelist(em);
               return em;
          }
          //*****************  deleteEmail  **************************************************
          public void deleteEmail()
          {

              for(int i=0;i<emaillist.size();i++)
              {
                  System.out.println(i+" "+emaillist.get(i));
              }
              System.out.println("Enter the entry no to delete:");
              int index=sc.nextInt();
              emaillist.remove(index);

          }

         //*****************   toString    ***************************************************
         @Override 
         public String toString()
         {
          return (Listname);
         }
}

