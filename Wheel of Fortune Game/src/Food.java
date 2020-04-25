
	import java.util.*;
	import java.lang.*;
	import java.io.*;

public class Food {
		
		private String Category;
		private String Word;
		
		
		public Food(String category, String word) {
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
				
			FileWriter Foods = new FileWriter("Food.txt", true);
			
			
			System.out.printf("\n\n\tEnter the Word: ");
			newWord = newWord1.nextLine();
			
			WordID++;
			
			Foods.write(newWord);			
			Foods.write("\t");
			Foods.write(WordID);
			Foods.write("\n");
			Foods.close();
			System.out.println("Successfully added word to foods!\n\n");
			
			System.out.println("\nDo you want to add another word? \n\t 1) Yes 2) No");
			
			System.out.print("Choose an option: ");
			newOption = option.nextInt();
			
			switch (newOption) {
			case 1:
//				c.addCategory();
				Food.addWord(args);
				break;
			case 2:
				Game_Play gp = new Game_Play();
				gp.openFile();
				Game_Play.main(args);
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
