package Cycle_Detection.Cycle_detection_for_undirected_graph;

import java.util.ArrayList;

public class cycleDetectionUndirectedGraph {
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
        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 6));
        graph[4].add(new Edge(4, 2, 6));
        graph[4].add(new Edge(4, 5, 6));
        graph[5].add(new Edge(5, 3, 3));
        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));
        graph[6].add(new Edge(6, 5, 3));
    }


    //Time Complexity : O(V+E).
    public static boolean cycleDetectionUDG(ArrayList<Edge> graph[],boolean visited[],int curr,int parent){

        //Identifying the node as visited.
        visited[curr] = true; 

        for(int i = 0;i<graph[curr].size();i++){
            Edge temp = graph[curr].get(i);

            //Basicallyy using this algotithm we categorise a node into three categories : 
            // 1. A node that is visited but not is the parent then there is a cycle.
            // 2. A node that is visited and is the parent ,then that's not a cycle istead it is the predecessor of that node
            // 3. A node that is unvisited ==> for that we will be checking if the further cycle is there or not.
            if(visited[temp.dest] == true && parent!=temp.dest){
                return true;
            }
            //Else if check the same for neighbours
            else if(visited[temp.dest]==false){
                if(cycleDetectionUDG(graph, visited,temp.dest,curr)){
                    return true;
                }
            }

        }
        
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

       
       /*      
               GRAPH

              1 ----- 3           
             /        |\
            /         | \
           0          |  5 ----- 6
            \         | /
             \        |/
              2 ----- 4

              Cycle 0->1->3->5->4->2->0
              Cycle 0->1->3->4->2->0
              Cycle 3->4->5->3

        */

       
       //Calling the function "createGraph".
       createGraph(graph);

    
       for(int i = 0;i<v;i++){
            if(visited[i]==false){
                boolean mark = cycleDetectionUDG(graph,visited,i,-1); 

                if(mark == true){
                    System.out.println("Cycle Detected.");
                    return;
                }
            }

        }

        System.out.println("Cycle Not Detected.");
    }
}

