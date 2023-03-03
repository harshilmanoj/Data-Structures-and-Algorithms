import java.util.Scanner;

public class bubbleSort {

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
        
        //BubbleSort Part
        /*First for loop runs for (n-1) times i.e if we sort n-1 elements the final element will already be sorted.
          Second for loop is to push the greatest element to last part.

          For example : 
          Array : 5 2 3 1 4
          The program will execute in the following manner:
            2 3 1 4 5 --> Fixed 5 at last position
            2 3 1 4 5 --> Fixed 4 at second last position
            2 1 3 4 5 --> Fixed 3 at third last position
            1 2 3 4 5 --> Fixed 2 at fourth last position

            That is total 4 iterations and n-1-i condition check for each iterations.   
        */
        for(int i = 0;i<n-1;i++){
            for(int j = 0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }    
            }
        }

        //Printing the sorted array.
        System.out.print("Sorted Array : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();        
    }
    
}
