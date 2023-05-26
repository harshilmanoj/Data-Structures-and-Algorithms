package Cycle_Detection.Cycle_detection_for_directed_graph;
import java.util.ArrayList;

public class cycleDetectionDirectedGraph{
    //Creation of Edge class
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int s,int d,int w){
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
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 6));
        graph[5].add(new Edge(5, 3, 3));
        graph[5].add(new Edge(5, 6, 3));
    }


    //Time Complexity : O(V+E).
    public static boolean cycleDetectionDG(ArrayList<Edge> graph[],boolean visited[],boolean rstack[],int curr){

        //Identifying the node as visited and represent it as it is present in the recurssion stack.
        visited[curr] = true; 
        rstack[curr] = true;
        
        for(int i = 0;i<graph[curr].size();i++){
            Edge temp = graph[curr].get(i);
            //If present in the recursion stack then its a cycle hence returns true; 
            if(rstack[temp.dest] == true){
                return true;
            }
            //Else if check the same for neighbours
            else if(visited[temp.dest]==false){
                if(cycleDetectionDG(graph, visited, rstack, temp.dest)){
                    return true;
                }
            }

        }
        
        //The below step signifies removal of node from recursion stack.
        rstack[curr] = false;
        return false;        
    }


    public static void main(String[] Args){
       //Number of vertices.
       int v = 7;
        
       //Initialising an array of ArrayList of Edges.
       ArrayList<Edge> graph[] = new ArrayList[v];

       //Creating a boolean array to keep track if the node is visted before or not
       //This prevents cycle while traversing the node. 
       boolean visited[] = new boolean[v];

       //Creating a boolena array for recursion stack.
       //Its not like visited it just contains the element present in the recursion stack.
       boolean rstack[] = new boolean[v];
       
       /*      
               GRAPH

              1 ----- 3           
             /        |\
            /         | \
           0          |  5 ----- 6
            \         | /
             \        |/
              2 ----- 4

              Cycle 3->4->5->3

        */

       
       //Calling the function "createGraph".
       createGraph(graph);


       for(int i = 0;i<v;i++){
            if(visited[i]==false){
                boolean mark = cycleDetectionDG(graph,visited,rstack,i); 

                if(mark == true){
                    System.out.println("Cycle Detected.");
                    return;
                }
            }

        }

        System.out.println("Cycle Not Detected.");
    }
}
