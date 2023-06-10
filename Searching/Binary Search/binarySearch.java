import java.util.Scanner;

public class binarySearch {
    //Binary Search Function
    //Divide and Conquer Approach
    //Time Complexity :  O(log(n))
    public static void binarySearchFunction(int arr[],int x){
        int low = 0;
        int high = arr.length -1;

        //We find the mid value and decide whether the expected answer is in the right hand side or left hand side of the array.
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
        
        //Taking input : Number of elememts in the array.
        System.out.println("Enter the no. of elements in the array : ");
        int n = sc.nextInt();
        
        //Taking inputs : The elements present in the array.
        System.out.println("Enter the elements of the array : ");
        int arr[] = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }

        //Taking input : The target element.
        System.out.println("Enter the element that needed to be searched : ");
        int x = sc.nextInt();
        
        //Calling the binarySearchFunction.
        binarySearchFunction(arr,x);

        sc.close();
    }
}
