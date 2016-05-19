
public class Kapusta extends Fauna_i_Flora {
	String rodzaj;
	
	public Kapusta()
	{
		int wybor = rand.nextInt(4);
		switch(wybor)
		{
		case 0:
			rodzaj = "pekinska";
			break;
		case 1:
			rodzaj = "lodowa";
			break;
		case 2:
			rodzaj = "kiszona";
			break;
		case 3:
			rodzaj = "z grzybami";
			break;
		case 4: 
			rodzaj = "z grochem";
			break;
		}		
	}
	
	public String ToString()
	{
		return this.getClass().getName() + rodzaj + "\n";
	}
	
	public String getRodzaj()
	{
		return rodzaj;
	}
	
	public void setRodzaj(String rodzaj)
	{
		this.rodzaj = rodzaj;
	}
	
	public String toString()
	{
		return this.getClass().getName() + " Rodzaj: " + rodzaj;
	}
	
	public int compareTo(Fauna_i_Flora o) 
	{
		if(this.getClass().getName().compareTo(o.getClass().getName()) == 0) 
			return this.name.compareTo(o.name);
		else return this.getClass().getName().compareTo(o.getClass().getName());
	}
}
