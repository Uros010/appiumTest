package urosdimitrijevicmobile.Apiium;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int myNum = 5;
		String website = "Rahul Shetty Academy";
		char letter = 'r';
		double dec = 5.99;
		boolean myCard = true;
		
		System.out.println(myNum + "is the value stored in the myNum variable");
		
		//Arrays - 
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		int [] arr2 = {1,2,3,4,5,6 ,8,12,155};
		System.out.println(arr2[0]);
		
		//for loop
		for (int i = 0; i<arr.length; i++) 
		{
			System.out.println(arr[i]);
		}
		
		for (int i=0; i<arr2.length; i++) 
		{
			System.out.println(arr2[i]);
		}
		String[] name = {"rahul", "shetty", "academy"};
		
		for (int i=0; i<name.length; i++) 
		{
			System.out.println(name[i]);
		}
	}

}
