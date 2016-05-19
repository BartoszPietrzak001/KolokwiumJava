public class EatingException extends Exception {
	private String conflict;
	
	public EatingException(String type)
	{
		switch(type)
		{
		case "koza_kapusta":
			conflict = "Niemozliwa operacja - koza zjadlaby kapuste!";
			break;
		case "wilk_koza":
			conflict = "Niemozliwa operacja - wilk zjadlby koze!";
			break;
		}
	}
	
	public String toString()
	{
		return conflict;
	}
}
