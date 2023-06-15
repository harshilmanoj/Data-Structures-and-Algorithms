package Recursion.Factorial;

import java.util.Scanner;

public class factorial {
    public static int fact(int n){
        if(n<=1){
            return 1;
        }
        
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input : ");
        int n = sc.nextInt();

        System.out.println("Factorial : ");
        System.out.println(fact(n));
        sc.close();

    }
}
