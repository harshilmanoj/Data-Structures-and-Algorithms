package InsertionSort;

import java.util.Scanner;

public class insertionSort {
    /*
     * Best Case :  O(n)
     * Average Case : O(n^2)
     * Worst Case : O(n^2)
     */
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        //Storing n as the size of the array.
        System.out.print("Enter the number of elements in array : ");
        int n =  sc.nextInt();

        //Initializing array.
        int arr[] =  new int[n];

        //Storing values in array.
        System.out.println("Enter the elements of the array : ");
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }        
        
        //Printing the array.
        System.out.print("Array : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        
        //InsertionSort Part
        /*
          In this sorting technique divide the array into two parts :
            1. Sorted Part.
            2. Unsorted Part.

          We take one element and insert in a sorted position 
          The For-Loop chooses the element to be inserted in a sorted manner.
          The While loop comapres and decides which position the current element should be inserted. 

          For example:
          Array :  1 3 5 4 2

          Sorting :
                   1 3 5 4 2  -> Inserts 1 at write position
                   1 3 5 4 2  -> Inserts 3 at write position
                   1 3 5 4 2  -> Inserts 5 at write position
                   1 3 4 5 2  -> Inserts 4 at write position
                   1 2 3 4 5  -> Inserts 2 at write position
         */
        for(int i = 1;i<n;i++){
            int currelement = arr[i];
            int j = i-1;
            while(j>=0 && currelement < arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = currelement;   
        }

        //Printing the sorted array.
        System.out.print("Sorted Array : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();
    }
    
}
