import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class Wheel {

		
	private Node head;
	private Node tail;
	private String Card;
	private String CardType;
	private int CardValue;
	private int RandCard;
	
		
	public Node getHead() {
		
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public String getCard() {
		return Card;
	}

	public void setCard(String card) {
		Card = card;
	}

	public String getCardType() {
		return CardType;
	}

	public Game_Play setCardType(String cardType) {
		CardType = cardType;
		
		Scanner keyboard = new Scanner(System.in);
		
		
		String [] Values = {"$850","Lose A Turn","$500","$700","$800","$650","$900","$2500","$ONE MILLION","$600","$550","$0"};
	
		try {
			
			
			int i=0;
			int index = (int) (Math.random() * Values.length);
			String temp = Values[i];
			Values[i] = Values[index];
			Values[index] = temp;
			
			
			System.out.println(Values[new Random().nextInt(Values.length)]);
			
		} catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Error in runtime occurred");
			}
		return null;
		
			
		}
		



	public int getCardValue() {
		return CardValue;
	}

	public void setCardValue(int cardValue) {
		CardValue = cardValue;
	}

	public int getRandCard() {
		return RandCard;
	}

	public void setRandCard(int randCard) {
		RandCard = randCard;
	}

	public Wheel() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public boolean isFull() {
		Node temp = new Node();
		if(temp == null) {
			return true;
		}else {
			temp = null;
			return false;
		}
	}
	
	public void addToBack(String data) {
		if(isFull()) {
			System.out.println("List is full");
		}else {
			Node temp = new Node();
			if(isEmpty()) {
				head = temp;
				tail = temp;
				head.setNextNode(temp);
			}else {
				tail.setNextNode(temp);
				temp.setNextNode(head);
				tail = temp;
			}
		}
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("List is empty");
		}else {
			head.display();
			Node current = head.getNextNode();
			while(current != head) {
				current.display();
				current = current.getNextNode();
			}
		}
	}
}
	