package customclassloader;

public class CustomClassLoaderTwo  extends ClassLoader{
	
	
	// Not Working
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return super.findClass(name);
	}

}
