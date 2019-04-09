package solidDesignPrinciples;

/*
 * 	  -- ONE CLASS OR MODULE SHOULD HAVE ONE AND ONLY ONE RESPONSIBILITY --
 * 		
 * 	
 * 	we should write, change and maintain a class for only one purpose
 * 
 * 		This approach will give flexibility to changes or Modifications in future
 * 	will not reflect on other modules.
 * 	
 * 	Each class and module should focus on single responsibility
 * 
 * 	Everything in that class should be related to that responsibility.
 * 
 * 	With this class will be short, clean and less fragile.
 * 
 * 	Class or module can have multiple methods n members, but they should
 * 	related to the same responsibility.
 *  
 *  Example : Logj4
 * 
 */

public class SingleResponsibilityPrinciple {	
	
	// This is not nested interface example. Just added here in the class
	// Took this example from outside source.
	
	interface Iuser
	{
		public boolean login(String user, String pwd);
		public boolean register(String user, String pwd, String email);
		
		// If we see here , bellow two methods are not related to User Interface
		// Instead of adding them here, we can have different interface for Logging and Send email
		
		//public void logging(String message);
		//public void sendEmail(String emailMessage);
		
	}
	
	interface Ilogger
	{
		public void logging(String message);
	}
	
	interface IEmail
	{
		public void sendEmail(String emailMessage);
	}
	
}
