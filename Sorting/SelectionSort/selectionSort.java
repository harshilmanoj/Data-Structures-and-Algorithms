package SelectionSort;

import java.util.Scanner;

public class selectionSort {

    /*
     * Best Case :  O(n^2)
     * Average Case : O(n^2)
     * Worst Case : O(n^2)
     */
    
    public static void main(String Args[]){
        //Creating Scanner for taking inputs.
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
        
        //SelectionSort Part
        /*First for loop runs for (n-1) times i.e if we sort n-1 elements the final element will already be sorted.
          Second for loop is to push the least element to first part.
          Instead of swapping everytime like in buble sort what this sort does is it fixes the least element to the
          begining relatively.
          
          The i index is initally considered as the minimum index which is then compared to rest of the elements in 
          array.Once the minimum element is found, the minimum index is changed and finally at the end the element is
          swapped and fixed to the particular index 

          For example : 
          Array : 5 2 3 1 4
          The program will execute in the following manner:
            1 2 3 5 4 --> Fixed 1 at first position
            1 2 3 5 4 --> Fixed 2 at second position
            1 2 3 5 4 --> Fixed 3 at third position
            1 2 3 4 5 --> Fixed 5 at fourth position

            That is total 4 iterations.   
        */
        for(int i = 0;i<n-1;i++){
            int minindx = i;
            for(int j = i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    minindx = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[minindx];
            arr[minindx] = temp;    
        }

        //Printing the sorted array.
        System.out.print("Sorted Array : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();        
    } 
}
