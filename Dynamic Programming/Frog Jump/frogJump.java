import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class frogJump {
    public static int recursion(int arr[],int i,int dp[]){
        if(i == arr.length-1){
            return 0;
        }
        
        if(i = arr.length-2){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
                
        int oneStep = Math.abs(arr[i]-arr[i+2]) + recursion(arr,i+1,dp);
        int twoStep = Math.abs(arr[i]-arr[i+1]) + recursion(arr,i+2,dp);
        
        return dp[i]=Math.min(oneStep, twoStep);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println("Enter the no. elements in the array : ");
        int arr[] =  new int[n];

        System.out.println("Enter the element of the array : ");
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        

        recursion(arr,0,dp);        
    }
}
