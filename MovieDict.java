class MovieDict implements java.io.Serializable{
    private int n = 0; 
    private Movie[] MovieArr = new Movie[503];
  
    public MovieDict(){
    }
  
    public boolean isEmpty(){
      return n == 0;
    }
  
    public void insertDict(Movie newMovie){
      newMovie.setNext(MovieArr[newMovie.getID()%8]);
      MovieArr[newMovie.getID()%503]= newMovie;
      n++;     
    }
  
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
      
  
    public String lookUpDict(int key){
      Movie temp = MovieArr[key%503];
      while (temp!=null){
        if (temp.getID() == key){
          return temp.getName();
        }
        else{
          temp = temp.getNext();
        }
      }
      return temp.getName();
    }
  
  
    public void printHashtable(){
     for (int i = 0 ; i<8 ;i++ ){
       Movie temp = MovieArr[i];
       System.out.print("index" + i + ":" + " ");
       while (temp != null){
        System.out.print(temp.getName()+ " " + ":" + " ");
        temp = temp.getNext();
        }
       System.out.println();
      } 
    }
  
  
  }
