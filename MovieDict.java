//MovieDict
import java.util.Arrays;

class MovieDict implements java.io.Serializable{
  public int n = 0; 
  private Movie[] MovieArr = new Movie[503];
  //public int[] DateArr = new int[503];

  public int[] MovieDates = new int[503];
  public int x = 0;

  public MovieDict(){
  }
  
  public boolean isEmptyHash(){
    return (n == 0);
  }

  public void setMovieArr(Movie[] changed){
      MovieArr = changed;
  }

  //insert 
  public void insertDict(Movie newMovie){
    newMovie.setNext(MovieArr[newMovie.getID()%503]);
    MovieArr[newMovie.getID()%503]= newMovie;

    MovieDates[x] = newMovie.getDate();
    x++; 
    n++;      
  }

  public int[] ordredArry(){
    int[] temp = MovieDates; 
    Arrays.sort(temp);
    return temp;
  }

  //delete 
  public Movie[] deleteDict(Movie newMovie){
    int key = newMovie.getID();
    Movie pre = MovieArr[key%503];
    Movie temp = MovieArr[key%503];
    int r = 0;
    while (temp!=null){
      if (temp.getID() == key){
        if (r == 0){
          MovieArr[key%503] = temp.getNext();
          r--;
          return MovieArr;
        }
        else{
          pre.setNext(temp.getNext());
          temp.setNext(null);
          r--;
          return MovieArr;
        }
      }
      else{
        temp = temp.getNext();
        if (r > 0){
         pre = pre.getNext();
        }
        r++;
      } 
    }
    return MovieArr;
  }  
    
  //look up 
  public Movie lookUpDict(int key){
      Movie temp = MovieArr[key%503];
      while (temp!=null){
        if (temp.getID() == key){
          return temp;
        }
        else{
          temp = temp.getNext();
        }
      }
      return temp;
  }

  public Movie lookUpDate(int key){
    for (int i = 0 ; i<503 ; i++ ){ 
      Movie temp = MovieArr[i]; 
      while (temp!=null){
        if (key == temp.getDate()  ){
          return temp;
        }
          else{
            temp = temp.getNext();
          }
      }
     }
    return null;
  }
  

  public void printHashtable(){//print all movies in order of release date 
   int x = 0; 
   int[] DateArr = new int[503];
   for (int i = 0 ; i<503 ; i++ ){ 
     Movie temp = MovieArr[i];
     while (temp != null){
      DateArr[x] = temp.getDate();
      temp = temp.getNext();
      x++;
    }
   }
   Arrays.sort(DateArr);
   for (int i = 0; i < 503; i++) {
     if (DateArr[i]!=0){
      System.out.println((lookUpDate(DateArr[i]).getName())+ " " + (lookUpDate(DateArr[i] ).getDate()));
     }
   }
  }
}
