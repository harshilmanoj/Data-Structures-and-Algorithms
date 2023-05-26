package Traversal.All_path_from_Source_to_Target;

import java.util.*;

public class allPathsFromSrcToTarget {
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

    //Time Complexity : O(V^V)
    //Recursive : Worst case when a vertex is visited V times.
    public static void allPaths(ArrayList<Edge> graph[],boolean visited[],int curr,String path,int tar){

        //If the current node is target node print the path and return; 
        if(tar == curr){
            System.out.println(path);
            return;
        }

        //First we loop through all the neighbours and find if a possible path is there or not.
        //For that before applying dfs to neighbour we make the node visited and unvisit it after dfs call.
        //This is because if we don't unvisit the node it will act as a barrier for other paths.
        for(int i = 0;i<graph[curr].size();i++){
            if(visited[graph[curr].get(i).dest]==false){
                visited[curr] = true;
                allPaths(graph, visited, graph[curr].get(i).dest, path+graph[curr].get(i).dest,tar);
                visited[curr] = false;
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
        System.out.println("All Paths : ");
        int src = 0;
        int tar = 6;
        String path = "0";
        allPaths(graph, visited, src, path, tar);        
    }
}


