package basictest;

public class InheritanceExample {

	public static void main(String args[])
	{
		
		Base b = new Base();
	
		b.method1();
		
		System.out.println("Base : "+ b.getI());
		
		System.out.println();
		System.out.println();
		
		Derived d = new Derived();

		d.method1();
		d.method2();
		
		System.out.println("Derived : "+ d.getI());

		
		System.out.println();
		System.out.println();

		
		Base bd = new Derived(100);
		
		bd.method1();
		System.out.println("Base Derived : "+ bd.getI());
		
		//bd.method2(); // No acces for method 2
		
		//Derived db = new Base(); // Compile time error
		
	}
	
}



class Base
{
	int i;
	Base()
	{
		this(0);
		System.out.println("Base Default Constructor... ");

	}
	
	Base(int i)
	{
		this.i = i;
		System.out.println("Base Argumented Constructor... ");

	}
	
	public void method1()
	{
		System.out.println("Base class method... : "+ i);
	}
	
	public int getI()
	{
		return i;
	}
	
	public Base getNewClassInstance()
	{
		return new Base();
	}
	
}

class Derived extends Base
{
	int i;
	
	Derived()
	{
		this(10);
		System.out.println("Derived Default Constructor... ");
	}
	
	Derived(int i)
	{
		this.i = i;
		System.out.println("Derived Argumented Constructor... ");

	}
	
	public void method2()
	{
		System.out.println("Derived class method... : "+i);
	}

	public int getI()
	{
		return i;
	}
	
	// Overriding base method with different return type
	@Override
	public Derived getNewClassInstance() {
		return new Derived();
	}
	
}
