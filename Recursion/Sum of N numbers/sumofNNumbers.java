import java.util.Scanner;

public class sumofNNumbers {

    public static int sumofn(int n){
        if(n==0){
            return 0;
        }
        return n + sumofn(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("The sum of N Numbers : ");
        System.out.println(sumofn(n));
        
    }
}
