import java.util.Scanner;

public class switch1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Please enter your choice(1 to 7):: ");
        int ch = sc.nextInt();

        switch (ch)
        {
        case 1:
        System.out.println("Moday");
        break;
        
        case 2:
        System.out.println("Tuesday");
        break;

        case 3:
        System.out.println("Wednsday");
        break;

        case 4:
        System.out.println("Thurday");
        break;

        case 5:
        System.out.println("Friday");
        break;

        case 6:
        System.out.println("Saturday");
        break;

        case 7:
        System.out.println("Sunday");
        break;

        default:
        System.out.println("Choice is wrong!");

        sc.close();

        System.err.println("Do you want to continie? (Y/N)");
        String ans=sc.next();

        if(ans==equalIgnoreCase(y)){
            
        }
        }
    }
 }
