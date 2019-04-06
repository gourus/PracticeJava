package customclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassloaderTest {
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException,
													IllegalAccessException, NoSuchMethodException, 
													SecurityException, IllegalArgumentException, InvocationTargetException
	{
		CustomClassLoader cLoader = new CustomClassLoader();
		
		Class<?> c = cLoader.findClass("customclassloader.TestClass");
		
		Object ob = c.newInstance();
		
		Method m = c.getMethod("show");
		
		m.invoke(ob);
	
		
//		CustomClassLoaderTwo cLoaderTwo = new CustomClassLoaderTwo();
//		
//		Class<?> cls = cLoaderTwo.findClass("customclassloader.TestClass");
//		
//		Object object = cls.newInstance();
//		
//		Method method = cls.getMethod("show");
//		
//		method.invoke(object);
		
		
		
	}

}
