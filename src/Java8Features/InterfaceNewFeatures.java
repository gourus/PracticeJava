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
 * Static Methods:
 * 
 * 	If we have a requirement to use only static methods in class, we need to write a class and use it. Creating 
 *  Creating class is very costly. Instead of that we can have interface with static methods.
 *  
 *  Advantages:
 *  	
 *  	No need to implement the interface with static methods
 *  	We can access with interface name.
 *  
 *  NOTE: We can create a main method in interface, as static methods are allowed from java 8.
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

// Interface with static method
interface s
{
	static void m2()
	{
		System.out.println("static Method m2 in interface s... ");
	}
}

// We have default method, we need to implement it
// And static method in this interface can't access with object
interface n
{
	static void m2()
	{
		System.out.println("static Method m2 in interface s... ");
	}
	
	default void m3()
	{
		System.out.println("m3() method from interface n");
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
public class InterfaceNewFeatures implements i,j,n{

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
		// If we have default with static method in interface, we have to implement it.
		inf.m3();
		//inf.m2(); // We can't access static method of interface with object reference.
		
		ImplementsInterfaceI ii = new ImplementsInterfaceI();
		ii.m1();
		
		ImplementsInterfaceJ ij = new ImplementsInterfaceJ();
		ij.m1();
		
		// We can directly access m2() from class and no need to implement as well.
		s.m2();
		
		
		
	}

}
