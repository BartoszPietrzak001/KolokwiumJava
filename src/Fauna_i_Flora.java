import java.util.Random;

public abstract class Fauna_i_Flora implements Comparable<Fauna_i_Flora>
{
	protected String name;
	Random rand = new Random(System.currentTimeMillis());
	
	public String getImie()
	{
		return name;
	}
	
	public void setImie(String name)
	{
		this.name = name;
	}	
}
