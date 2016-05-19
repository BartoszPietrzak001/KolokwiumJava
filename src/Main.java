import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Funkcje.wypelnijBrzeg();
		
		String wybor = "";
		do
		{
			System.out.println(Funkcje.whatToDo());
			wybor = scanner.nextLine();
			System.out.println(Funkcje.decision(wybor));
		}while (wybor!="exit");
	}

}
