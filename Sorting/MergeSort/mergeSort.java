import java.util.Scanner;

public class mergeSort {
    /*
     * Best Case :  O(nlogn)
     * Average Case : O(nlogn)
     * Worst Case : O(nlogn)
     */

    //partition function
    /*Arguments of the array : 1. Array to be sorted, 
                               2. Leftmost index (first index) of the array or subarray, 
                               3. Rightmost index (last index) of the array or subarray,
                               4. Mid Index of the array or the subarray.
        
        Two indices are maintained at the initial positions of the left and the right subarray.
        A new Array is initailized to store the sorted array temporarily
        
        The first while loop is to compare the two subarrays and to store the data in ascending order till
        one of the subarray is fully traversed.

        The next two while loops are just to fill the rest of the elements in a sorted manner.

        Finally all the elements are stored back to the main array in a sorted manner.

    */
    public static void merge(int arr[], int low, int high, int mid){
        int indx1 = low;
        int indx2 = mid+1;
        int mergedarr[] = new int[high-low+1];
        int i = 0;
        
        while(indx1 <= mid && indx2 <= high){
            if(arr[indx1]<arr[indx2]){
                mergedarr[i++] = arr[indx1++];
            }
            else{
                mergedarr[i++] = arr[indx2++];
            }
        }
        
        while(indx1 <= mid){
            mergedarr[i++] = arr[indx1++];
        }
        
        while(indx2 <= high){
            mergedarr[i++] = arr[indx2++];
        }

        for(int j = 0,k=low;j<mergedarr.length;j++,k++){
            arr[k] = mergedarr[j];
        }

    }

    //mergeSortFunction
    /*Arguments of the array : 1. Array to be sorted, 
                               2. Leftmost index (first index) of the array or subarray, 
                               3. Rightmost index (last index) of the array or subarray.

        This function follows a recursive approach where the array to be sorted are divided into two subarrays
        using the mid point.

        The mergeSortFunction is recursively called on both the sub arrays.
        Finally the a merge function is called to joint the array that was divided into two parts in a 
        sorted manner.

        For Example : 
        Array :  5 3 2 1 4
        Left Subarray : 5 3 2
        Right Subarray : 1 4
        
        After merge function : 
        Left Subarray : 2 3 5
        Right Subarray : 1 4
                               
    */
    public static void mergeSortFunction(int arr[], int low , int high){
        if(low>=high){
            return;
        }
        int mid =  low + (high -low)/2;
        mergeSortFunction(arr, low, mid);
        mergeSortFunction(arr, mid+1, high);
        merge(arr,low,high,mid);
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
        
        //Calling quickSortFunction to sort.
        mergeSortFunction(arr,0,arr.length-1);

        //Printing the sorted array.
        System.out.print("Sorted Array : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();        
    }
}
