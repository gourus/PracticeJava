package basictest;

import java.util.*;

final class ImmutableClassExample {
	
	private int id;

	private String name;
	private Date date;
	
	static int tempId = 100;
	
	public ImmutableClassExample()
	{
		this(tempId,"name "+tempId, new Date());
		tempId++;
	}
	
	public ImmutableClassExample(int id, String name, Date date)
	{
		this.id = id;
		this.name = name;
		this.date = new Date(date.getTime());
		
	}
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		// We need to return the clone or Newly created date
		return new Date(date.getTime());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id +"  !!  " + this.name +"  !!  "+this.date.toString();
	}
	
	
	public static void main(String [] args)
	{
		ImmutableClassExample ic = new ImmutableClassExample();
		
		System.out.println(ic);
		
		Date d = ic.getDate();
		
		d.setTime(2323223232L); // Now this will not reflect on Class Object
		
		System.out.println(ic);

		
		
	}
	
	

}
