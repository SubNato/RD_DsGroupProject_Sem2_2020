

	import java.util.*;
	import java.lang.*;
	import java.io.*;

public class Place {
		
		private String Category;
		private String Word;

		public Place(String category, String word) {
			super();
			Category = category;
			Word = word;
		}

		
		
		public String getCategory() {
			return Category;
		}



		public void setCategory(String category) {
			Category = category;
		}



		public String getWord() {
			return Word;
		}



		public void setWord(String word) {
			Word = word;
		}



		public static void main(String[] args) {
			
			Food.addWord(args);
		}
		
		public static void addWord(String args[]) {
			
//			Categories c = new Categories();
//			Wheel w = new Wheel();
			
			String newWord;
			int WordID = 0;
			int newOption;
			
			Scanner newWord1 = new Scanner(System.in);
			Scanner option = new Scanner(System.in);
			
			try {
				
			FileWriter Places = new FileWriter("Places.txt", true);
			
			
			System.out.printf("\n\n\tEnter the Word: ");
			newWord = newWord1.nextLine();
			
			WordID++;
			
			Places.write(newWord);			
			Places.write(WordID);
			Places.write("\n");
			Places.close();
			System.out.println("Successfully added word to foods!\n\n");
			
			System.out.println("\nDo you want to add another word? \n\t 1) Yes 2) No");
			
			System.out.print("Choose an option: ");
			newOption = option.nextInt();
			
			switch (newOption) {
			case 1:
//				c.addCategory();
				Place.addWord(args);
				break;
			case 2:
//				w.display();
				break;
			default:
				break;
			}
			
		}
			catch (Exception e){
				System.out.println("Unable to add word (-___-') ");
			}
		}
}
