import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Funkcje
{
	private static boolean brzeg = true;
	
	private static int iteracje = 0;
	
	private static ArrayList<Fauna_i_Flora> brzeg1;
	private static ArrayList<Fauna_i_Flora> brzeg2;
	
	private static Scanner scanner;
	
	public static String getBrzeg()
	{
		if (brzeg==true) return "Brzeg 1";
		else return "Brzeg 2";
	}
	
	public static void wypelnijBrzeg()
	{
		brzeg1 = new ArrayList<Fauna_i_Flora>();
		brzeg2 = new ArrayList<Fauna_i_Flora>();
		
		brzeg1.add(new Wilk("Stefan"));
		brzeg1.add(new Koza("Basia"));
		brzeg1.add(new Kapusta());
	}
	
	
	public static String printBrzeg1()
	{
		String answer="";
		answer+="Brzeg 1: " + "\n";
		for (Fauna_i_Flora x : brzeg1)
		{
			answer+=x + "  \n";
		}
		return answer;
	}
	
	public static String printBrzeg2()
	{
		String answer="";
		answer+="Brzeg 2: " + "\n";
		for (Fauna_i_Flora x : brzeg2)
		{
			answer+=x + "  \n";
		}
		return answer;
	}
	
	public static int getIteracje()
	{
		return iteracje;
	}
	
	public static String print()
	{
		String answer="";
		answer+=getBrzeg();
		answer+=printBrzeg1();
		answer+=printBrzeg2();
		answer+="Liczba wykonanych iteracji: " + iteracje;
		return answer;
	}
	
	public static void przewiezWilka() throws EatingException, ShoreException
	{
		iteracje++;
		if (brzeg==true)
		{
			for (Fauna_i_Flora x : brzeg1)
			{
				if(x instanceof Wilk)
				{
					int i=0;
					for (Fauna_i_Flora y : brzeg1)
					{
						if (y instanceof Koza) i++;
						else if (y instanceof Kapusta) i++;
					}
					if (i==2) throw new EatingException("koza_kapusta");
					else 
					{
						brzeg2.add(x);
						brzeg1.remove(x);
						brzeg = !brzeg;
						return;
					}
				}
			}
		}
		else if (brzeg==false)
		{
			for (Fauna_i_Flora x : brzeg2)
			{
				if(x instanceof Wilk)
				{
					int i=0;
					for (Fauna_i_Flora y : brzeg2)
					{
						if (y instanceof Koza) i++;
						else if (y instanceof Kapusta) i++;
					}
					if (i==2) throw new EatingException("koza_kapusta");
					else 
					{
						brzeg2.add(x);
						brzeg1.remove(x);
						brzeg = !brzeg;
						return;
					}
				}
			}
		}
		throw new ShoreException("Wilk");
	}
	
	public static void przewiezKoze() throws EatingException, ShoreException
	{
		iteracje++;
		if (brzeg==true)
		{
			for (Fauna_i_Flora x : brzeg1)
			{
				if(x instanceof Koza)
				{
						brzeg2.add(x);
						brzeg1.remove(x);
						brzeg = !brzeg;
						return;
				}
			}
		}
		else if (brzeg==false)
		{
			for (Fauna_i_Flora x : brzeg2)
			{
				if(x instanceof Koza)
				{
					brzeg1.add(x);
					brzeg2.remove(x);
					brzeg = !brzeg;
					return;
				}
			}
		}
		throw new ShoreException("Koza");
	}
	
	public static void przewiezKapuste() throws EatingException, ShoreException
	{
		iteracje++;
		if (brzeg==true)
		{
			for (Fauna_i_Flora x : brzeg1)
			{
				if(x instanceof Kapusta)
				{
					int i=0;
					for (Fauna_i_Flora y : brzeg1)
					{
						if (y instanceof Koza) i++;
						else if (y instanceof Wilk) i++;
					}
					if (i==2) {throw new EatingException("wilk_koza");}
					else
					{
						brzeg2.add(x);
						brzeg1.remove(x);
						brzeg = !brzeg;
						return;
					}
				}
			}
		}
		else if (brzeg==false)
		{
			for (Fauna_i_Flora x : brzeg2)
			{
				if(x instanceof Kapusta)
				{
					int i=0;
					for (Fauna_i_Flora y : brzeg2)
					{
						if (y instanceof Koza) i++;
						else if (y instanceof Wilk) i++;
					}
					if (i==2) throw new EatingException("wilk_koza");
					else
					{
						brzeg1.add(x);
						brzeg2.remove(x);
						brzeg = !brzeg;
						return;
					}
				}
			}
		}
		throw new ShoreException("Kapusta");
	}
	
	public static void zmienBrzeg() throws EatingException
	{
		iteracje++;
		int i=0;
		int j=0;
		if (brzeg==true)
		{
			for (Fauna_i_Flora y : brzeg1)
			{
				if (y instanceof Koza) {i++; j++;}
				else if (y instanceof Wilk) i++;
				else if (y instanceof Kapusta) j++;
			}
			if (i==2) throw new EatingException("wilk_koza");
			else if (j==2) throw new EatingException("koza_kapusta");
			else brzeg=!brzeg;
		}
		else if (brzeg==false)
		{
			for (Fauna_i_Flora y : brzeg2)
			{
				if (y instanceof Koza) {i++; j++;}
				else if (y instanceof Wilk) i++;
				else if (y instanceof Kapusta) j++;
			}
			if (i==2) throw new EatingException("koza_owca");
			else if (j==2) throw new EatingException("koza_kapusta");
			else brzeg=!brzeg;
		}
	}
	
	private static void sotrtuj() 
	{
		int wybor;
		System.out.println(print());
		System.out.println("Ktory brzeg chcesz posortowac? [1/2]");
		scanner = new Scanner(System.in);
		wybor = scanner.nextInt();
		
		switch(wybor)
		{
		case 1:
			Collections.sort(brzeg1);
			break;
		case 2:
			Collections.sort(brzeg2);
			break;
		default: System.out.println("Nie wybrales zadego brzegu!"); break;
		}
	}

	
	public static String whatToDo()
	{
		String answer = "";
		answer+="Exit - wyjscie z aplikacji\n";
		answer+="Print - informacje o obu brzegach\n";
		answer+="Wilk - przewiezienie wilka na drugi brzeg\n";
		answer+="Koza - przewiezienie kozy na drugi brzeg\n";
		answer+="Kapusta - przewiezienie kapusty na drugi brzeg\n";
		answer+="Zmiana - zmien brzeg\n";
		answer+="Zapis - zapis obecnego stanu do pliku tekstowego\n";
		answer+="Sortuj - posortuj obiekty na dowolnym brzegu\n";
		answer+="\nKtora opcje wybierasz?\n";
		return answer;
	}
	
	public static String decision(String choice)
	{
		char [] choiceLowCase = new char[choice.length()];
		for (int i=0; i<choice.length(); i++)
		{
			choiceLowCase[i] = (char) ((int) choice.charAt(i) | 32);
		}
		String choiceString = new String(choiceLowCase);
		
		switch(choiceString)
		{
		case "exit":
			System.exit(0);
			break;
		case "print":
			return print();
		case "wilk":
			try 
			{
				przewiezWilka();
			} 
			catch (EatingException e) 
			{
				return e.toString();
			} 
			catch (ShoreException e) 
			{
				return e.toString();
			}
			break;
		case "koza":
			try 
			{
				przewiezKoze();
			} 
			catch (EatingException e) 
			{
				return e.toString();
			}
			catch (ShoreException e) 
			{
				return e.toString();
			}
			break;
		case "kapusta":
			try 
			{
				przewiezKapuste();
			} 
			catch (EatingException e) 
			{
				return e.toString();
			}
			catch (ShoreException e) 
			{
					return e.toString();
			}
			break;
		case "zmiana":
			try 
			{
				zmienBrzeg();
			} 
			catch (EatingException e) 
			{
				return e.toString();
			}
			break;
		case "zapis":
			ZwierzetaIO.zapiszDoPliku();
			break;
		case "sortuj":
			sotrtuj();
			break;
		default: return "";
		}
		return "";
	}
}
