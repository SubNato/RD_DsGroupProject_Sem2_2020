
public class Round {

	private String category;
	private String puzzle;
	private int[] roundTotal = new int[3]; 

	
public Round() {
		category = "";
		puzzle = "";
	}
public void setCategory(String category) {
		this.category = category;
	}
	void setPuzzle(String puzzle) {
		this.puzzle = puzzle;
	}
	void setRoundTotal(int roundTotal,int i) {
		this.roundTotal[i] = roundTotal;
	}
	String getCategory() {
		return category;
	}
	String getPuzzle() {
		return puzzle;
	}
	int getRoundTotal(int i) {
		return roundTotal[i];
	}
}