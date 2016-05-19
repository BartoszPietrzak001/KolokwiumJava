public class ShoreException extends Exception 
{
	String message;
	
	public ShoreException(String zwierze)
	{
		message = zwierze + " jest na drugim brzegu!";
	}
	
	public String toString()
	{
		return message;
	}
}
