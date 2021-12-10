//MovieDict
import java.util.Arrays;

class MovieDict implements java.io.Serializable{
  public int n = 0; 
  private Movie[] MovieArr = new Movie[503];
  public int[] DateArr = new int[503];
  public MovieDict(){
  }
  
  public boolean isEmptyHash(){
    return (n == 0);
  }

  //insert 
  public void insertDict(Movie newMovie){
    newMovie.setNext(MovieArr[newMovie.getID()%503]);
    MovieArr[newMovie.getID()%503]= newMovie;
    n++;      
  }

  //delete 
  public void deleteDict(Movie newMovie){
    int key = newMovie.getID();
    Movie pre = MovieArr[key%503];
    Movie temp = MovieArr[key%503];
    int i = 0;
    while (temp!=null){
      if (temp == null){
        break;
      }
      if (temp.getID() == key){
        if (i == 0){
          MovieArr[key%503] = temp.getNext();
          n--;
        }
        else{
          pre.setNext(temp.getNext());
          temp.setNext(null);
          n--;
        }
      }
      else{
        temp = temp.getNext();
        if (i > 0){
          pre = pre.getNext();
        }
        i++;
      }
    }
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
