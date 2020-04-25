import java.util.Scanner;

public class Menu {
	
	public static void main(String args[]) {
		
		int option;
		
		Scanner option1 = new Scanner(System.in);
		
		System.out.println("\n\n\t\t\tWheel of Fortune");
		System.out.println("\n\t\t0) Play");
		System.out.println("\t\t1) Add Words");
		System.out.println("\t\t2) Exit");
		System.out.printf("\n\n\t\tChoose an option: ");
		option = option1.nextInt();
		
		switch(option) {
		case 0:
			break;
		case 1:
			Word.main(args);
			break;
		case 2:
			break;
		default:
			break;
		
		}
	}
}