package urosdimitrijevicmobile.Apiium;

public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String literal //String is an object
		
		//String s1 = "Rahul Shetty Academy";
	
		//new memory alocate operator
		String s2 = new String("welcome");
		String s3 = new String("welcome");
		
		String s = "Rahul Shetty Academy";
		String[] splittedString = s.split("Shetty");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[1].trim());
		for (int i =s.length()-1; i>=0; i--) 
		{
			System.out.println(s.charAt(i));
		}
	}

}
