import java.util.Scanner;

public class Customer implements java.io.Serializable {


    // feilds declared
    private String name;
    private int creditNum;
    private String email;
    private Customer left;
    private Customer right;

    // array of movies and 2 ints to create an Queue to strore the users wishlist 
    private Movie[] wishList;
    private int front;
    private int wishN;

    // List of movies watched
    private Watched head;
    private int wachedN;

    //constructor
    public Customer(String name, String email, int creditNum){

        this.name = name;
        this.creditNum = creditNum;
        this.email = email;
        wishList = new Movie[20];
        left = null;
        right = null;
        front = 0;
        wishN = 0;
        head = null;

    }

    //basic getter methods
    public String getName() {
        return name; 
    }
    public int getCreditNum() {
        return creditNum;
    }

    public String getEmail() {
        return email;
    }

    //basic setter methods

    public void setName(String name2){
        name = name2;
    }

    public void setEmail(String email2){
        email = email2;
    }

    public void setCredit(int credit2){
        creditNum = credit2;
    }


    //Node Getter and Setter methods for the Node pointers

    public Customer getLeft() {
        return left;
    }

    public Customer getRight() {
        return right;
    }

    public void setLeft(Customer node) {
        this.left = node;
    }

    public void setRight(Customer node) {
        this.right = node;
    }

    // Movie Queue functions

    // add movies to the back of the que (constant time)
    public void addToWish(Movie node){

        wishList[(front + wishN)%20] = node;
		wishN +=1;

    }

    public int WishlistLength(){
        return wishN;
    }

    public void upNest(){
        if (wishN == 0){
            System.out.println("There are no movies in this wish list!");
        }else {
            boolean found = false;
            while (found == false){
                if (wishList[front%20].isAvailable()){
                    System.out.println(wishList[front%20].getName());
                    found = true;
                    try {
                        System.out.println("would you like to remove this movie from your wishlist?");
                        System.out.println("Please enter 'Y' for yes or 'N' for no");
                        Scanner watched = new Scanner(System.in);                   
                        while (true) {
                            String userAnser = watched.next();
                            //System.out.println(userAnser.equals("Y"));
                            if (userAnser.equals("Y")){
                                System.out.println("Removing "+ wishList[front%20].getName() +" from your wishlist");
                                this.dequeue();
                                // if (head == null){
                                //     head = wishList[front%20];
                                // }else {
                                //     Movie temp = head;
                                //     head = wishList[front%20];
                                //     head.setNext(temp);
                                // }
                                found = true;
                                break;

                            }else if(userAnser.equals("N")){ 
                                System.out.println(" Leaving the wishlised unchaged");
                                found = true;
                                break;
                            }else{
                                System.out.println("Seems like you entered an invalid token");
                                System.out.println("Please enter 'Y' for yes or 'N' for no");
                            }
                        }
                        //watched.close(); 
                        // commenting out the closing of the scanner is bad but closing the scanner in here also closed the main scanner causing the porgram to crash

                        // I should probobly rewrite the customers class to not use the scanner at all.
                    } catch (Exception e) {
                        System.out.println(e);
                        found = true;
                        break;
                    }
                }
                else{
                    System.out.println("Sorry this"+ wishList[front%20].getName() +"is no longer avalible");
                    this.dequeue();
                }
            }
        }
    }

    private void dequeue(){
        //Movie temp = wishList[front%20];
        front = front +1;
        wishN -=1; 
        //return temp;
    }


    // add movies to the watched list
    // needs to check if movie has already been watched to prevent a movie node from pointing to itself
    public void watch(Movie node){

        Watched toAdd = new Watched(node.getName());
        if (wachedN == 0){
            head = toAdd;
            wachedN++;
        } else {
            Watched temp = head;
            head = toAdd;
            toAdd.setNext(temp);
        }
        //else{

        //     // This loop checks the incoming movie agains the list of watched movies to prevent the list from becoming a circle
        //     boolean alreadyWatched = false;
        //     Movie temp = head;
        //     for (int i = 0; i<wachedN; i++){
        //         if (temp.getID() == node.getID()){
        //             System.out.println("This movie has already been watched");
        //             alreadyWatched = true;
        //         }
        //         temp = temp.getNext();
        //     }
        //     // Only adds to the list if it is not alreay in there
        //     if (alreadyWatched == false){
        //         node.setNext(head);
        //         head = node;
        //         wachedN++;
        //     }
        // }
        
    }

    public void printWatched(){
        if (head !=null){
            Watched temp = head;
            while (temp !=null){
                System.out.println(name + " has watched " + temp.getName());
                temp = temp.getNext();
            }

        } else {
            System.out.println(name +" has not watched any movies");
        }
    }

    public static void main(String[] args) {
        Movie movie = new Movie("mName", 20160505, 99);
        Customer bob = new Customer("bob", "email", 123);
        bob.addToWish(movie);
        bob.upNest();
    }

}
