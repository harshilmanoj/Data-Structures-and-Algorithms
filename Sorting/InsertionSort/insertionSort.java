package InsertionSort;

import java.util.Scanner;

public class insertionSort {
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
