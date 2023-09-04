package Heap;
public class HeapImplementation {
    class Heap{
        int maxHeapSize;
        int arr[];
        int currHeapSize;

        public Heap(int maxHeapSize){
            this.maxHeapSize = maxHeapSize;
            arr= new int[maxHeapSize];
            currHeapSize = 0;  
        }

        public int parent(int i){
            return (i-1)/2;
        }
        public int leftChild(int i){
            return 2*i+1;
        }
        public int rightChild(int i){
            return 2*i+2;
        }

        public boolean isLeaf(int i){
            return (i>currHeapSize/2 && i<=currHeapSize)?true : false;
        }

        public void swap(int i, int j){
            int temp = arr[i];
            arr[i] =  arr[j];
            arr[j] = temp;
        }

        public void maxHeapify(int i){
            if(isLeaf(i)){
                return ;
            }
            int lc = leftChild(i);
            int rc = rightChild(i);

            if(arr[i]<arr[lc] || arr[i]<arr[rc]){
                if(lc>rc){
                    swap(i,lc);
                    maxHeapify(lc);
                }
                else{
                    swap(i,rc);
                    maxHeapify(rc);

                }
            }
        }


        public void insert(int val){

        }
        
    }
    public static void main(String args[]){

    }
}
