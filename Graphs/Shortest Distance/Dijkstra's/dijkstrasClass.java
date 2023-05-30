import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstrasClass {
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

    //Creation of Pair Class
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }

    }

    //Dijkstra's Function 
    //Time Compexity : O(E+Elog(V))
    public static void dijkstas(ArrayList<Edge> graph[],int src){
        boolean visited[] = new boolean[graph.length];
        int dist[] = new int[graph.length];

        for(int i = 0;i<graph.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(visited[p.node]==false){
                visited[p.node] = true;
                for(int i = 0;i<graph[p.node].size();i++){
                    Edge e = graph[p.node].get(i);
                    //Relaxation
                    if(dist[e.dest]>dist[e.src]+e.weight){
                        dist[e.dest]=dist[e.src]+e.weight;
                        pq.add(new Pair(e.dest,dist[e.dest]));
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

       dijkstas(graph, 0);

    }
}
