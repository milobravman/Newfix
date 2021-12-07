public class MovieHeap implements java.io.Serializable{
	
	private int n;		// counter to keep track of the amount of items in the array
	private Movie p[];	//index
	
	public MovieHeap(){
		p = new Movie[255];
		n = 0;
		
	}
	
	public Movie findMin(){		//returns the minimum Movie // least rated movie
		if (n == 0){		//if the array has nothing
			return null;
		}

		else{ 
			return p[0]; 	//return index of the Movie 
		}
	}

	private int getParent(int i){		//returns index of the parent
		return (i-1)/2;
	}

	private int getLeftChild(int i){	//returns index of the leftchild
		return (2 * i) + 1;
	}
	
	private int getRightChild(int i){	//returns index of the rightchild
		return (2* i) + 2;
	}
	
	public void insertHeap(Movie x){		// inserts a value into the heap
		if (n == 0){	// if there is nothing in the heap then the value is the first
			p[0] = x;
		}
		else{	//while the value of the Movie we are inserting is greater than the parent
			p[n] = x;
			int xIndex = n;			//index of the Movie we want to insert
			int pIndex = getParent(xIndex);		//index of parent Movie we are comparing it to
			while(p[xIndex].getRating() < p[pIndex].getRating() && xIndex != 0){	
				swap(xIndex,pIndex);	//swap the parent
				xIndex = pIndex;
				pIndex = getParent(xIndex);
			}
		}
		n++; 		// increase the value of n since you added something to the array

	}
	
	public void deleteMin(){			// deletes the minimum Movie 
		if (n == 0){			// if there is nothing in the array you can't delete anything
			System.out.println("nothing"); //don't return anything
		}
		else if (n == 1){
			n--;
		}			
		else { 
			swap(0, n-1); 			// calls the swap method for help
			n--;
			int xIndex = 0;
			int leftChild = getLeftChild(xIndex);
			int rightChild = getRightChild(xIndex);			// calls the swap function with the smallest child
			while (leftChild < n && rightChild < n){
				if (p[xIndex].getRating() < p[leftChild].getRating() && p[xIndex].getRating() < p[rightChild].getRating()) {
					System.out.println("Heap is complete");
				}
				else {
					if (p[xIndex].getRating() > p[leftChild].getRating() && p[leftChild].getRating() < p[rightChild].getRating()) {
						swap(xIndex,leftChild);
						xIndex = leftChild;
					}
					else {
						swap(xIndex,rightChild);
						xIndex = rightChild;	
					}
				
				}
				leftChild = getLeftChild(xIndex);
				rightChild = getRightChild(xIndex);	
			}

			if (leftChild < n && p[xIndex].getRating() > p[leftChild].getID()) {
				swap(xIndex,leftChild);
			}

		}
		
	}
	
	private void swap(int i, int j){	// swaps the Movie at index 0 with the smallest
		Movie temp = p[i];		//swap the index of the parent and y
		p[i] = p[j];			// swap the parent and the y
		p[j] = temp;
	}

	public boolean isEmptyHeap(){		//returns true if the heap is empty or false if it's not
		return (n == 0);
	}
	
	public void printHeap(){
		System.out.println("Heap size: " + n);		// print every item in the list as long as we get through all the items of the list
		for(int i = 0; i < n; i++) {		
            		System.out.print(p[i].getRating() + ",");	
		}

    
	
	}
  public static void main(String[] args) {
    // Heap test = new Heap();
    // Movie aMovie = new Movie("Nightmare Before Christmas", 20011031, 95);
    // Movie bMovie = new Movie("Caroline", 20200821 , 90); 
    // Movie cMovie = new Movie("Elves", 20031115, 29);
    // Movie dMovie = new Movie("Jump", 202020921 , 47); 

    //test.insert(aMovie);
    
    
  }
}