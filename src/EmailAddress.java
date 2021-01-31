
package src;

import java.util.Scanner;


public class EmailAddress
{
        String email;
        //*****************  default constructor  ******************************************
        EmailAddress()
        {

        }
        //*****************  initial constructor  ******************************************
        EmailAddress(String email)
        {
            if(email.contains("@") &&  email.contains(".") && email.length()>= 7) 
            {
               this.email=email;
            }
            else
            {
                System.out.println("stop");
            }

        } 
        //*****************  addEmail    **************************************************
        public String addEmail(Scanner sc,String ans)
           {

                if(ans.equals("y"))
                {
                    System.out.println("Enter valid Email");
                    email=sc.next();
                    while(!email.contains("@") ||  !email.contains(".") || email.length()<7)
                     {
                           System.out.print ("Enter valid email address...must contain @ and .:");
                           email = sc.next();
                     }

                 }

                return email;
           }
        //*****************   toString    **************************************************
        @Override
            public String toString()
            {
               return email ;
            }

}
