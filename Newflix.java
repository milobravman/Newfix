import java.util.Scanner;
import java.io.*;

public class Newflix {
    
    static public CustomerBST all = new CustomerBST();
    //static public 

    // public Customer search(int creditcardNum){
    //     Customer temp = all.search(creditcardNum);
    //     return temp;
    // }


    public static void main(String[] args) {

        //Customer object = new Customer(1, "geeksforgeeks");

             // Deserialization
        try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);
              
            // Method for deserialization of object
            all = (CustomerBST)in.readObject();
            
            in.close();
            file.close();
              
            System.out.println("Object has been deserialized ");
        }
          
        catch(IOException ex)
        {
            System.out.println(ex);
            System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        // Customer bob = new Customer("bob", "bob@yahoo.com", 112344);
        // Customer steve = new Customer("steve", "steve@yahoo.com", 2434509);
        // Customer sarah = new Customer("sarah", "sarah@gmail.com", 2345567);
        // // System.out.println(bob.getName());
        // // Movie first = new Movie("mName", 00123, 20160712, 99, true);
        // // bob.addToWish(first);
        // // bob.upNest();
        // // //bob.upNest();
        // all.insert(bob);
        // all.insert(steve);
        // all.insert(sarah);
        // System.out.println(bob.getCreditNum());


        boolean running = true;

        System.out.println("Welcome to Newflix");
        System.out.println("As an admin you have accsess to all commands");
        System.out.println("Type 'h' for the list of all commands");
        Scanner user = new Scanner(System.in);

        while(running){
            try {
                String in = user.nextLine();
                if (in.equals("h")){
                    System.out.println("----------COMMANDS------------");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Enter 'q' to QUIT");
                    System.out.println("Enter '1' to Create a new Customer Account");
                    System.out.println("Enter '2' to Add a new Movie Account");
                    System.out.println("Enter '3' to See Customer commands");
                    System.out.println("Enter '4' to See Movie commands");
                }
                else if (in.equals("q")){
                    running = false;
                    System.out.println("Thank you for watching until next time");
                    String filename = "file.ser";
        
                    // Serialization 
                    try
                    {   
                        //Saving of object in a file
                        FileOutputStream file = new FileOutputStream(filename);
                        ObjectOutputStream out = new ObjectOutputStream(file);
                            
                        // Method for serialization of object
                        out.writeObject(all);
                            
                        out.close();
                        file.close();
                            
                        System.out.println("Object has been serialized");
                
                    }
                        
                    catch(IOException ex)
                    {
                        System.out.println("IOException is caught");
                    }
                }
                else if (in.equals("1")){
                    //createCustomer();

                    boolean creatingCustomer = true;

                    String name;
                    String email;
                    int creditcardNum;

                    while (creatingCustomer){
                        System.out.print("Please enter a username: ");
                        name = user.nextLine();
                        System.out.print("Please enter your email: ");
                        email = user.nextLine();
                        System.out.print("Please enter your credit card number: ");
                        creditcardNum = user.nextInt();
    
                        try {
                            Customer temp = new Customer(name, email, creditcardNum);
                            all.insert(temp);
                            creatingCustomer = false;
                        } catch (Exception e) {
                            System.out.println("You entered an invalid variable please try again and enter information carfully");
                        }
                    }
                    in = user.nextLine(); // very hacky way of preventing a new line charter from makeing the else in the orginal while loop occur unexpectedly
                }
                else if (in.equals("2")){
                    //createMovie();
                }
                else if (in.equals("3")){
                    boolean customersPage = true;
                    System.out.println("To see all current Customers enter 'a'");
                    System.out.println("To search for a Customers enter 's'");
                    System.out.println("To return to the main menu enter 'b'");
                    //in = user.nextLine();
                    
                    while (customersPage){
                        in = user.nextLine();
                        if (in.equals("a")){
                            all.printTree();
                        }else if (in.equals("s")){
                            System.out.println("What customer would you like to accsess remember you enter the credit number of the customer you are looking for");
                            int key = user.nextInt();
                            // searchCustomers();
                            Customer temp = all.search(key);

                            if (temp != null){
                                System.out.println("This is "+ temp.getName() +"'s page");
                                System.out.println(temp.getName() +"'s email is "+ temp.getEmail());
                                System.out.println(temp.getName() +" has a wish list with "+ temp.WishlistLength()+"Movies in it");

                                System.out.println("Enter 1 to watch the next movie on the "+ temp.getName()+"'s wishlist");



                            }else{
                                System.out.println("seems like credid card number does not match any user");
                                System.out.println("Please use the 'a' command to see the credit card numbers");
                            }
                            in = user.nextLine(); // very hacky way of preventing a new line charter from makeing the else in the orginal while loop occur unexpectedly

                        }else if (in.equals("b")){
                            // user2.close();
                            //continue;
                            customersPage = false;
                            System.out.println("Returning to main menu");
                            System.out.println("Remeber enter 'h' to see commands");
                        }else {
                            System.out.println("Seems like you entered an invalid command");
                            System.out.println("To see all current Customers enter 'a'");
                            System.out.println("To search for a Customers enter 's'");
                            System.out.println("To return to the main menu enter 'b'");
                        }
                    }
                }
                else if (in.equals("3")){

                    // Movie options

                }
                else{
                    System.out.println("Seems like you entered an invalid command");
                    System.out.println("");
                    System.out.println("----------COMMANDS------------");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Enter 'q' to QUIT");
                    System.out.println("Enter '1' to Create a new Customer Account");
                    System.out.println("Enter '2' to Add a new Movie Account");
                    System.out.println("Enter '3' to See Customer commands");
                    System.out.println("Enter '4' to See Movie commands");
                }
                
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }


                
        }
            user.close();
    }
}


