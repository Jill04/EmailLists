
package src;

import java.util.ArrayList;

public class Directory 
{
          ArrayList<EmailList> arraylist= new ArrayList<EmailList>();
          //*****************  AddList  *********************************************
          public void addList(EmailList emaillist)
          { 
              
              arraylist.add(emaillist);
          }
          //*****************  findList  *********************************************
          public EmailList findList(String Listname)
          { 
                
               for(EmailList emaillist2:arraylist)  
               {
                 if(emaillist2.isEqual(Listname))
                {
                     /*if(request == 1)
                     {
                        emaillist2.addNewEmail();
                       
                     }
                     else if(request == 2)
                     {
                         emaillist2.deleteEmail();
                        
                     }
                     else if(request == 3)
                     {
                         emaillist2.display();
                         
                     }
                   */
                    
                    return emaillist2;
                     
                }
               }
               
              return null;
              
          }
          //*****************  displayAllList  *********************************************
          public void displayAllList()
            {
              for (EmailList emaillist : arraylist)
              {
                  emaillist.display();
              }
            }
        
}
    
   
   
    

