import java.util.ArrayList;
import java.util.PriorityQueue;


public class primsAlgorithm{    
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

    //Pair class
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    //Mstprims Function
    //Here we would be using the concept of mst set.
    //Time Complexity : O(ElogE)
    public static void mstprims(ArrayList<Edge> graph[]){
        //Similar to bfs we would be using a priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        //This boolean array keeps track of the visited nodes as well as mst set.
        boolean visited[] = new boolean[graph.length];
        int mstCost = 0;
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(visited[p.node]==false){
                visited[p.node]=true;
                mstCost += p.cost;
                for(int i =0;i<graph[p.node].size();i++){
                    Edge e = graph[p.node].get(i);
                    //Visiting the node that is not in the mst set.
                    if(visited[e.dest]==false){
                        pq.add(new Pair(e.dest,e.weight));
                    }
                }
            }

        }


        System.out.println("The total cost of the minimum spanning tree : " + mstCost);
    
    
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
       
        mstprims(graph);

    }
}
