package CountingSort;

import java.util.Scanner;

public class countingSort {
    public static void countSort(int[] arr, int n){
        int max = arr[0];
        int output[] = new int[n];
        for(int i = 0;i<n;i++){
            max = Math.max(max, arr[i]);
        }
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i){
            count[i] = 0;

        }

        
        for (int i = 0; i < n; ++i){
            ++count[arr[i]];
            
        }
        
        for (int i = 1; i <= 255; ++i){
            count[i] += count[i - 1];
        } 

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < n; ++i){
            arr[i] = output[i];

        }


    }
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

        countSort(arr,n);

        //Printing the sorted array.
        System.out.print("Sorted Array : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();        
    }
}
