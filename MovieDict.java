class MovieDict implements java.io.Serializable{
    private int n = 0; 
    private Movie[] MovieArr = new Movie[503];

    private Movie[] MovieSordered = new Movie[503];
  
    public MovieDict(){

    }
  
    public boolean isEmpty(){
      return n == 0;
    }
  
    public void insertDict(Movie newMovie){
      newMovie.setNext(MovieArr[newMovie.getID()%503]);
      MovieArr[newMovie.getID()%503]= newMovie;
      n++;     
    }
  
    public void deleteDict(Movie newMovie){
      int key = newMovie.getID();
      Movie pre = MovieArr[key%503];
      Movie temp = MovieArr[key%503];
      int i = 0;
      while (temp!=null){
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

    public void makeSortedArray(){
        for (int i = 0 ; i<503 ;i++ )
        {
            Movie temp = MovieArr[i];
            while (temp != null){
                System.out.println(temp.getName()+ " Movie id:" +temp.getID() + " isAvailable?:" + temp.isAvailable());
                temp = temp.getNext();
            }
        }
    }
  
    public void printHashtable(){
        System.out.println(n +" movies in the hash");
     for (int i = 0 ; i<503 ;i++ ){
       Movie temp = MovieArr[i];
       while (temp != null){
        System.out.println(temp.getName()+ " Movie id:" +temp.getID() + " isAvailable?:" + temp.isAvailable() + "Date: " + temp.getDate());
        temp = temp.getNext();
        }
      } 
    }
  }