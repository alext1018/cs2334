

/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
public class Java1Review {

	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
		System.out.println("CS2334");
	}
	public static double divide(double a, double b){
		return a/b;
	}
	public static int divide(int a, int b) {
		return a/b;
	}
	public static boolean isDivisibleBy7(int a) {
		if(a%7==0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String main(String s) {
	 
			 return "Overloaded main method was passed \""+s+"\".";
		
}
	public static int findMin(int a, int b,int c) {
		if(a<b) {
			if(a<c) {
				return a;
			}	
		}
		else if(b<a) {
			if(b<c) {
				return b;
			}
		}
		return c;
		
		}
		public static int findMin(int [] array){
			int a = array[0];
			for( int i=0; i<array.length;i++) {
				if(a>array[i]) {
					a = array[i];
				}
			}
			return a;
		}
		public static double average(int [] array) {
			double sum = 0.0;
			int length = array.length;
			for(int i=0; i<array.length;i++) {
				sum+=array[i];
			}
			return sum/length;
		}
		public static String[] toLowerCase(String[] array) {
			int i;
			for(i=0; i<array.length;i++) {
				array[i] = array[i].toLowerCase();
				}
			return array;
		}
		public static String[] toLowerCaseCopy(String[] array) {
			int a = array.length;
			String[] n= new String[a];
			int i;
			for(i=0; i<array.length;i++) {
				n[i] = array[i].toLowerCase();
				}
			return n;
			}
			
		
		
		public static void removeDuplicates(int[] array) {
			for(int i = 0; i<array.length;++i) {
				boolean isDuplicates = false;
				for(int n =0;n <array.length;n++) {
					if(array[n]==array[i]) {
						array[n]=0;
						isDuplicates = true;
					}
					
				}
				if(isDuplicates) {
					array[i]=0;
				}
			}
		
		}
}
		
		


	
	
	
	
			


