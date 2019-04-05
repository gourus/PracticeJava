package Java8Features;


/*
 * Default methods are introduced in Java 8
 * 
 * Advantages:
 * 		We can add a new method to interface without changing the implemented classes.
 * 		Implemented class can use the default method implementation from interface or the can override.
 * 		
 * NOTE: Diamond problem may occur with default methods because, a single class can implement multiple interfaces.
 * 		To overcome this, we need to override the method in implemented class.
 * 
 * NOTE: Class can't contain default method.
 * 
 * NOTE: We can't add object class methods as default methods, because super class of any class in Object.
 *  
 * 
 */


interface i
{
	default void m1()
	{
		System.out.println("interface i m1 method");
	}
}

interface j
{
	default void m1()
	{
		System.out.println("interface j m1 method");
	}	
}

// First extend and next implement
class ImplementsInterfaceI  extends Object implements i
{
	// No need to override M1 if we want to use Default method
}


class ImplementsInterfaceJ implements j
{
	// No need to override M1 if we want to use Default method
}

// Here we should override default method m1()
public class InterfaceNewFeatures implements i,j{

	@Override
	public void m1() {
		System.out.println("m1 method from class InterfaceNewFeatures ");
		//i.super.m1(); // If we want to call interface i m1() method
		//j.super.m1(); // If we want to call interface j m1() method
	}
	
	public static void main(String arg[])
	{
		InterfaceNewFeatures inf = new InterfaceNewFeatures();
		
		inf.m1();
		
		
		ImplementsInterfaceI ii = new ImplementsInterfaceI();
		ii.m1();
		
		ImplementsInterfaceJ ij = new ImplementsInterfaceJ();
		ij.m1();
		
	}

}
