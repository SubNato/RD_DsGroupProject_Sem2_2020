public class QueueNode {
	private QueueNode NextNode;
	private QueueNode PrevNode;
	private WheelLetters Data;


	public QueueNode() {
		Data = new WheelLetters();
		NextNode = null;
		PrevNode = null;
	}
	public QueueNode(String guess) {
		Data = new WheelLetters();
		NextNode = null;
		PrevNode = null;
		}
	public QueueNode(WheelLetters data) {
		Data = data;
		NextNode = null;
		PrevNode = null;
	}
	public QueueNode getNextNode() {
		return NextNode;
	}
	public void setNextNode(QueueNode nextNode) {
		NextNode = nextNode;
	}
	public QueueNode getPrevNode() {
		return PrevNode;
	}
	public void setPrevNode(QueueNode prevNode) {
		PrevNode = prevNode;
	}
	public void setPrevNode(Node rear) {
		// TODO Auto-generated method stub
		
	}
	public WheelLetters getData() {
		return Data;
	}
	public void setData(WheelLetters data) {
			Data = data;
	}
	}