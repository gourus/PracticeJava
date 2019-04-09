package solidDesignPrinciples;

/*
 * 		-- CLIENT SHOULD NOT BE FORCED TO IMPLEMENT THE UNNECESSARY METHODS THEY  WILL NOT USE --
 * 
 * 	Designer should not add the burden on the client to implement the unnecessary methods that client will not use.
 * 
 * 	For this, instead of using Fat interface, modularize or cut down the interface into smaller ones, so that client 
 * can use and implement required interfaces.
 * 
 * 	i.e. Bringing the Single Responsibility principle to Interface level.
 *  
 * 	
 */


public class InterfaceSegregationPrinciple {
	
	interface Printer
	{
		public void printData(String content);
		public void scanData(String content);
		public void photoCopyData(String content);
		public void faxData(String content);
		
	}
	
	class HpPrinter implements Printer
	{

		@Override
		public void printData(String content) {
			System.out.println("print : "+content);
		}

		@Override
		public void scanData(String content) {
			System.out.println("scan : "+content);			
		}

		@Override
		public void photoCopyData(String content) {
			System.out.println("photoCopy : "+content);			
		}

		@Override
		public void faxData(String content) {
			System.out.println("fax : "+content);			
		}
		
	}
	
	/* 	If we see this, Cannon printer doesn't support functionalities of
	 * photoCopy and fax. But it should implement them because of the Printer interface.
	 * 
	 * 	Even though we can add, not supported message or exception, But it is a burden to the 
	 * client to implement it and it is not a good design.
	 * 
	 * 
	 * 	To overcome this, Divide the printer interface and use the respective interfaces with specified classes.
	*/
	class CannonPrinter implements Printer
	{

		@Override
		public void printData(String content) {
			System.out.println("print : "+content);
		}

		@Override
		public void scanData(String content) {
			System.out.println("scan : "+content);			
		}

		@Override
		public void photoCopyData(String content) {
			System.out.println("Not supported...");
		}

		@Override
		public void faxData(String content) {
			System.out.println("Not supported.. ");
		}
		
	}
	

}
