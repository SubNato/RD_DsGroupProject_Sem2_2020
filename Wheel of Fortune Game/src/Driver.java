import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

	private static int round=1;
	private static int tempRound;
	private static boolean solved = false;
	private static String landed_on;
	private static int player = 1;
	private static String puzzle;
	private static String puzzleAnswer;
	private static boolean playerShouldGetSamePuzzle = false;
	private static boolean bought = false;
	private static int numCount = 3;

	public static void main(String[] args) throws IOException {
    	
    Node temp = new Node();

    PlayerList plist = new PlayerList();
    System.out.println("Welcome to Wheel of Fortune"); 
    for (int i=1; i<=3; i++)
    {
    	Scanner nameObj = new Scanner(System.in);
    	System.out.println(" Enter Player "+ i +" Name: ");
        String pname = nameObj.nextLine();

    }
    
    System.out.println("To continue press enter.");
    new java.util.Scanner(System.in).nextLine();

		Puzzle puzzleObj = new Puzzle();
    while (round <= 3) {
		numCount = 3;
    	Scanner catObj = new Scanner(System.in);
    	System.out.println("Select a Category for round: (Person, Place, Thing)"); 
    	String category = catObj.nextLine();

    	
		for (int i = 1; i <= numCount; i++) {
			solved = false;
			if (!bought){
				if (round <= 3){
					System.out.println("Round " + round);
				}
			}
			if (player > 3){
				break;
			}
			while (solved == false) {
				if (!bought){
					System.out.println("The wheel now spin for Player" + player);
					landed_on = list();

					Round roundObj = null;
					if("Bankrupt".equals(landed_on)){
						

					} else if("lose a turn".equals(landed_on)){
						System.out.println(" You lost your turn");
					}

				}
				
				break;
				
				}



				if (!"lose a turn".equals(landed_on) && !"Bankrupt".equals(landed_on)){
					Scanner OpObj = new Scanner(System.in);


				System.out.println("\nPlayer "+ player +" Choose  Guess, Solve or Buy Vowel");
				String option = OpObj.nextLine();
					if (option.equals("Guess") || option.equals("guess") ) {
						if (!solved) {


							if (!bought){
								puzzleObj.clearArrays();
							}


							if (tempRound != round){

								if (!playerShouldGetSamePuzzle){
									 puzzle = puzzleObj.loadPuzzleQuestion(category);
									 puzzleAnswer = puzzleObj.loadPuzzleAnswer(category,puzzle);
								}

								System.out.println(puzzle);
								for (int j = 0; j < puzzleAnswer.length(); j++){

									if (bought){

									}else {
										System.out.print(" " + '*');
									}

								}

								Scanner GObj = new Scanner(System.in);
								System.out.println("\nChoose a Letter");
								String guess = GObj.nextLine();
								Queue que = new Queue();
								que.Enqueue(guess);

								if (!bought){
									if (puzzleObj.loadPuzzle(category,guess.charAt(0),puzzle)){
										solved = true;
										round++;
										player++;
										playerShouldGetSamePuzzle = false;
									}else {
										tempRound = round;
										round++;
										player++;
										solved = false;
										playerShouldGetSamePuzzle = true;
									}
								}else{
									puzzleObj.setTempAnswer(puzzleAnswer);
									if (puzzleObj.guessPuzzle(guess.charAt(0),2)){
										solved = true;
										round++;
										player++;
										playerShouldGetSamePuzzle = false;
										bought = false;
									}else {
										tempRound = round;
										round++;
										player++;
										solved = false;
										playerShouldGetSamePuzzle = true;
										bought = false;
									}

								}

							}

						}
					}else if (option.equals("Solve") || option.equals("solve") ) {
						bought = false;
						if (!solved) {

							if (tempRound != round){

								if (!playerShouldGetSamePuzzle){
									puzzle = puzzleObj.loadPuzzleQuestion(category);
									puzzleAnswer = puzzleObj.loadPuzzleAnswer(category,puzzle);
									puzzleObj.getPuzzle(puzzleAnswer);
								}

								System.out.println(puzzle);
								for (int j = 0; j < puzzleAnswer.length(); j++){
									System.out.print(" " + puzzleObj.tempLetterArrayList.get(i).getLetter());
								}

								Scanner GObj = new Scanner(System.in);
								System.out.println("\nEnter your Guess");
								String guess = GObj.nextLine();
								Queue a = new Queue();
								a.Enqueue(guess);

								if (guess.toLowerCase().equals(puzzleAnswer.toLowerCase())){
									solved = true;
									round++;
									player++;
									playerShouldGetSamePuzzle = false;
									System.out.println("\nCongrats you successfully solved the puzzle");

								}else {
									tempRound = round;
									round++;
									player++;
									solved = false;
									playerShouldGetSamePuzzle = true;
									System.out.println(guess + " is incorrect");
								}

								System.out.println("answer is: " + puzzleAnswer);

							}




						}

					}else if (option.toLowerCase().equals("Buy Vowel".toLowerCase())){

						if (!solved) {

							if (tempRound != round){

								if (!playerShouldGetSamePuzzle){
									puzzle = puzzleObj.loadPuzzleQuestion(category);
									puzzleAnswer = puzzleObj.loadPuzzleAnswer(category,puzzle);
									puzzleObj.getPuzzle(puzzleAnswer);
								}

								System.out.println(puzzle);
								int count = 0;

								for (int a = 0; a < puzzleObj.puzzleLetterArrayList.size(); a++) {

									if (String.valueOf(puzzleObj.puzzleLetterArrayList.get(a).letter).toLowerCase().charAt(0) == 'a' ||
											String.valueOf(puzzleObj.puzzleLetterArrayList.get(a).letter).toLowerCase().charAt(0) == 'e' ||
											String.valueOf(puzzleObj.puzzleLetterArrayList.get(a).letter).toLowerCase().charAt(0) == 'i' ||
											String.valueOf(puzzleObj.puzzleLetterArrayList.get(a).letter).toLowerCase().charAt(0) == 'o' ||
											String.valueOf(puzzleObj.puzzleLetterArrayList.get(a).letter).toLowerCase().charAt(0) == 'u') {

										if (puzzleObj.tempLetterArrayList.get(a).getLetter() == '*'){
											if (count < 1){
												puzzleObj.tempLetterArrayList.get(a).setLetter(puzzleObj.puzzleLetterArrayList.get(a).letter);
												count++;
												playerShouldGetSamePuzzle = true;
												numCount++;

												for (int b = 0; b < puzzleObj.tempLetterArrayList.size(); b++){
													System.out.print(" " + puzzleObj.tempLetterArrayList.get(b).getLetter());
												}
											}
										}

									}else{
										numCount++;
										playerShouldGetSamePuzzle = true;
										if ( a == puzzleObj.puzzleLetterArrayList.size() - 1 && count < 1){
											System.out.print("No Vowels Found");
										}
									}
								}

							}


						}

						bought = true;

					}

				}else {
					round++;
					player++;
					break;
				}


				}
				}
    		System.out.println("End of Game");
    			}



private static String list() {
		// TODO Auto-generated method stub
		return null;
	}



private static String[] readArray(String string) {
		// TODO Auto-generated method stub
		return null;
	}
        
        public void getData() {
    		
    		int x=0;
    		
    		String[] Values = {"$850","Lose A Turn","$500","$700","$800","$650","$900","$2500","$ONE MILLION","$600","$550","$0"};

    		Wheel W= new Wheel();
    		
    		while(x!=11 )
    		{
    			W.setCardType(Values[x]);
    			W.setCardType(Values[x]);
    			x++;
    		}
    		
    	}

	}
