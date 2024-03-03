package newpackage;
public class main_test 
{
    public static void main(String[] args)
    {
        //static test
        users user = new users();
        user.login("visitor", "ahmad12345");
        System.out.println(user); //show profile info

        
//        int vendor = user.sign_up("vendor", "Ahmad", "mohammad", "Ahmad@gmail.com", "ahmad12345", "Ah", 1);
//        users user1 = new users();        
//        int organizer =user1.sign_up("organizer", "Ahmad", "mohammad", "Ahmad@gmail.com", "ahmad12345", "Ah", 2);
//        users user2 = new users();
//        int visitor = user2.sign_up("visitor", "Ahmad", "mohammad", "Ahmad@gmail.com", "ahmad12345", "Ah", 3);
//        System.out.println(vendor);
//        System.out.println(organizer);
//        System.out.println(visitor);
        
    }
    
}
