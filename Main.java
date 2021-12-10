import java.util.Scanner;
import java.io.*;

public class Main {
    
    static public CustomerBST all = new CustomerBST();
    static public MovieHeap avalibleMovies = new MovieHeap();
    static public MovieDict allMoviesEver = new MovieDict(); 


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
              
            //System.out.println("Object has been deserialized ");
        }
          
        catch(IOException ex)
        {
            //System.out.println(ex);
            //System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            //System.out.println("ClassNotFoundException is caught");
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
              
            //System.out.println("Object has been deserialized ");
        }
          
        catch(IOException ex)
        {
            //System.out.println(ex);
            //System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            //System.out.println("ClassNotFoundException is caught");
        }

        // Deserialization of MovieDict
        try
        {   
            // Reading the BST from a file
            FileInputStream Files = new FileInputStream("movieDictiony.ser");
            ObjectInputStream in = new ObjectInputStream(Files);

            allMoviesEver = (MovieDict)in.readObject();
            
            in.close();
            Files.close();
              
            //System.out.println("Object has been deserialized ");
        }
          
        catch(IOException ex)
        {
            //System.out.println(ex);
            //System.out.println("IOException is caught");
        }
          
        catch(ClassNotFoundException ex)
        {
            //System.out.println("ClassNotFoundException is caught");
        }



        // Begining of of CLI menu code
        boolean running = true;

        //instructions for menu 
        System.out.println();
        System.out.println("Welcome to Netflix");
        System.out.println("As an admin you have access to all commands");
        System.out.println("Type 'h' for the list of all commands");
        Scanner user = new Scanner(System.in);  //create the scanner we'll be using throughout the program

        while(running){   //instruction manual w/ different commands and features
            try {
                String in = user.nextLine();
                if (in.equals("h")){
                    System.out.println("----------COMMANDS------------");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Enter 'q' to QUIT");
                    System.out.println("Enter '1' to Create a new Customer Account");
                    System.out.println("Enter '2' to Add a new Movie");
                    System.out.println("Enter '3' to See Customer commands");
                    System.out.println("Enter '4' to See Movie commands");
                }
                else if (in.equals("q")){ //quit function
                    running = false;
                    System.out.println("Thank you for watching, until next time!");
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
                            
                        //System.out.println("Object has been serialized");
                
                    }
                        
                    catch(IOException ex)
                    {
                        //System.out.println("IOException is caught");
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
                            
                        //System.out.println("Object has been serialized");
                        
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    // Serilization of Movie Dictionary

                    try {

                        //Saving of object in a file
                        FileOutputStream file = new FileOutputStream("movieDictiony.ser");
                        ObjectOutputStream out = new ObjectOutputStream(file);
                            
                        // Method for serialization of object
                        out.writeObject(allMoviesEver);
                            
                        out.close();
                        file.close();
                            
                        //System.out.println("Object has been serialized");
                        
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
                        System.out.print("Please enter the last five digits of your credit card number: ");
                        creditcardNum = user.nextInt();

    
                        try {
                            Customer temp = new Customer(name, email, creditcardNum);
                            all.insert(temp);
                            creatingCustomer = false;
                            System.out.println(temp.getName()+"'s account was created successfully! Welcome to your subscription! You are back in the main menu!");
                        } 
                        catch (Exception e) {
                            System.out.println("You entered an invalid variable please try again and enter the information carefully");
                        }
                    }
                    in = user.nextLine(); // very hacky way of preventing a new line charter from makeing the else in the orginal while loop occur unexpectedly
                }
                else if (in.equals("2")){
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
                 
                     System.out.println("What rate would you give this film out of 100. 100 being the best film you've watched and 0 being the worse: ");
                     rating = user.nextInt();  //user inputs the rating of the film

                     try {
                           Movie tempM = new Movie(mName, rDate, rating);
                           avalibleMovies.insertHeap(tempM);
                           allMoviesEver.insertDict(tempM);
                           createMovie = false; // stops from prompting for another movie
                           System.out.println("Movie was successfully added! You are back in the main menu.");
                       } 
                     catch (Exception e) {
                           System.out.println("You entered an invalid variable please try again and enter the information carefully. Make sure the year, month, day and rating are numbers.");
                       }

                     in = user.nextLine();
             
                     }
                }

                else if (in.equals("3")){ 
                    // customer commands 
                    boolean customersPage = true;
                    System.out.println("To see all current Customers enter 'a'");
                    System.out.println("To search for a Customers enter 's'");
                    System.out.println("To return to the main menu enter 'b'");
                    
                    while (customersPage){
                        in = user.nextLine();
                        if (in.equals("a")){
                            all.printTree();
                            System.out.println("These are all the users we have. Enter 'b' to get out of the Customer Page.");
                        }
                        
                        else if (in.equals("s")){
                          //searchCustomers();
                            System.out.println("What customer would you like to access? In order to successfully find the customer remember you must enter the credit number of the customer you are looking for.");
                            int key = user.nextInt();
                            Customer temp = all.search(key);

                            if (temp != null){
                                //customer information
                                System.out.println("This is "+ temp.getName() +"'s page"); 
                                System.out.println(temp.getName() +"'s email is "+ temp.getEmail());
                                System.out.println(temp.getName() +" has a wish list with "+ temp.WishlistLength()+" movies in it");

                                //commands for the wishlist 
                                System.out.println("");
                                System.out.println("Enter 1 to see the next movie on the "+ temp.getName()+"'s wishlist");
                                System.out.println("Enter 2 to add a movie to "+ temp.getName()+"'s wishlist");
                                System.out.println("Enter 3 to watch a movie for "+ temp.getName());
                                System.out.println("Enter 4 to return to " + temp.getName() + "'s customer page ");

                                boolean customerSelected = true;
                                while (customerSelected){
                                    int show = user.nextInt();
                                    //see the next movie option
                                    if (show == 1){   
                                        temp.upNest();
                                        in = user.nextLine();
                                    } 
                                    //option to watch a movie
                                    else if (show == 2){
                                        System.out.println("Enter the ID of the movie you want to add to " + temp.getName()+"'s wishlist");
                                        int id = user.nextInt();
                                        Movie tempMovie = allMoviesEver.lookUpDict(id);
                                        if (tempMovie!= null){
                                            temp.addToWish(tempMovie);
                                        }
                                        else{
                                            System.out.println("Seems like you entered an invalid movie ID. Please try again.");
                                            avalibleMovies.printHeap();
                                        }
                                    } 

                                    //option to watch a movie
                                    else if (show == 3){
                                        System.out.println("Enter the ID of the movie you want to watch" + temp.getName());
                                        int id = user.nextInt();
                                        Movie tempMovie = allMoviesEver.lookUpDict(id);
                                        if (tempMovie !=null){
                                            if (tempMovie.isAvailable()){
                                                System.out.println(temp.getName() + " Watched " + tempMovie.getName());
                                                temp.watch(tempMovie);
                                            }
                                            else{
                                                System.out.println("Sorry "+ tempMovie.getName() +" is no longer available");
                                            }
                                        }
                                        else{
                                            System.out.println("Seems like you entered an invalid movie ID. Please try again.");
                                            avalibleMovies.printHeap();
                                        }
                                    } 
                                    else if (show == 4){
                                        customerSelected = false;
                                        System.out.println("Returning to Customers menu");

                                        System.out.println("To see all current Customers enter 'a'");
                                        System.out.println("To search for a Customers enter 's'");
                                        System.out.println("To return to the main menu enter 'b'");

                                    }else if (show == 5){
                                        temp.printWatched();
                                    }
                                    else{
                                        System.out.println("It seems like you entered an invalid command.");
                                    }
                                }
                            }
                            else {  //
                                System.out.println("It seems like the credit card number does not match any user's account");
                                System.out.println("Please use the 'a' command to see the credit card numbers");
                            }
                            in = user.nextLine(); // very hacky way of preventing a new line character from making the else in the orginal while loop occur unexpectedly
                        }
                        else if (in.equals("b")){
                            customersPage = false;
                            System.out.println("Returning to the main menu");
                            System.out.println("Remember enter 'h' to see commands");
                        }
                        else {
                            System.out.println("Seems like you entered an invalid command");
                            System.out.println("To see all current Customers enter 'a'");
                            System.out.println("To search for a Customers enter 's'");
                            System.out.println("To return to the main menu enter 'b'");
                        }
                    }
                }
                else if (in.equals("4")){ 
                  //movies page
                    boolean moviePage = true;

                    System.out.println("To see all available movies enter 'a'");
                    System.out.println("To see all movies ever enter 'b'");
                    System.out.println("To see the least rated movie entered 'c'");
                    System.out.println("To return to the main menu enter 'd'");

                    while (moviePage) {
                        in = user.nextLine();

                        if (in.equals("a")) {

                            System.out.println("All available movies: ");
                            avalibleMovies.printHeap();

                        } else if (in.equals("b")){

                            allMoviesEver.printHashtable();

                        } else if(in.equals("c")){  
                            System.out.print("The least rated movie is: ");
                            Movie temp = avalibleMovies.findMin();

                            if (temp != null){
                                System.out.println(temp.getName());
                                System.out.println("Would you like to remove this movie from the pool of available movies");
                                System.out.println("Enter 'y' for yes and any other character for no");
                                in = user.nextLine();
                                if (in.equals("y")){
                                    avalibleMovies.deleteMin();
                                    System.out.println("deleting "+ temp.getName()+" rating: "+temp.getRating());
                                    System.out.println("The movie has been deleted! Enter 'd' to go back to the main menu.");
                                }
                            }
                            else {  //if heap is empty 
                                System.out.println("Seems like no movies are available");
                            }

                        }
                        else if (in.equals("d")){
                            moviePage = false;
                            System.out.println("Returning to the main menu");
                            System.out.println("Remember to enter 'h' to see commands");
                        }
                        else {
                            System.out.println("Seems like you entered an invalid command");
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
                System.out.println("hi");
                break;
            }
        }
            user.close();
    }
}