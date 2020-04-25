import java.io.*;
import java.lang.*;
import java.util.*;



public class Overview {

	
	
	private String PlayerName;
	private int Playernum;
	private int Total;
	private int Round;
	private String Category;
	private String puzzle;
	private int Attempt;
	private int RoundTotal;
	private int Turn;
	
	private Formatter x;


	public Overview(String playerName, int playernum, int total, int round, String category, String puzzle, int attempt,
			int roundTotal, int Turn) {
		super();
		PlayerName = playerName;
		Playernum = playernum;
		Total = total;
		Round = round;
		Category = category;
		this.puzzle = puzzle;
		Attempt = attempt;
		RoundTotal = roundTotal;
		Turn = Turn;
	}







	public Overview() {
		super();
	}







	public String getPlayerName() {
		return PlayerName;
	}







	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}







	public int getPlayernum() {
		return Playernum;
	}







	public void setPlayernum(int playernum) {
		Playernum = playernum;
	}







	public int getTotal() {
		return Total;
	}







	public void setTotal(int total) {
		Total = 0;
	}







	public int getRound() {
		return Round;
	}







	public void setRound(int round) {
		Round = 0;
	}







	public String getCategory() {
		return Category;
	}







	public void setCategory(String category) {
		Category = category;
	}







	public String getPuzzle() {
		return puzzle;
	}







	public void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}







	public int getAttempt() {
		return Attempt;
	}







	public void setAttempt(int attempt) {
		Attempt = attempt;
	}







	public int getRoundTotal() {
		return RoundTotal;
	}

	public void setRoundTotal(int roundTotal) {
		RoundTotal = 0;
	}


	public int getTurn() {
		return Turn;
	}

	public void setTurn(int turn) {

		Turn = turn;
	}
	
	public void CreateContestantFile() {
		//register contestants; create a contestant file
		try {
			x = new Formatter("Contestant.txt");
		}
		catch(Exception e) {
			System.out.println("Unable to create contestant file");
		}
	}
	
	public void addContestant() {
		
		Overview o = new Overview();
		Wheel w = new Wheel();
		
		try {
			FileWriter Player = new FileWriter("Contestant.txt", true);

			int newOption;
			int Playernum;
			String PlayerName;

			Scanner Playernum1 = new Scanner(System.in);
			Scanner PlayerName1 = new Scanner(System.in);
			Scanner option = new Scanner(System.in);

			System.out.print("\n\nWhat number player are you?  ");
			Playernum = Playernum1.nextInt();

			System.out.print("\n\nWhat's your name?  ");
			PlayerName = PlayerName1.nextLine();

			Player.write(PlayerName);			
			Player.write(Playernum);
			Player.write("\n");
			Player.close();
			System.out.println("Successfully added user.\n\n");
			
			System.out.println("\nAre there any other players? \n\t 1) Yes 2) No");
			
			System.out.print("Choose an option: ");
			newOption = option.nextInt();
			
			switch (newOption) {
			case 1:
				o.addContestant();
				break;
			case 2:
				w.display();
				break;
			default:
				break;
			}
		}
		catch(Exception e){
			System.out.println("Error 404! Unable to add contestant");
		}
	}
	
	public void closeContestant() {
		x.close();
	}

	public void display()
	{
		System.out.println("Display");
	}
	


}
