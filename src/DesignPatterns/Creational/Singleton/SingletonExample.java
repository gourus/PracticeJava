package DesignPatterns.Creational.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * Enum should be used to make singleton work properly
 * with Reflection Apis
 * 
 */


class Singleton {
	
	
	public static Singleton singleton = null;
	
	private Singleton()
	{
		
	}
	
	public static Singleton getSingletonInstance()
	{
		if(singleton == null)
		{
			singleton = new Singleton();
		}
		
		return singleton;
	}
	
}


public class SingletonExample
{
	
	public static void main(String args[])
	{
		
		Singleton s = Singleton.getSingletonInstance();
		
		Singleton s1 = Singleton.getSingletonInstance();
		
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		
		assert(s.hashCode() != s1.hashCode());
		
		
		// If we are using reflection Apis, we will get the issue like below
		// For this we need to use Enum
		Constructor[] constructors = Singleton.class.getDeclaredConstructors();
		
		for(Constructor c : constructors)
		{
			c.setAccessible(true);
			
			try {
				
				Singleton s2 =  (Singleton) c.newInstance();
				
				System.out.println(s2.hashCode());
				
				
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
}
