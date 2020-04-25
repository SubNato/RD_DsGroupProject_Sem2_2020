import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PuzzleFile {
	  private Formatter x;
  public void openFile(){
    try {
    	x = new Formatter("puzzle.txt");
    } catch (IOException e) {
      System.out.println("An error occurred.");
    }
    }
  public void addRecords() {
	  x.format("%s%s\n", "Person ", "Usian");
	  x.format("%s%s\n", "Place ", "Jamaica");
	  x.format("%s%s\n", "Thing ", "Car"); 
  }
  public void closeFile() {
	  x.close();
}
}
  
/*public static String[] readArray(String file){
	int ctr=0;
	try {
		@SuppressWarnings("resource")
		Scanner s1= new Scanner(new File(file));
				while (s1.hasNextLine()){
					ctr = ctr +1;
					s1.next();
				}
				String[] words = new String[ctr];
				
				@SuppressWarnings("resource")
				Scanner s2 = new Scanner (new File(file));
				while(s2.hasNext()){
				for (int i1=0; i1< ctr; i1=i1+1) {
					words[i1]=s2.next();
				}
				return words;
	}
	}
catch (FileNotFoundException e) {

}
	return null;
}
}*/

  
  /*public static String readString(String file) {
	String text = "";
	try {
		@SuppressWarnings("resource")
		Scanner s= new Scanner(new File(file));
				while (s.hasNextLine()){
					text = text + s.next() + " ";
					}
	}
catch (FileNotFoundException e) {
	System.out.println("File not found");

}
	return text;
}
}*/
  
  /*public void loadPuzzle() { //loads puzzle from file
	    int i = 1;
	    try {
	      Scanner fileObj = new Scanner(new File("puzzle.txt"));
	      while (fileObj.hasNext( )) {
	        category = fileObj.next( );
	        puzzle = fileObj.next( );
	        //fileObj.next();
	        puzzles[i] = new Puzzle(category, puzzle);
	        i++;
	      }
	      fileObj.close( );
	    } catch (FileNotFoundException e) {
	      System.err.println("Could Not Load File");
	    }
	  }


	  public void displayPuzzles() {
	    for (int i = 1; i <= puzzles.length; i++) {
	      System.out.println("  " + puzzles[i].category + "   " + puzzles[i].puzzle);
	    }
	  }*/