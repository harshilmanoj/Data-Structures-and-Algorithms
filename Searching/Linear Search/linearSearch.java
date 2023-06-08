import java.util.Scanner;

public class linearSearch {
    public static void linearSearchFunction(int arr[],int x){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==x){
                System.out.println("Element found at index : " + i);
                return;
            }
        }
        System.out.println("Element not found.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of the array : ");
        for(int i = 0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter the element that is needed to be searched : ");
        int x = sc.nextInt();

        linearSearchFunction(arr,x);

    }
}
