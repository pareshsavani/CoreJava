import java.util.Scanner;

public class Arr {
    public static void main(String[] args) {
        int[] ar=new int[5];
  
        Scanner sc=new Scanner(System.in);
 
        System.out.println("Please enter 5 numbers");
        for(int i=0; i<ar.length; i++){
            ar[i]=sc.nextInt();
        }

        // System.out.print(ar[0]);
        // System.out.print(ar[1]);
        // System.out.print(ar[2]);
        // System.out.print(ar[3]);
        // System.out.print(ar[4]);

        for(int j=0; j<ar.length; j++){
            System.out.print(ar[j]);
        }
        sc.close();
    }    
}
