package newpackage;

import java.util.Scanner;

public class main_test 
{
    public static void main(String[] args)
    {
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
}