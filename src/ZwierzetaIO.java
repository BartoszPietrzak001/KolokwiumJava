import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.Scanner;

public class ZwierzetaIO 
{
	public static void zapiszDoPliku()
	{
		String path;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Jak ma nazywac sie plik do zapisu?");
		path = scanner.nextLine();
		
		File plik = new File(path);
		
		try 
		{
			plik.createNewFile();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		try (BufferedWriter br = new BufferedWriter(new FileWriter(path))) 
		{
			br.write(Funkcje.getBrzeg());
			br.write(System.getProperty("line.separator"));
			br.write(Funkcje.printBrzeg1());
			br.write(System.getProperty("line.separator"));
			br.write(Funkcje.printBrzeg2());
			br.write(System.getProperty("line.separator"));
			br.write(Funkcje.getIteracje());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
