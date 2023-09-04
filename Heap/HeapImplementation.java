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

        

        public void maxHeapify(){

        }
        
    }
    public static void main(String args[]){

    }
}
