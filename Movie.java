//manually create movie id (Integer) 
public class Movie implements java.io.Serializable{

  //instance variables for movie class
  private String mName = "" ;     //mName = the movie name
  private Integer mID = 0;        //mID = movie ID
  private Integer rDate = 0;      //movie release date
  private Integer rating= 0;      //rate of the movie
  private Movie nextMovie = null; //tracks the next movie
  private Integer i = 0;          //count of the amount of movies we have
  private boolean avail = true;   //start off with all movies as available 
  private static int moviesEverMade = 10000; // amount of movies ever made 


  public Movie (String mName, Integer rDate, Integer rating){ // what's used for the movie
    this.mName = mName;
    mID = moviesEverMade; 
    moviesEverMade++; //increments the amount of movies ever made
    this.rDate = rDate;
    this.rating = rating; 
    avail = true;
  }

  //Points Integers to next movie
	public void setNext(Movie next){
		this.nextMovie = next;	
	}

  //Returns next node
	public Movie getNext(){
		return nextMovie;
	}

  public void changeAvaliblity(){
		avail = false;
	}
  

  //the following code is all for the movie ID
  //returns the last 4 digits of the movie ID
  // I got rid of the modulo b/c the movie ID needs to be 5 digests long
	public Integer getID(){
		return mID;
	}


  //set the movie ID
	public void setmID(Integer mId0){
		mID = mId0;
	}

  // the following code is all for the name of the movie
 //sets the name of the film 
	public void setName(String name0){
		mName = name0;	
	}

	//return the name of the movie
	public String getName(){
		return mName;
	}


  //checks if the movie is available (true or false)
  public boolean isAvailable(){
    return avail; 
  }


  //the following code is for the rating of the film
  //returns the rating of the movie 
  public Integer getRating(){
    return rating;
  }


  //the following code is for the release date of the movie 
  //YYMMDD
  public void readDate(){
    int day = rDate % 100;             //to get day
    int year = rDate / 10000;          //to get year 
    int month = (rDate / 100) % 100;   //to get month 
    System.out.println(year + "/" + month+ "/" + day); //print the release date
  }

  // return the release date of the movie
  public Integer getDate(){
    return rDate;
  }
}
