import java.util.ArrayList;
public class bellmanFordsAlgorithm {
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
        graph[0].add(new Edge(0, 1, -2));
        graph[0].add(new Edge(0, 2, 3));
        graph[1].add(new Edge(1, 3, -3));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 5, -1));
        graph[4].add(new Edge(4, 5, 6));
        graph[5].add(new Edge(5, 6, -3));
    }

    

    //BellmanFord's Function 
    //Time Compexity : O(EV))
    public static void bellmanFords(ArrayList<Edge> graph[],int src,int v){
        int dist[] = new int[graph.length];
        //Creating a distance array with max value except the source node.
        for(int i = 0;i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //Loop 1 : V-1 times, that is for all node. 
        for(int i = 0;i<v-1;i++){
            //Loop 2 : All the edges. 
            for(int j = 0; j<v;j++){
                for(int k = 0;k<graph[j].size();k++){
                    Edge e = graph[j].get(k);
                    if((dist[e.src] != Integer.MAX_VALUE) && (dist[e.src]+(e.weight)<dist[e.dest])) {
                        dist[e.dest] = dist[e.src]+e.weight;
                    }
                }
            }
        }

        //Printing the distance from src to all nodes
        System.out.println("Distance from src : ");
        for(int i = 0;i<dist.length;i++){
            System.out.println(i + " : " + dist[i]);
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

        bellmanFords(graph, 0,v);

    }
}


