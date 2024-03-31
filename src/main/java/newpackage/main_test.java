package newpackage;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class main_test 
{
     private static final Logger logger = Logger.getLogger(main_test.class.getName());
    public static void main(String[] args)
    {
       ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());

        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        
        JOptionPane.showMessageDialog(null, "Start");       
        Scanner scanner = new Scanner(System.in);
        
        while(true)//1st loop
        {
            logger.info("{Welcome to Event Planner System}");
            logger.info("Go to :\n(1) Login\n(2) Signup\n(3) Exit");
            int i_1st = scanner.nextInt();
            users user = new users();
            if(i_1st == 3)
            {
                break;
            }
            if(i_1st == 1)// Login   
            {
                while(true)//login loop
                {
                    logger.info("{LOGIN}");
                    logger.info("(1)Enter your credentials:");                 
                    logger.info("(2)Go back to main page");                   
                    int i_2ed = scanner.nextInt();
                    if(i_2ed == 1)//enter your creds
                    {
                        while(true)
                        {
                            logger.info("User Name:");
                            String user_name = scanner.next();
                            logger.info("Password:");
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
                                            logger.info("incorrect user type , contact us to solve your problem.");
                                            user =new users();//clear this user login data 
                                            break;//Logout
                                        }
                                    }
                                    logger.info("Login succeeded , you are "+user_type);
                                    logger.info("(1) Keep login and complete .\n(2) Logout");
                                    int i_4th = scanner.nextInt();
                                    if(i_4th == 1)//Complete login
                                    {
                                        while(true)//Login controller
                                        {
                                            System.out.println(user);
                                            logger.info("Select your choise:");
                                            logger.info("(0) Go Back \n(1) Update your profile.\n(2) Next options.");                        
                                            int i_5th = scanner.nextInt();
                                            if(i_5th == 0)
                                            {
                                                break;
                                            }
                                            else if(i_5th == 1)//showing and apdate my profile
                                            {
                                                while(true)
                                                {
                                                    logger.info("Choose the option you want to modify:");
                                                    logger.info("(1) update user name \n"
                                                            + "(2) update first name \n"
                                                            + "(3) update last name \n"
                                                            + "(4) update email \n"
                                                            + "(5) update password \n"
                                                            + "(6) update image url\n"
                                                            + "(7) go back");
                                                    int i_6th = scanner.nextInt();
                                                     if(i_6th == 7)
                                                        {
                                                            break;
                                                        }
                                                     else {
                                                    switch(i_6th)
                                                    {
                                                        case 1:
                                                        {
                                                            logger.info("Enter new user name :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_user_name(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                logger.info("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                logger.info("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 2:
                                                        {
                                                             logger.info("Enter new first name :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_first_name(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                logger.info("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                logger.info("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 3:
                                                        {
                                                            logger.info("Enter new last name :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_last_name(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                logger.info("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                logger.info("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 4:
                                                        {
                                                            logger.info("Enter new email :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_email(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                logger.info("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                logger.info("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 5:
                                                        {
                                                            logger.info("Enter new password :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_password(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                logger.info("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                logger.info("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        case 6:
                                                        {
                                                            logger.info("Enter new image url :");
                                                            String new_user_name = scanner.next();
                                                            int R = user.set_image(user, new_user_name);
                                                            if(R != 1)
                                                            {
                                                                logger.info("This value not updated !");
                                                            }
                                                            else
                                                            {
                                                                logger.info("Updated successfuly");
                                                            }
                                                            break;
                                                        }
                                                        
                                                        default:
                                                        {
                                                             logger.info("Incorrect input , please try again.");
                                                        }
                                                    }
                                                    
                                                }
                                                        }
                                            }
                                            else if(i_5th == 2)//Next options
                                            {
                                               if(user.get_type() == 1)       // vendor after login
                                               {
                                                   logger.info("(1) Place controller\n(2) Go back");
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
                                                       logger.info("Incorrect input , please try again.");                                                   
                                                   }
                                               }
                                               else if(user.get_type() == 2) // organizer after login
                                               {
                                                   logger.info("(1) Event controller\n(2) Go back");
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
                                                       logger.info("Incorrect input , please try again.");                                                   
                                                   }
                                               }
                                               else                          //visitor
                                               {
                                                  logger.info("(1) Show your Invitations \n(2) Go back");
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
                                                       logger.info("Incorrect input , please try again.");                                                   
                                                   }
                                               }
                                            }
                                            else//incorrect input
                                            {
                                                logger.info("Incorrect input , please try again.");
                                            }
                                            break;
                                        }
                                    }
                                    else if(i_4th == 2)// Logout
                                    {
                                        user.logout(user.get_id());
                                        user = new users();
                                        break;
                                    }
                                    else
                                    {
                                        logger.info("Incorrect input , please try again.");
                                    }
                                }
                            }
                            else//incorrect creds
                            {
                                logger.info("(1)Retry again.");
                                logger.info("(2)Go back.");
                                int i_3ed = scanner.nextInt();
                                if(i_3ed == 1)
                                {
                                    logger.info("Try again.");
                                }
                                else if(i_3ed == 2)
                                {
                                    break;
                                }
                                else
                                {
                                    logger.info("Incorrect input , please try again.");
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
                        logger.info("Incorrect input , please try again.");
                    }                        
                }
            }
            else if(i_1st == 2)// Signup
            {
                while(true)
                {
                     logger.info("Welcome new user(:");
                     logger.info("Enter your information:");
                     logger.info("1-User name:");
                     String user_name = scanner.next();
                     logger.info("2-First name:");
                     String first_name = scanner.next();
                     logger.info("3-Last name:");
                     String last_name = scanner.next();
                     logger.info("4-Email:");
                     String email = scanner.next();
                     logger.info("5-password:");
                     String password = scanner.next();
                     logger.info("6-Image url:");
                     String image = scanner.next();
                     logger.info("7-User type:\n(1) vendor\n(2) organizer\n(3) visitor");
                     int user_type = scanner.nextInt();
                     if(user_type<1 || user_type>3)
                     {
                         logger.info("Incorrect type.");
                         break;
                     }
                     else
                     {
                     users U = new users();
                     U.sign_up(user_name, first_name, last_name, email, password, image, user_type);
                     logger.info("Account successfully created");
                     break;
                     }
                }
            }
            else// incorrect input
            {
                logger.info("Incorrect input , please try again.");
            }
        }        
    } 
    public static void vendor(users user)
    {

        places P = new places();
         while(true)
        {
            Scanner scanner = new Scanner(System.in);
            logger.info("(0) Go back");
            logger.info("(1) Add new place");                       
            logger.info("(2) Open place control panel");
            int i_1st = scanner.nextInt();
            if(i_1st == 0)
            {
                break;
            }
            else if(i_1st == 1) // add new place
            {
                int vendor_id = user.user_id;
                logger.info("1 Enter place name :");
                String name = scanner.next();
                 logger.info("2 Enter place location :");
                String location = scanner.next();
                logger.info("3 Enter place capacity :");
                int capacity = scanner.nextInt();
                logger.info("4 Enter price per hour :");
                float price = scanner.nextFloat();
                logger.info("5 Enter place rate :");
                int rate = scanner.nextInt();
                
                P.insert_new_place(vendor_id, name, location, capacity, price, rate);
                
                
                logger.info("Added successfuly");
                logger.info("------------------------");
                
            }
            else if(i_1st == 2) // plcae control
            {
                while(true)
                {
                    logger.info("This is your places : \nEnter place id to control it");
                    P.print_all_places(user.user_id);
                    int place_id = scanner.nextInt();
                    
                    while(true)
                    {
                        
                        logger.info("-------------------");
                        logger.info("(0) Go back");
                        logger.info("(1) Show events order for this place");
                        logger.info("(2) Update place");
                        logger.info("(3) delete place");
                        logger.info("-------------------");
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
            logger.info("(0) Go back");
            logger.info("(1) Add new event");                       
            logger.info("(2) Open event control panel");
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
                
                logger.info("1 Enter category id in this category list :");
                Es.print_categories();
                E.event_category_id = scanner.nextInt();                
                
                logger.info("2 Enter event name :");
                E.name = scanner.next();
                
                logger.info("3 Enter event date :");
                E.event_date = scanner.next();
                
                logger.info("4 Enter event time :");
                E.event_time = scanner.next();
                
                logger.info("5 Enter event description :");
                E.description = scanner.next();
                
                logger.info("6 Enter number of invitees :");
                E.no_vesitors = scanner.nextInt();
                
                logger.info("7 Enter price per visitor :");
                E.price_per_visitor = scanner.nextFloat();
                
                logger.info("8 Enter number of meals :");
                E.no_meals = scanner.nextInt();
                
                logger.info("9 Enter price per meal :");
                E.meal_price = scanner.nextFloat();
                
                logger.info("10 Enter number of drinks :");
                E.no_drinks = scanner.nextInt();
                
                logger.info("11 Enter price per drink :");
                E.drink_price = scanner.nextFloat();
                
                Es.insert_new_event(E);
                
                logger.info("Added successfuly");
                logger.info("------------------------");
            }
            else if(i_1st == 2 ) // control panel
            {
                while(true)
                {
                    logger.info("(0) Go back");
                    logger.info("{Your events page}");               
                    logger.info("Enter your event number to control it:");
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
                            logger.info("-----------------------");
                            logger.info("Full event information:");               
                            Es.get_one_event(i_2ed);
                            logger.info("-----------------------");
                            logger.info("(0) Go back");
                            logger.info("(1) Enter to meta(images & videos)");
                            logger.info("(2) Enter to Invitations");
                            logger.info("(3) Update event information");
                            logger.info("(4) Delete this event");
                            logger.info("(5) Enter places controler"); 
                            logger.info("(6) Search with places ");
                            logger.info("(7) Show event finance report");
                            logger.info("(8) Show enhancment finance report");
                            logger.info("-----------------------");
                            int i_3ed = scanner.nextInt();
                            if(i_3ed == 0) // go back
                            {
                                break;
                            }
                            else if(i_3ed == 1) // meta data
                            {
                                while(true)
                                {
                                    logger.info("-----------------------");
                                    logger.info("Meta data for this event:");
                                    Es.get_event_meta(i_2ed);
                                    logger.info("(0) Go back");
                                    logger.info("(1) Add new link");
                                    int i_4th = scanner.nextInt();
                                    if(i_4th == 0)
                                    {
                                        break;
                                    }
                                    else if(i_4th == 1)
                                    {
                                        logger.info("{Add new link}");                                        
                                        logger.info("Enter meta link");
                                        String meta_link = scanner.next();
                                        
                                        logger.info("Choose type number ");
                                        logger.info("(1) Image");                
                                        logger.info("(2) Video");
                                        int type = scanner.nextInt();
                                        if(type == 1 || type == 2)
                                        {
                                            Es.add_meta(i_2ed, meta_link, type);
                                        }
                                        else
                                        {
                                            logger.info("Incorrect input , please try again.");
                                        }
                                    }
                                }
                            }
                             else if(i_3ed == 2) // Invitations
                            {
                                while(true)
                                {
                                    logger.info("-----------------------");
                                    logger.info("Invitations for this event:");
                                    Es.get_Invitations(i_2ed);
                                    logger.info("(0) Go back");
                                    logger.info("(1) Invite new user ");
                                    int i_4th = scanner.nextInt();
                                    if(i_4th == 0)
                                    {
                                        break;
                                    }
                                    else if(i_4th == 1)
                                    {
                                        logger.info("{Invite new user}"); 
                                        logger.info("Enter user id ");
                                        int visitor_id = scanner.nextInt();
                                        logger.info("Enter  Invitations number for this user ");
                                        int no_invites = scanner.nextInt();
                                        
                                        logger.info("Is this a VIP invitation?");
                                        logger.info("(0) No");                
                                        logger.info("(1) Yes");
                                        int type = scanner.nextInt();
                                        if(type == 0 || type == 1)
                                        {
                                            Es.add_Invitation(i_2ed,visitor_id , no_invites ,type);
                                        }
                                        else
                                        {
                                            logger.info("Incorrect input , please try again.");
                                        }
                                    }
                                }
                            }
                            else if(i_3ed == 3) // update
                            {
                               
                            }
                            else if(i_3ed == 4) // Delete event
                            {
                                logger.info("Are you sure you want to delete it? If yes, enter the number 1. Otherwise, enter 0: ");
                                
                                int ch = scanner.nextInt();
                                if(ch == 1)
                                {
                                    Es.delete_event(i_2ed);
                                     break;
                                }
                               
                            }
                            else if(i_3ed == 5) // choise event place
                            {
                                logger.info("Enter place ID :");
                                int place_id = scanner.nextInt();
                                 logger.info("Enter start date :");
                                String start_date = scanner.next();
                                logger.info("Enter end date :");
                                String end_date = scanner.next();
                                logger.info("Enter start time :");
                                String start_time = scanner.next();
                                logger.info("Enter end time :");
                                String end_time = scanner.next();

                                Es.order_to_place(place_id, i_2ed , start_date ,end_date ,start_time ,end_time );
                                logger.info("Order successfuly");
                            }
                             else if (i_3ed == 6)
                             {
                                 while(true)
                                 {
                                     logger.info("(0) Go back");
                                     logger.info("(1) Search by name");                       
                                     logger.info("(2) Search by location");
                                     logger.info("(3) Search by price");
                                     logger.info("(4) Search by period Time");
                                     int oy4 = scanner.nextInt();
                                     if(oy4 == 0)
                                     {
                                         break;
                                     }
                                     else if(oy4==1)
                                     {
                                         places od = new places()  ;
                                         logger.info("Enter the name of the place to search: ");
                                         String name = scanner.next();
                                         od.srch_byname(name);
                                         System.out.print("\n");
                                     }
                                     else if (oy4==2)
                                     {
                                         places om=new places() ;
                                         logger.info("Enter the location of the place to search: ");
                                         String location = scanner.next();
                                         om.srch_bylocation(location);
                                         System.out.print("\n");
                                     }
                                     else if(oy4==3)
                                     {
                                         places os =new places() ;
                                         logger.info("Enter the maximum hourly price of the place to search: ");
                                         float price = scanner.nextFloat();
                                         os.srch_byprice(price);
                                         System.out.print("\n");
                                     }
                                     else if(oy4==4)
                                     {
                                         places ov =new places() ;
                                         logger.info("Enter start date (YYYY-MM-DD): ");
                                         String startDate = scanner.next();
                                         logger.info("Enter start time (HH:MM:SS): ");
                                         String startTime = scanner.next();
                                         logger.info("Enter end time (HH:MM:SS): ");
                                         String endTime = scanner.next();
                                         ov.srch_byperiod(startDate, startTime, endTime);
                                         System.out.print("\n");
                                     }
                                 }
                             }
                             else if (i_3ed == 7)
                             {
                                 finance f = new finance();
                                 f.event_report(i_2ed);
                                 logger.info("(0) Go Back");
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
                                 logger.info("(0) Go Back");
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
                logger.info("Incorrect input , please try again.");
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
               logger.info("Incorrect input , please try again.");
            }
        }    
    }
}
