// to calculate average value of an array

import java.util.Scanner;

public class AverageOfArray {

	public static void main(String[] args) 
	{
		int arr[]=new int[5], arrTot=0;
		float arrAvg;
		Scanner sc1=new Scanner(System.in);
		
		System.out.print("Please Enter 5 number::");
		for(int i=0;i<5;i++)
		{
			arr[i]=sc1.nextInt();		
			arrTot=arrTot+arr[i]++;		
		}
		/*
		 * for(int i=0;i<5;i++) { arrTot=arrTot+arr[i]++; }
		 */

		arrAvg=arrTot/arr.length;
		System.out.print("Average value of an array is " +arrAvg);
		sc1.close();
	}
