public class dominoSeq {
    public static boolean check(int prev,int curr){
        if(prev==-1){
            return true;
        }
        if(prev==curr){
            return true;
        }
        else{
            return false;
        }
    }
    public static int recursion(int arr[],int ind,int count,int prev){
        if(ind==arr.length-2){
            if(check(prev,arr[ind])){
                return count+1;
            }
            else{
                return count;
            }

        }
        
        // System.out.println(count);
        int dontTake  = recursion(arr,ind+2,count,prev);
        int take  = count;
        if(check(prev,arr[ind])){
            // System.out.println(arr[ind]);
            // System.out.println(arr[ind+1]);
            // System.out.println();

            take = recursion(arr,ind+2,count+1,arr[ind+1]);
        }
        // System.out.println(dontTake);
        // System.out.println(take);
        
        return Math.max(take,dontTake);


    }
    public static void main(String[] args) {
        // int arr[] =  {2,4,1,3,4,6,2,4,1,6};        
        // int arr[] = {5,1,2,6,6,1,3,1,4,3,4,3,4,6,1,2,4,1,6,2};
        // int arr[] = {1,5,3,3,1,3};
        // int arr[] = {3,4}; 
        // int arr[] = {2, 4, 1, 3, 3, 7, 7, 3, 3, 9}; 
        int arr[] = {2, 4, 4, 3, 7, 6, 3, 9, 9, 10, 10, 13}; 
        System.out.println((arr.length/2)-recursion(arr,0,0,-1));
        
    }
}
