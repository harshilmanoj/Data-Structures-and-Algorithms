package Traversal.Depth_First_Search;
import java.util.*;

public class depthFirstSearch {
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

    //Time Complexity : O(E+V)
    //Recursive dfs function.
    public static void dfs(ArrayList<Edge> graph[],boolean visited[],int curr){
        //Three steps to be followed are : 
        // 1. Print the node.
        // 2. Mark the node as visited.
        // 3. Visit all the first neighbour from that particular node.
        System.out.println(curr);
        visited[curr] = true;
        for(int i = 0;i<graph[curr].size();i++){
            if(visited[graph[curr].get(i).dest]==false){
                dfs(graph,visited, graph[curr].get(i).dest);
            } 
        }
    }
    public static void main(String[] args) {
        //Number of vertices.
        int v = 7;
        
        //Initialising an array of ArrayList of Edges.
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
            //Calling dfs function if the node is not visited before.
            if(visited[i]==false){
                dfs(graph,visited,i);
            }
        }
    }
}
