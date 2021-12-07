import java.util.Scanner;
import java.io.*;

public class Newflix {
    
    static public CustomerBST all = new CustomerBST();
    static public MovieHeap avalibleMovies = new MovieHeap(); 


    public static void main(String[] args) {

        //Customer object = new Customer(1, "geeksforgeeks");

        // Deserialization of CustomerBST
        try
        {   
            // Reading the BST from a file
            FileInputStream Files = new FileInputStream("customerBST.ser");
            ObjectInputStream in = new ObjectInputStream(Files);

            all = (CustomerBST)in.readObject();
            
            // Method for deserialization of object
            
            // Reading the Heap from a file
            in.close();
            Files.close();
              
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

        // Deserialization of MovieHeap
        try
        {   
            // Reading the BST from a file
            FileInputStream Files = new FileInputStream("moviesAvail.ser");
            ObjectInputStream in = new ObjectInputStream(Files);

            avalibleMovies = (MovieHeap)in.readObject();
            
            // Method for deserialization of object
            
            // Reading the Heap from a file
            in.close();
            Files.close();
              
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
                    //String filename = "file.ser";
        
                    // Serialization of CustomerBST
                    try
                    {   
                        //Saving of object in a file
                        FileOutputStream file = new FileOutputStream("customerBST.ser");
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

                    // Serialization of MovieHeap

                    try {

                        //Saving of object in a file
                        FileOutputStream file = new FileOutputStream("moviesAvail.ser");
                        ObjectOutputStream out = new ObjectOutputStream(file);
                            
                        // Method for serialization of object
                        out.writeObject(avalibleMovies);
                            
                        out.close();
                        file.close();
                            
                        System.out.println("Object has been serialized");
                        
                    } catch (Exception e) {
                        System.out.println(e);
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
                     //createMovie();
                     boolean createMovie = true; 
                     String mName;
                     int rDate;
                     int rating;

                     while (createMovie){
                     System.out.println("Here you can enter a new movie! However, please don't enter a film from before the 1800s!");
                     System.out.println();

                     System.out.println("What is the title of the film?: ");
                     mName = user.nextLine(); //input of the title

                     System.out.println("In the following lines we will require information about the release date.");
                     System.out.println("Input the release date in the following format --> YYYYMMDD: example 20211206");
                     rDate = user.nextInt(); // user input of the date
                     
                     while(String.valueOf(rDate).length() != 8){
                           rDate = user.nextInt();
                     }
                 
                     System.out.println("What rate would you give this film out of 100 being the best and 0 being the worse: ");
                     rating = user.nextInt();  //user inputs the rating of the film

                     try {
                           Movie tempM = new Movie(mName, rDate, rating);
                           avalibleMovies.insertHeap(tempM);
                           createMovie = false; // stops from prompting for another movie
                           System.out.println("Successfully added the movie!");
                       } 
                     catch (Exception e) {
                           System.out.println("You entered an invalid variable please try again and enter the information carfully. Make sure the year, month, day and rating are integers.");
                       }

                     in = user.nextLine();
             
                     }
                     

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
                else if (in.equals("4")){

                    boolean moviePage = true;

                    System.out.println("To see all avalible movies enter 'a'");
                    System.out.println("To see all movies ever enter b");
                    System.out.println("To see the least rated movie enter 'c'");
                    System.out.println("To return to the main menu enter 'd'");

                    while (moviePage) {
                        in = user.nextLine();

                        if (in.equals("a")) {
                            System.out.println("All avalible movies");

                        } else if (in.equals("b")){


                        } else if(in.equals("c")){

                        }else {
                            
                        }
                        
                    }

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


