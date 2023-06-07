import java.util.ArrayList;
import java.util.Stack;

public class kosarajusAlgorithm{    
    //Creation of Edge class
    static class Edge{
        int src;
        int dest;
        int weight;
        
        //Constructor
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

    public static void topologicalSort(ArrayList<Edge> graph[],boolean visited[],int curr,Stack<Integer> st){
        visited[curr]= true;
        for(int i = 0;i<graph[curr].size();i++){
            if(visited[graph[curr].get(i).dest]==false){
                topologicalSort(graph, visited, graph[curr].get(i).dest,st);

            }
        } 

        st.push(curr);
    }

    public static void kosarajusAlgo(ArrayList<Edge> graph[]){
        Stack<Integer> st = new Stack<Integer>();
        boolean visited[] = new boolean[graph.length];

        for(int i = 0;i<graph.length;i++){
            if(visited[i]==false){
                topologicalSort(graph,visited,i,st);
            }
        }
        
        ArrayList<Edge> transposeGraph[] = new ArrayList[graph.length];
        for(int i =0;i<graph.length;i++){
            transposeGraph[i] = new ArrayList<Edge>();
        }

        for(int i = 0;i<graph.length;i++){
            for(int j = 0;j<graph[i].size();j++){
                
            }
        }
    }
    public static void main(String[] args) {
        //Number of vertices.
        int v = 7;
        
        //Initialising an array of ArrayList of Edges.
        ArrayList<Edge> graph[] = new ArrayList[v];
        
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
       

    }
}
