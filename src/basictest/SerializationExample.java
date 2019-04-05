package basictest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


//https://javabeginnerstutorial.com/core-java-tutorial/transient-vs-static-variable-java/

public class SerializationExample {
	
	
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
		SerializableClass sClass = new SerializableClass(37,"Gouru",437);
		
		System.out.println(sClass.toString());
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./ser.txt"));
		out.writeObject(sClass);
		out.close();
		
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("./ser.txt")); 
		SerializableClass sc = (SerializableClass) in.readObject();
		
		System.out.println(sc);
		
		
		// Serializing the Second class
		
		SerializableClassTwo sct = new SerializableClassTwo(37, "Gouru");
		
		sct.n = 444;
		sct.name = "Hello World";
		sct.i = 44;
		
		
		System.out.println(sct);
		
		ObjectOutputStream outTwo = new ObjectOutputStream(new FileOutputStream("./serTwo.txt"));
		outTwo.writeObject(sct);
		outTwo.close();
		
		
		ObjectInputStream inTwo = new ObjectInputStream(new FileInputStream("./serTwo.txt"));
		SerializableClassTwo inScTwo = (SerializableClassTwo) inTwo.readObject();
		
		System.out.println(inScTwo);
		
		
	}

}


class SerializableClass implements Serializable
{
	

	private static final long serialVersionUID = -1950087432148772146L;
	
	public int i;
	transient public String name;
	public static int n = 100;
	
	
	public SerializableClass()
	{
		i = 101;
		name = "vasu";
		n = 101;
	}
	
	public SerializableClass(int i, String name, int n)
	{
		this.i = i;
		this.name = name;
		this.n = n;
	}
	
	@Override
	public String toString() {
		return " i : "+i + "\t" + "Name : "+name + "\t" + "n : "+n+"\n";
	}
}


class SerializableClassTwo implements Serializable
{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1950087432148772147L;
	
	public int i;
	transient public String name;
	public static int n = 100;
	
	
	public SerializableClassTwo(int i, String name)
	{
		this.i = i;
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return " i : "+i + "\t" + "Name : "+name + "\t" + "n : "+n+"\n";
	}
}

