public class stackUsingArray {
    static class stack{
        int st[];
        int top;
        public stack(){            
            this.st= new int[100];
            this.top=-1;
        }

        public void push(int n){
            top++;
            st[top]=n;
        }
        
        public int pop(){
            int x = st[top];
            top--;
            return x;
        }

        public int peek(){
            return st[top];
        }

        public int size(){
            return top+1;
        }

        public boolean isEmpty(){
            return top==-1?true:false;
        }

        public void print(){
            for(int i = 0;i<=top;i++){
                System.out.print(st[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        stack st = new stack();

        st.push(1);
        st.push(6);
        st.push(4);
        st.push(3);
        st.push(2);
        st.print();
        System.out.println(st.pop());
        System.out.println(st.size());
        System.out.println(st.peek());
        st.print();
    }
}
