import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Game_Play {

	
	private Overview PlayerName;
	private Overview Puzzle;
	private String Guess;
	private int points;
	
	
	
	public Game_Play()
	{
		super();
	}
	
	public Game_Play(Overview playerName, Overview puzzle, String guess) {
		super();
		PlayerName = playerName;
		Puzzle = puzzle;
		Guess = guess;
	}





	public Overview getPlayerName() {
		return PlayerName;
	}





	public void setPlayerName(Overview playerName) {
		PlayerName = playerName;
	}





	public Overview getPuzzle() {
		return Puzzle;
	}





	public void setPuzzle(Overview puzzle) {
		Puzzle = puzzle;
	}





	public String getGuess() {
		return Guess;
	}





	public void setGuess(String guess) {
		Guess = guess;
	}



	public void Bankurpt()
	{
		
	}
	
	public void LoseATurn()
	{
		
	}
	
	public int AddPoints(int points)
	{
		
		return points;
		
	}
	
	public void Start_Game() {
		
	}

private Scanner y;
	
	public void openFile() {
		try {
			y = new Scanner(new File("Food.txt"));

		} catch (Exception e) {
			System.out.println("No data found.");
		}
	}
	
	public void testing(String args[]) {
		
		String guess;
		String b;
		
		Scanner guess1 = new Scanner(System.in);
		
		while(y.hasNext()) {
			
		String a = y.next();
		

		int c = y.nextInt();
		System.out.println("hello");
		
		Random rand = new Random();
		
		int rand1 = rand.nextInt(c);
		
		if (rand1==c) {
			System.out.println("rand number if statement!");
			System.out.println(c);
		}
		
		String sPhrase;
		String guesses = " "; //users guesses
		Scanner keyboard = new Scanner(System.in);
		boolean notDone = true;
		
		sPhrase = a;
		
		Scanner word = new Scanner(System.in);
		
		while(true) {
			//print out the board
			notDone = false;
			for(char secretLetter : sPhrase.toCharArray()) { 
				if(guesses.indexOf(secretLetter) == -1) {
					System.out.print('*');
					notDone = true;
				} else {
					System.out.print(secretLetter);
				}
			}
			if(!notDone) {
				break;
			}

			System.out.print("\nEnter your letter:");
			String letter = keyboard.next();
			guesses += letter;
		}

		System.out.println("\n\nCongrats");
		break;
	}
//	}
}

	public static void main(String args[]) {
		Game_Play game = new Game_Play();
		game.openFile();
		game.testing(args);

	}

}
