package customclassloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader{
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		byte b[] = loadClassData(name);
		
		return defineClass(name, b, 0, b.length);
	}
	
	
	private byte[] loadClassData(String className) {

		InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace('.', '/') + ".class");
		
		//System.out.println(is.toString());
		
		ByteArrayOutputStream byteSet = new ByteArrayOutputStream();
		
		int len = 0;
		
		try
		{
			while((len = is.read())!= -1)
			{
				//System.out.println(len);
				byteSet.write(len);
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//System.out.println(byteSet.toString());
		
		return byteSet.toByteArray();
	}


	public static void main(String args[])
	{
		
	}
	

}
