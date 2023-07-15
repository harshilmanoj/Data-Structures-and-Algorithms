public class queueUsingStack {
    static class queue{
        int q[];
        int front;
        int rear;
        int count;

        public queue(){
            this.q = new int[1000];
            this.front = -1;
            this.rear = -1;
            this.count = 0;
        }

        public void add(int n){
            q[rear%1000]=n;
            rear++;
        }
        public int remove(){
            int x = q[front];
            front++;
            return x;
        }
        public size()

    }
    public static void main(String[] args) {
        
    }
}
