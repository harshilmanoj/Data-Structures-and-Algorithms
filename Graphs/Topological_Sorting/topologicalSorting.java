package Topological_Sorting;
import java.util.*;


public class topologicalSorting {
    //Creation of Edge class
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    //Function responsible for Graph creation.
    public static void createGraph(ArrayList<Edge> graph[]){

        //At the beginning the array is intialised by null value. 
        //But by this for loop we initialise it by empty array.
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<Edge>();
        }
        

        //Adding edges to each and every node.
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 3));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 6));
        graph[5].add(new Edge(5, 6, 3));
    }

    //Time Complexity : O(V+E)
    public static void topologicalSort(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer> st){
        
        //Making the node Visited.
        visited[curr] = true;

        // We loop over the neighbours of the current node and get nodes depended on that neghouring nodes
        for(int i = 0;i<graph[curr].size();i++){
            if(visited[graph[curr].get(i).dest]==false){
                topologicalSort(graph, visited, graph[curr].get(i).dest,st);
            } 
        }

        //After all the dependent nodes have been added, adding the current node to the stack.
        st.push(curr);
    }
    public static void main(String[] args) {
        //Number of vertices.
        int v = 7;
        
        //Initialising an array of ArrayList of Edges.
        ArrayList<Edge> graph[] = new ArrayList[v];

        //Creating a boolean array to keep track if the node is visted before or not
        //This prevents cycle while traversing the node. 
        boolean visited[] = new boolean[v];

        Stack<Integer> st = new Stack<Integer>();
        
        /*      
                GRAPH

               1 ----- 3           
              /         \
             /           \
            0             5 ----- 6
             \           /
              \         /
               2 ----- 4


         */

        
        //Calling the function "createGraph".
        createGraph(graph);

        //If discontinous graphs are there then multiple start point is required 
        for(int i = 0;i<v;i++){
            if(!visited[i]){
                topologicalSort(graph, visited, i, st);
            }
        }
        
        //Printing the elements in topological order.
        System.out.println("Topological Sort :  ");
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }

    }
}
