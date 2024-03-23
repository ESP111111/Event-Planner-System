package newpackage;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class main_test 
{
     
       
        
        
    public static void main(String[] args)
    {
         JOptionPane.showMessageDialog(null, "Start");       
        //Create Scanner Object
        Scanner scanner = new Scanner(System.in);
        
        while(true)//1st loop
        {
            System.out.println("{Welcome to Event Planner System}");
            System.out.println("Go to :\n(1) Login\n(2) Signup");
            int i_1st = scanner.nextInt();
            users user = new users();
            if(i_1st == 1)// Login   
            {
                while(true)//login loop
                {
                    System.out.println("{LOGIN}");
                    System.out.println("(1)Enter your credentials:");                 
                    System.out.println("(2)Go back to main page");                   
                    int i_2ed = scanner.nextInt();
                    if(i_2ed == 1)//enter your creds
                    {
                        while(true)
                        {
                            System.out.println("User Name:");
                            String user_name = scanner.next();
                            System.out.println("Password:");
                            String password = scanner.next();
                            int user_id = user.login(user_name, password);
                            if(user_id != -1)//Now login succeeded 
                            {
                                while(true)//In login welcome page
                                {
                                    String user_type = null;
                                    switch(user.get_type())
                                    {
                                        case 1:
                                        {
                                            user_type = "vendor";
                                            break;
                                        }
                                        case 2:
                                        {
                                            user_type = "organizer";
                                            break;
                                        }
                                        case 3:
                                        {
                                            user_type = "visitor";
                                            break;
                                        }
                                        default:
                                        {
                                            System.out.println("incorrect user type , contact us to solve your problem.");
                                            user =new users();//clear this user login data 
                                            break;//Logout
                                        }
                                    }
                                    System.out.println("Login succeeded , you are "+user_type);
                                    System.out.println("(1) Keep login and complete .\n(2) Logout");
                                    int i_4th = scanner.nextInt();
                                    if(i_4th == 1)//Complete login
                                    {
                                        while(true)//Login controller
                                        {
                                            System.out.println(user);
                                            System.out.println("Select your choise:");
                                            System.out.println("(1) Update your profile.\n(2) Next options.");                        
                                            int i_5th = scanner.nextInt();
                                            if(i_5th == 1)//showing and apdate my profile
                                            {
                                                while(true)
                                                {
                                                    System.out.println("Choose the option you want to modify:");
                                                    System.out.println("(1) update user name \n"
                                                            + "(2) update first name \n"
                                                            + "(3) update last name \n"
                                                            + "(4) update email \n"
                                                            + "(5) update password \n"
                                                            + "(6) update image url\n"
                                                            + "(7) go back");
                                                    int i_6th = scanner.nextInt();
                                                    switch(i_6th)
                                                    {
                                                        case 1:
                                                        {
                                                            System.out.println("Enter new user name :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_user_name(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                System.out.println("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 2:
                                                        {
                                                             System.out.println("Enter new first name :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_first_name(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                System.out.println("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 3:
                                                        {
                                                            System.out.println("Enter new last name :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_last_name(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                System.out.println("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 4:
                                                        {
                                                            System.out.println("Enter new email :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_email(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                System.out.println("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 5:
                                                        {
                                                            System.out.println("Enter new password :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_password(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                System.out.println("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 6:
                                                        {
                                                            System.out.println("Enter new image url :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_image(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                System.out.println("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                System.out.println("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 7:
                                                        {
                                                            break;
                                                        }
                                                        default:
                                                        {
                                                             System.out.println("Incorrect input , please try again.");
                                                        }
                                                    }
                                                    if(i_6th == 7)
                                                        {
                                                            break;
                                                        }
                                                }

                                            }
                                            else if(i_5th == 2)//Next options
                                            {
                                               if(user.get_type() == 1)       // vendor after login
                                               {
                                                   System.out.println("(1) Place controller\n(2) Go back");
                                                   int i_6th = scanner.nextInt();
                                                   if(i_6th == 1)
                                                   {
                                                       vendor(user);
                                                   }
                                                   else if(i_6th == 2)
                                                   {
                                                       break;
                                                   }
                                                   else
                                                   {
                                                       System.out.println("Incorrect input , please try again.");                                                   
                                                   }
                                               }
                                               else if(user.get_type() == 2) // organizer after login
                                               {
                                                   System.out.println("(1) Event controller\n(2) Go back");
                                                   int i_6th = scanner.nextInt();
                                                   if(i_6th == 1)
                                                   {
                                                       organizer(user);
                                                   }
                                                   else if(i_6th == 2)
                                                   {
                                                       break;
                                                   }  
                                                   else
                                                   {
                                                       System.out.println("Incorrect input , please try again.");                                                   
                                                   }
                                               }
                                               else                          //visitor
                                               {
                                                  System.out.println("(1) Show your Invitations \n(2) Go back");
                                                   int i_6th = scanner.nextInt();
                                                   if(i_6th == 1)
                                                   {
                                                       visitor(user);
                                                   }
                                                   else if(i_6th == 2)
                                                   {
                                                       break;
                                                   }
                                                   else
                                                   {
                                                       System.out.println("Incorrect input , please try again.");                                                   
                                                   }
                                               }
                                            }
                                            else//incorrect input
                                            {
                                                System.out.println("Incorrect input , please try again.");
                                            }
                                        }
                                    }
                                    else if(i_4th == 2)// Logout
                                    {
                                        user = new users();
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("Incorrect input , please try again.");
                                    }
                                }
                            }
                            else//incorrect creds
                            {
                                System.out.println("(1)Retry again.");
                                System.out.println("(2)Go back.");
                                int i_3ed = scanner.nextInt();
                                if(i_3ed == 1)
                                {
                                    System.out.println("Try again.");
                                }
                                else if(i_3ed == 2)
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("Incorrect input , please try again.");
                                }
                            }
                            break;
                        }
                    }
                    else if(i_2ed == 2)//Go back
                    {
                       break;
                    }
                    else// incorrect input
                    {
                        System.out.println("Incorrect input , please try again.");
                    }                        
                }
            }
            else if(i_1st == 2)// Signup
            {
                while(true)
                {
                     System.out.println("Welcome new user(:");
                     System.out.println("Enter your information:");
                     System.out.println("1-User name:");
                     String user_name = scanner.next();
                     System.out.println("2-First name:");
                     String first_name = scanner.next();
                     System.out.println("3-Last name:");
                     String last_name = scanner.next();
                     System.out.println("4-Email:");
                     String email = scanner.next();
                     System.out.println("5-password:");
                     String password = scanner.next();
                     System.out.println("6-Image url:");
                     String image = scanner.next();
                     System.out.println("7-User type:\n(1) vendor\n(2) organizer\n(3) visitor");
                     int user_type = scanner.nextInt();
                     if(user_type<1 || user_type>3)
                     {
                         System.out.println("Incorrect type.");
                         break;
                     }
                     else
                     {
                     users U = new users();
                     U.sign_up(user_name, first_name, last_name, email, password, image, user_type);
                     System.out.println("Account successfully created");
                     break;
                     }
                }
            }
            else// incorrect input
            {
                System.out.println("Incorrect input , please try again.");
            }
        }        
    } 
    public static void vendor(users user)
    {

        places P = new places();
         while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("(0) Go back");
            System.out.println("(1) Add new place");                       
            System.out.println("(2) Open place control panel");
            int i_1st = scanner.nextInt();
            if(i_1st == 0)
            {
                break;
            }
            else if(i_1st == 1) // add new place
            {
                int vendor_id = user.user_id;
                System.out.println("1 Enter place name :");
                String name = scanner.next();
                 System.out.println("2 Enter place location :");
                String location = scanner.next();
                System.out.println("3 Enter place capacity :");
                int capacity = scanner.nextInt();
                System.out.println("4 Enter price per hour :");
                float price = scanner.nextFloat();
                System.out.println("5 Enter place rate :");
                int rate = scanner.nextInt();
                
                P.insert_new_place(vendor_id, name, location, capacity, price, rate);
                
                
                System.out.println("Added successfuly");
                System.out.println("------------------------");
                
            }
            else if(i_1st == 2) // plcae control
            {
                while(true)
                {
                    System.out.println("This is your places : \nEnter place id to control it");
                    P.print_all_places(user.user_id);
                    int place_id = scanner.nextInt();
                    
                    while(true)
                    {
                        
                        System.out.println("-------------------");
                        System.out.println("(0) Go back");
                        System.out.println("(1) Show events order for this place");
                        System.out.println("(2) Update place");
                        System.out.println("(3) delete place");
                        System.out.println("-------------------");
                        int i_2ed = scanner.nextInt();
                        if(i_2ed == 0)
                        {
                            break;
                        }
                        else if(i_2ed == 1)
                        {
                            P.print_one_place(place_id);
                        }
                        
                    }
                    break;
                            
                }
            }
        }
    }
    public static void organizer(users user)
    {
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("(0) Go back");
            System.out.println("(1) Add new event");                       
            System.out.println("(2) Open event control panel");
            int i_1st = scanner.nextInt();
            
            if(i_1st == 0)
            {
                break;
            }
            else if(i_1st == 1) // add new event
            {
                Events Es =new Events();
                Event E = new Event();
                
                E.organizer_id = user.user_id;
                
                System.out.println("1 Enter category id in this category list :");
                Es.print_categories();
                E.event_category_id = scanner.nextInt();                
                
                System.out.println("2 Enter event name :");
                E.name = scanner.next();
                
                System.out.println("3 Enter event date :");
                E.event_date = scanner.next();
                
                System.out.println("4 Enter event time :");
                E.event_time = scanner.next();
                
                System.out.println("5 Enter event description :");
                E.description = scanner.next();
                
                System.out.println("6 Enter number of invitees :");
                E.no_vesitors = scanner.nextInt();
                
                System.out.println("7 Enter price per visitor :");
                E.price_per_visitor = scanner.nextFloat();
                
                System.out.println("8 Enter number of meals :");
                E.no_meals = scanner.nextInt();
                
                System.out.println("9 Enter price per meal :");
                E.meal_price = scanner.nextFloat();
                
                System.out.println("10 Enter number of drinks :");
                E.no_drinks = scanner.nextInt();
                
                System.out.println("11 Enter price per drink :");
                E.drink_price = scanner.nextFloat();
                
                Es.insert_new_event(E);
                
                System.out.println("Added successfuly");
                System.out.println("------------------------");
            }
            else if(i_1st == 2 ) // control panel
            {
                while(true)
                {
                    System.out.println("(0) Go back");
                    System.out.println("{Your events page}");               
                    System.out.println("Enter your event number to control it:");
                    Events Es = new Events();
                    Es.print_org_events(user.user_id);
                    int i_2ed = scanner.nextInt();
                    if(i_2ed == 0)
                    {
                        break;
                    }
                    else             
                    {
                        while(true)
                        {
                            System.out.println("-----------------------");
                            System.out.println("Full event information:");               
                            Es.get_one_event(i_2ed);
                            System.out.println("-----------------------");
                            System.out.println("(0) Go back");
                            System.out.println("(1) Enter to meta(images & videos)");
                            System.out.println("(2) Enter to Invitations");
                            System.out.println("(3) Update event information");
                            System.out.println("(4) Delete this event");
                            System.out.println("(5) Enter places controler"); 
                            System.out.println("(6) Search with places ");
                            System.out.println("(7) Show event finance report");
                            System.out.println("(8) Show enhancment finance report");
                            System.out.println("-----------------------");
                            int i_3ed = scanner.nextInt();
                            if(i_3ed == 0) // go back
                            {
                                break;
                            }
                            else if(i_3ed == 1) // meta data
                            {
                                while(true)
                                {
                                    System.out.println("-----------------------");
                                    System.out.println("Meta data for this event:");
                                    Es.get_event_meta(i_2ed);
                                    System.out.println("(0) Go back");
                                    System.out.println("(1) Add new link");
                                    int i_4th = scanner.nextInt();
                                    if(i_4th == 0)
                                    {
                                        break;
                                    }
                                    else if(i_4th == 1)
                                    {
                                        System.out.println("{Add new link}");                                        
                                        System.out.println("Enter meta link");
                                        String meta_link = scanner.next();
                                        
                                        System.out.println("Choose type number ");
                                        System.out.println("(1) Image");                
                                        System.out.println("(2) Video");
                                        int type = scanner.nextInt();
                                        if(type == 1 || type == 2)
                                        {
                                            Es.add_meta(i_2ed, meta_link, type);
                                        }
                                        else
                                        {
                                            System.out.println("Incorrect input , please try again.");
                                        }
                                    }
                                }
                            }
                             else if(i_3ed == 2) // Invitations
                            {
                                while(true)
                                {
                                    System.out.println("-----------------------");
                                    System.out.println("Invitations for this event:");
                                    Es.get_Invitations(i_2ed);
                                    System.out.println("(0) Go back");
                                    System.out.println("(1) Invite new user ");
                                    int i_4th = scanner.nextInt();
                                    if(i_4th == 0)
                                    {
                                        break;
                                    }
                                    else if(i_4th == 1)
                                    {
                                        System.out.println("{Invite new user}"); 
                                        System.out.println("Enter user id ");
                                        int visitor_id = scanner.nextInt();
                                        System.out.println("Enter  Invitations number for this user ");
                                        int no_invites = scanner.nextInt();
                                        
                                        System.out.println("Is this a VIP invitation?");
                                        System.out.println("(0) No");                
                                        System.out.println("(1) Yes");
                                        int type = scanner.nextInt();
                                        if(type == 0 || type == 1)
                                        {
                                            Es.add_Invitation(i_2ed,visitor_id , no_invites ,type);
                                        }
                                        else
                                        {
                                            System.out.println("Incorrect input , please try again.");
                                        }
                                    }
                                }
                            }
                            else if(i_3ed == 3) // update
                            {
                               
                            }
                            else if(i_3ed == 4) // Delete event
                            {
                                System.out.println("Are you sure you want to delete it? If yes, enter the number 1. Otherwise, enter 0: ");
                                
                                int ch = scanner.nextInt();
                                if(ch == 1)
                                {
                                    Es.delete_event(i_2ed);
                                     break;
                                }
                               
                            }
                            else if(i_3ed == 5) // choise event place
                            {
                                System.out.println("Enter place ID :");
                                int place_id = scanner.nextInt();
                                 System.out.println("Enter start date :");
                                String start_date = scanner.next();
                                System.out.println("Enter end date :");
                                String end_date = scanner.next();
                                System.out.println("Enter start time :");
                                String start_time = scanner.next();
                                System.out.println("Enter end date :");
                                String end_time = scanner.next();

                                Es.order_to_place(place_id, i_2ed , start_date ,end_date ,start_time ,end_time );
                                System.out.println("Order successfuly");
                            }
                             else if (i_3ed == 6)
                             {
                                 while(true)
                                 {
                                     System.out.println("(0) Go back");
                                     System.out.println("(1) Search by name");                       
                                     System.out.println("(2) Search by location");
                                     System.out.println("(3) Search by price");
                                     System.out.println("(4) Search by period Time");
                                     int oy4 = scanner.nextInt();
                                     if(oy4 == 0)
                                     {
                                         break;
                                     }
                                     else if(oy4==1)
                                     {
                                         places od = new places()  ;
                                         od.srch_byname();
                                         System.out.print("\n");
                                     }
                                     else if (oy4==2)
                                     {
                                         places om=new places() ;
                                         om.srch_bylocation();
                                         System.out.print("\n");
                                     }
                                     else if(oy4==3)
                                     {
                                         places os =new places() ;
                                         os.srch_byprice();
                                         System.out.print("\n");
                                     }
                                     else if(oy4==4)
                                     {
                                         places ov =new places() ;
                                         ov.srch_byperiod();
                                         System.out.print("\n");
                                     }
                                 }
                             }
                             else if (i_3ed == 7)
                             {
                                 finance f = new finance();
                                 f.event_report(i_2ed);
                                 System.out.println("(0) Go Back");
                                 int i_4ed = scanner.nextInt();
                                 if(i_4ed == 0)
                                 {
                                     break;
                                 }
                             }
                             else if(i_3ed == 8)
                             {
                                finance f = new finance();
                                 f.enhancment_report(i_2ed);
                                 System.out.println("(0) Go Back");
                                 int i_4ed = scanner.nextInt();
                                 if(i_4ed == 0)
                                 {
                                     break;
                                 }
                             }
                        }
   
                    }
                } 
            }
            else
            {
                System.out.println("Incorrect input , please try again.");
            }
        }
    } 
    public static void visitor(users user)
    { 
        while (true) 
        {   Scanner scanner = new Scanner(System.in);
            Visitor V = new Visitor();
            V.my_invitations(user.user_id);
            System.err.println("(0) Go Back");
            int i_1st = scanner.nextInt();
            if(i_1st == 0)
            {
                break;
            }
            else
            {      
               System.out.println("Incorrect input , please try again.");
            }
        }    
    }
}
