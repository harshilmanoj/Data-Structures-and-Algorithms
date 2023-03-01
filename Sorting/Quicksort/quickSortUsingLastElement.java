import java.util.Scanner;

public class quickSortUsingLastElement{

    //partition function
    /*Arguments of the array : 1. Array to be sorted, 
                               2. Leftmost index (first index) of the array or subarray, 
                               3. Rightmost index (last index) of the array or subarray.

        Pivot Element = Last Element.
        
        The indx variable stores till what indices the function needs to store the elements that is less
        than the pivot.

        While traversing the array or subarray if an element is smaller than the pivot it will increase the
        index value and swap the element with thw current element. This will continue till the pivot element
        (last element).

        After that the pivot is placed all the elements lesser than pivot by increasinf the idex value and swapping.

        The index of the pivot is returned.

    */
    public static int partition(int arr[],int low,int high){
        int pivot = arr[high];
        int indx = low - 1;

        for(int i = low;i<high;i++){
            if(arr[i]<pivot){
                indx++;
                int temp = arr[i];
                arr[i] = arr[indx];
                arr[indx] = temp;
            }
        }

        indx++;
        int temp = arr[indx];
        arr[indx] = pivot;
        arr[high] = temp;

        return indx;
    }
    
    //quickSortFunction
    /*Arguments of the array : 1. Array to be sorted, 
                               2. Leftmost index (first index) of the array or subarray, 
                               3. Rightmost index (last index) of the array or subarray.

        This function follows a recursive approach where the array to be sorted are divided into multiple
        arrays by judging the position of the pivot element.

        The partition funcion called inside this function makes sure that all the elements on the left of the
        pivot index is smaller compared to pivot element and all the elements to the right of the elements are
        greater compared to the pivot element.

        Then the quickSortfunction is again called on the left subarray and right subarray.

        For Example : 
        Array :  5 3 2 1 4
        Consider pivot element : 4 (The last element)
        After Partition : 3 2 1 4 5
        Left Subarray : 3 2 1
        Right Subarray : 5                              
                               
    */
    public static void quickSortFunction(int arr[],int low,int high){
        if(low<high){
            int pivotindx = partition(arr, low, high);
            quickSortFunction(arr, low, pivotindx-1);
            quickSortFunction(arr, pivotindx+1, high);            
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
        
        //Calling quickSortFunction to sort.
        quickSortFunction(arr,0,arr.length-1);

        //Printing the sorted array.
        System.out.print("Sorted Array : ");
        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }

        sc.close();
    }
}
