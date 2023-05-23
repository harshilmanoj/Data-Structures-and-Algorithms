package Traversal.Breadth_First_Search;
import java.lang.reflect.Array;
import java.util.*;



public class breadthFirstSearch {

    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight  = w;            
        }

    }

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

    //Time Complexity : O(E+V)
    public static void bfs(ArrayList<Edge> graph[],int v,boolean visited[],int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);      

        while(!q.isEmpty()){
            int curr = q.remove();
            //It will visit the node if and only if the node is not visited before.
            //This is to prevent cycles while traversing.
            if( visited[curr] == false){
                //Three Steps for bfs :
                // 1. Print the node
                // 2. Mark the node as visited.
                // 3. Add the neighbours of that node to the queue.
                System.out.println(curr);
                visited[curr] = true;
                for(int i =0;i<graph[curr].size();i++){
                    q.add(graph[curr].get(i).dest);
                }

            }
        } 
    }
    public static void main(String[] args) {
        int v = 7;
        //Initialising the Fraph using an Array of ArrayList Of Edge Object.
        ArrayList<Edge> graph[] = new ArrayList[v];
        //Creating a boolean array to keep track if the node is visted before or not
        //This prevents cycle while traversing the node. 
        boolean visited[] = new boolean[v];

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
        System.out.println("Graph Traversal : ");
        for(int i = 0;i<v;i++){
            //Calling bfs function if the node is not visited before.
            if(visited[i] == false){
                bfs(graph,v,visited,i);
            }
        }
    }
}
