package DesignPatterns.Creational.Singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SingletonClass implements Serializable
{
	
	public static SingletonClass instance = new SingletonClass();
	
	private SingletonClass()
	{
		
	}
	
	// By Overriding readResolve method, we can get the same instance only
	protected Object readResolve()
	{
		return instance;
		
	}
	
}



public class SingletonSerializable {
	
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		
		SingletonClass instance = SingletonClass.instance;
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./file.txt"));
		out.writeObject(instance);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("./file.txt"));
		
		SingletonClass instance2 = (SingletonClass) in.readObject();
		
		// Here we got the new Object. That is failing Singleton purpose
		System.out.println(instance.hashCode());
		System.out.println(instance2.hashCode());
		
		
		
	}
	
	

}
