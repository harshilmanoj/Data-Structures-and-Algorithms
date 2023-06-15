import java.util.Scanner;

public class print1ToNBacktrack {
    public static void print(int n,int i){
        if(n<i){
            return;
        }
        print(n-1, i);
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("The Numbers are : ");
        print(n,1);

    }
}
