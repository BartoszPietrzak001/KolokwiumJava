
public class Wilk extends Fauna_i_Flora {
	int ilosc_koz;

	public Wilk(String name)
	{
		this.name = name;
		ilosc_koz = rand.nextInt(20);
	}
	
	public Wilk()
	{
		this("Wilk");
	}
	
	public int getIloscKoz()
	{
		return ilosc_koz;
	}
	
	public void setIloscKoz(int ilosc_koz)
	{
		this.ilosc_koz = ilosc_koz;
	}
	
	public String toString()
	{
		return this.getClass().getName() + " Imie: " + name + " , ilosc koz: " + ilosc_koz;
	}

	@Override
	public int compareTo(Fauna_i_Flora o) 
	{
		if(this.getClass().getName().compareTo(o.getClass().getName()) == 0) 
			return this.name.compareTo(o.name);
		else return this.getClass().getName().compareTo(o.getClass().getName());
	}
}
