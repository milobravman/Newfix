class TestDictionary {
    public static void main(String[] args){
        MovieDict dict = new MovieDict();
        
        //create the movies 
        Movie aMovie = new Movie("Nightmare Before Christmas",20011031,95);
        Movie bMovie = new Movie("Caroline",20200821,90); 
        Movie cMovie = new Movie("Elves",20031015,29);
        Movie dMovie = new Movie("Jump",20200921,47); 
        Movie eMovie = new Movie("Blood Red Sky",20190930,89);
        Movie fMovie = new Movie("The Silence",20180821,56); 
        Movie gMovie = new Movie("Hush",20010918,67);
        Movie hMovie = new Movie("Before I Wake",20040621 ,78); 
        Movie iMovie = new Movie("Titanic",19690624,93);
        Movie jMovie = new Movie("Level 16",19660908,90); 
        Movie kMovie = new Movie("A Silent Voice",19970920,58); 
        Movie lMovie = new Movie("The Ugly Truth",19980212,86);
        Movie mMovie = new Movie("Lady Bird",20031115,87);
        Movie nMovie = new Movie("The Lovely Bones",20160421,79); 
        Movie oMovie = new Movie("What Happened To Monday",20000830,69);
        Movie pMovie = new Movie("Zodiac",20050901,54); 
        Movie qMovie = new Movie("The Old Ways",20151031,76);
        Movie rMovie = new Movie("After Math",20210121,69);
        Movie sMovie = new Movie("The Conjuring",20011111,84);
        Movie tMovie = new Movie("Underworld",20000101,39); 
        Movie uMovie = new Movie("Apostle",20031031,57);
        Movie vMovie = new Movie("The Silence",20170521,55);    
        Movie wMovie = new Movie("Eli",20170820,62); 
        Movie xMovie = new Movie("Winchester",20001004,27);
        Movie yMovie = new Movie("Death Note",20210317,59); 
        Movie zMovie = new Movie("Veronica",20030916,100);
  
        //insert the movies into the dictionary
        dict.insertDict(aMovie); 
        dict.insertDict(bMovie);
        dict.insertDict(cMovie);
        dict.insertDict(dMovie);
        dict.insertDict(eMovie);
        dict.insertDict(fMovie);
        dict.insertDict(gMovie);
        dict.insertDict(hMovie);
        dict.insertDict(iMovie);
        dict.insertDict(jMovie);
        dict.insertDict(kMovie);
        dict.insertDict(lMovie);
        dict.insertDict(mMovie);
        dict.insertDict(nMovie);
        dict.insertDict(oMovie);
        dict.insertDict(pMovie);
        dict.insertDict(qMovie);
        dict.insertDict(rMovie);
        dict.insertDict(sMovie);
        dict.insertDict(tMovie);
        dict.insertDict(uMovie);
        dict.insertDict(vMovie);
        dict.insertDict(wMovie);
        dict.insertDict(xMovie);
        dict.insertDict(yMovie);
        dict.insertDict(zMovie);
        
        //dict.deleteDict(mMovie);
        dict.printHashtable();
        dict.printHashtable();

    } 
  } 
