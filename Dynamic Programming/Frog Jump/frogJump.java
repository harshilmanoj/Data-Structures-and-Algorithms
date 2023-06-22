import java.util.Scanner;

public class frogJump {
    public static int recursion(int arr[],int i,int dp[]){
        if(i >= arr.length){

        }

        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] =  new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int dp[] = new int[n];

        recursion(arr,0,dp);
        
    }
}
