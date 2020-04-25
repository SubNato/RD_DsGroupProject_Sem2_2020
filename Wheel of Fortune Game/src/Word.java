
import java.util.*;
import java.lang.*;
import java.io.*;

public class Word {
	
	private String Words;
	
	
	
	public Word(String words) {
		super();
		Words = words;
	}
	
	

	public String getWords() {
		return Words;
	}



	public void setWords(String words) {
		Words = words;
	}



	public static void main(String[] args) {
		
		Word.addWord(args);
	}
	
	public static void addWord(String args[]) {

		String newCategory;
		int CategoryID = 0;
		int newOption;
		
		Scanner newCategory1 = new Scanner(System.in);
		Scanner option = new Scanner(System.in);
		
		System.out.println("\tWhich category are you adding a word to?");
		System.out.println("\n\t1) Foods || 2) Places || 3) Brands");
		System.out.printf("\n\nChoose an option:");
		newOption = option.nextInt();
		
		switch (newOption) {
		case 1:
			Food.addWord(args);
			break;
		case 2:
			Place.addWord(args);
			break;
		case 3:
			Brand.addWord(args);
			break;
		default:
			System.out.println("Invalid option!\n\n");
			Word.addWord(args);
			break;
		}
	}

}
