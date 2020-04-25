public class PlayerNode {
	private static int Data;
	private PlayerNode NextPlayer;
	
	public PlayerNode() {
		Data = 1;
		NextPlayer = null;
	}
	
	public PlayerNode(int d) {
		Data = d;
		NextPlayer = null;
		}
	
	public PlayerNode(PlayerNode pn, int Data) {
		Data = PlayerNode.Data;
		NextPlayer = pn.NextPlayer;
		}
	
	public PlayerNode(int playerNum, String playerName, int grandTotal) {

	}

	public int GetData() {
		return Data;
	}

	public PlayerNode GetNextPlayer() {
		return NextPlayer;
	}

	public void SetData(int b) {
		Data = b;
	}

	public void SetNextPlayer(PlayerNode pn) {
		NextPlayer = pn;
	}

	public String toString() {
		return "Data: " + PlayerNode.Data;
	}
	
	public void Display(){
		System.out.println("Data: " + PlayerNode.Data);
	}
}