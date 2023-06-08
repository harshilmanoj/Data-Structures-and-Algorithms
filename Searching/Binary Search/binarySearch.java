import java.util.Scanner;

public class binarySearch {
    public static void binarySearchFunction(int arr[],int x){
        int low = 0;
        int high = arr.length -1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==x){
                System.out.println("The element is present at index : "+ mid);
                return;
            }
            else if(arr[mid]>x){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        System.out.println("The element doesn't exists in the given array.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the no. of elements in the array : ");
        int n = sc.nextInt();
        
        System.out.println("Enter the elements of the array : ");
        int arr[] = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the element that needed to be searched : ");
        int x = sc.nextInt();

        binarySearchFunction(arr,x);

        sc.close();
    }
}
