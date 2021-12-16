public class Watched implements java.io.Serializable {
    private String name;
    //private int watchId;
    private Watched next;

    public Watched(String name){
        this.name = name;
        //this.watchId = watchId;
        next = null;
    }

    public String getName(){
        return name;
    }
    // public int getWatchedId(){
    //     return watchId;
    // }

    public Watched getNext(){
        return next;
    }

    public void setNext(Watched movieInfo){
        next = movieInfo;

    }
}
/* This Simple class is to store the watched movies for customers

*/