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
    private Movie head;
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
            System.out.println("There are no movies in you wish list!");
        }else {
            boolean found = false;
            while (found == false){
                if (wishList[front%20].isAvailable()){
                    System.out.println(wishList[front%20]);
                    found = true;
                    try {
                        System.out.println("would you like to remove this movie from your wishlist?");
                        System.out.println("Please enter 'Y' for yes or 'N' for no");
                        Scanner watched = new Scanner(System.in);                   
                        while (true) {
                            String userAnser = watched.nextLine();
                            if (userAnser.equals("Y")){

                                System.out.println("Removing "+ wishList[front%20].getName() +" from your wishlist");
                                this.dequeue();
                                break;

                            }else if(userAnser.equals("N")){ 
                                System.out.println(" Leaving the wishlised unchaged");
                                break;
                            }else{
                                System.out.println("Seems like you entered an invalid token");
                                System.out.println("Please enter 'Y' for yes or 'N' for no");
                            }
                        }
                        watched.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else{
                    System.out.println("Sorry this"+ wishList[front%20].getName() +"is no longer avalible");
                    this.dequeue();
                }
            }
        }
    }

    private Movie dequeue(){
        Movie temp = wishList[front%20];
        front = front +1;
        wishN -=1; 
        return temp;
    }

    public void watch(Movie node){
        if (wachedN == 0){
            head = node;
        }else{
            node.setNext(head);
            head = node;
        }
        wachedN++;
    }

}
