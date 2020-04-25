public class Queue {
	private QueueNode Front;
	private QueueNode Rear;

	public Queue() {
		Front = null;
		Rear = null;
	}

	public QueueNode getFront() {
		return Front;
	}

	public QueueNode getRear() {
		return Rear;
	}

	public void setFront(QueueNode n) {
		Front = n;
	}

	public void setRear(QueueNode n) {
		Rear = n;
	}

	public void Enqueue(String guess)
	{
		QueueNode temp = new QueueNode();
		if (temp != null)
		{
			if(Front ==null)
			{
				Front=temp;
				Rear=temp;
			}
			else
			{
				Rear.setNextNode(temp);
				temp.setPrevNode(Rear);
				Rear = temp;
			}
		}
		else
		{
			System.out.println("The list is full. Cannot add another node.");
		}
	}

	public String Dequeue() {
		WheelLetters dataToReturn = null;
		if (Front != null) {
			if (Front == Rear) {
				Rear = null;
			}
			QueueNode temp = Front;
			dataToReturn = Front.getData();
			Front = Front.getNextNode();
			temp = null;
		}
		return dataToReturn.getGuess();
	}

	public WheelLetters QueueFront()
	{
		if(Front == null)
		{
			System.out.println("NULL QUEUE.");
			return null;
		}
		else
		{
			return Front.getData();
		}
	}

	public int CountNodes() {
		int count = 0;
		Queue tempQueue = new Queue();
		while (Front != null) {
			tempQueue.Enqueue(Dequeue());
			count++;
		}
		while (tempQueue.getFront() != null) {
			Enqueue(tempQueue.Dequeue());
		}
		return count;
	}
}