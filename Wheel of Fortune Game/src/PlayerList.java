public class PlayerList {
	private PlayerNode Head;

	public PlayerList() {
		Head = null;
	}

	public PlayerNode GetHead() {
		return Head;
	}

	public void SetHead(PlayerNode h) {
		Head = h;
	}

	public void InsertAtFront(int playerNum, String playerName, int grandTotal) {
		PlayerNode temp = new PlayerNode(playerNum, playerName, grandTotal);
		if (Head == null) {
			Head = temp;
		} else {
			temp.SetNextPlayer(Head);
			Head = temp;
		}
	}

	public void DisplayList() {
		PlayerNode temp = Head;
		if (temp == null) {
			while (temp != null) {
				temp.Display();
				temp = temp.GetNextPlayer();
			}
		} else {
			System.out.println("List is empty, Nothing to display");
		}
	}
}
