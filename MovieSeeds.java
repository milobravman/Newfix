import java.io.*;
//import java.util.Scanner;

class MovieSeeds {
    public static void main(String[] args) {
        MovieHeap a = new MovieHeap();
        MovieDict b = new MovieDict();

        //MovieDict dict = new MovieDict();
    
        //create new movies
        //Movie (String mName, Integer mID, Integer rDate, Integer rating)
        Movie aMovie = new Movie("Nightmare Before Christmas", 20011031, 95);
        Movie bMovie = new Movie("Caroline", 20200821 , 90);
        Movie cMovie = new Movie("Elves", 20031015, 29);
        Movie dMovie = new Movie("Jump", 20200921 , 47);
        Movie eMovie = new Movie("Blood Red Sky", 20190930, 89);
        Movie fMovie = new Movie("The Silence", 20180821 , 56);
        Movie gMovie = new Movie("Hush", 20010918, 67);
        Movie hMovie = new Movie("Before I wak", 20040621 , 78);
        Movie iMovie = new Movie("Titanic", 19690624, 93);
        Movie jMovie = new Movie("Level 16", 19660908 , 90);
        Movie kMovie = new Movie("A Silent Voice", 19970920 , 58);
        Movie lMovie = new Movie("The Ugly Truth", 19980212 , 86);
        Movie mMovie = new Movie("Lady Bird", 20031115, 87);
        Movie nMovie = new Movie("The Lovely Bones", 20160421 , 79);
        Movie oMovie = new Movie("What Happened To Monday", 20000830, 69);
        Movie pMovie = new Movie("Zodiac", 200050901 , 54);
        Movie qMovie = new Movie("The Old Ways", 20151031, 76);
        Movie rMovie = new Movie("After Math",20210121 , 69);
        Movie sMovie = new Movie("The Conjuring", 20011111, 84);
        Movie tMovie = new Movie("Underworld", 20000101 , 39);
        Movie uMovie = new Movie("Apostle", 20031031, 57);
        Movie vMovie = new Movie("The Silence", 20170521 , 55);   
        Movie wMovie = new Movie("Eli", 20170820 , 62);
        Movie xMovie = new Movie("Winchester", 20001004, 27);
        Movie yMovie = new Movie("Death Note", 20210317 , 59);
        Movie zMovie = new Movie("Veronica", 20030916, 100);
    
        a.insertHeap(aMovie);
        a.insertHeap(bMovie);
        a.insertHeap(cMovie);
        a.insertHeap(dMovie);
        a.insertHeap(eMovie);
        a.insertHeap(lMovie);
        a.insertHeap(gMovie);
        a.insertHeap(zMovie);
        a.insertHeap(fMovie);
        a.insertHeap(hMovie);
        a.insertHeap(iMovie);
        a.insertHeap(jMovie);
        a.insertHeap(kMovie);

        a.insertHeap(mMovie);
        a.insertHeap(nMovie);
        a.insertHeap(oMovie);
        a.insertHeap(pMovie);
        a.insertHeap(qMovie);
        a.insertHeap(rMovie);

        a.insertHeap(sMovie);
        a.insertHeap(tMovie);
        a.insertHeap(uMovie);
        a.insertHeap(vMovie);
        a.insertHeap(wMovie);
        a.insertHeap(xMovie);
        a.insertHeap(yMovie);

        b.insertDict(aMovie);
        b.insertDict(bMovie);
        b.insertDict(cMovie);
        b.insertDict(dMovie);
        b.insertDict(eMovie);
        b.insertDict(fMovie);

        b.insertDict(gMovie);
        b.insertDict(hMovie);
        b.insertDict(iMovie);
        b.insertDict(jMovie);
        b.insertDict(kMovie);
        b.insertDict(lMovie);

        b.insertDict(mMovie);
        b.insertDict(nMovie);
        b.insertDict(oMovie);
        b.insertDict(pMovie);
        b.insertDict(qMovie);
        b.insertDict(rMovie);

        b.insertDict(sMovie);
        b.insertDict(tMovie);
        b.insertDict(uMovie);
        b.insertDict(vMovie);
        b.insertDict(wMovie);
        b.insertDict(xMovie);

        b.insertDict(yMovie);
        b.insertDict(zMovie);

        b.printHashtable();

        try {

            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("moviesAvail.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
                
            // Method for serialization of object
            out.writeObject(a);
                
            out.close();
            file.close();
                
            System.out.println("Object has been serialized");
            
        } catch (Exception e) {
            System.out.println(e);
        }


        try {

            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("movieDictiony.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
                
            // Method for serialization of object
            out.writeObject(b);
                
            out.close();
            file.close();
                
            System.out.println("Object has been serialized");
            
        } catch (Exception e) {
            System.out.println(e);
        }
      }
   }