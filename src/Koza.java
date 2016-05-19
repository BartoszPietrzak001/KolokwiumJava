
public class Koza extends Fauna_i_Flora {
	int ilosc_kapust;
	
	
	public Koza(String name)
	{
		this.name = name;
		
		ilosc_kapust = rand.nextInt(20);
	}
	
	public Koza()
	{
		this("Koza");
	}
	
	public int getIloscKapust()
	{
		return ilosc_kapust;
	}
	
	public void setIloscKapust(int ilosc_kapust)
	{
		this.ilosc_kapust = ilosc_kapust;
	}
	
	public String toString()
	{
		return this.getClass().getName() + " Imie: " + name + " , ilosc kapust: " + ilosc_kapust;
	}
	
	public int compareTo(Fauna_i_Flora o) 
	{
		if(this.getClass().getName().compareTo(o.getClass().getName()) == 0) 
			return this.name.compareTo(o.name);
		else return this.getClass().getName().compareTo(o.getClass().getName());
	}
}
