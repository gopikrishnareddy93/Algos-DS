package repo.DS.Graph.UnDirected;

import java.util.*;

public class GraphTraversal {

public static class Exercise{
    static int V;
    static LinkedList<Integer> adj[];


    static void Initialize(){
        V = 4;

        adj = new LinkedList[V];

        for (int i =0;i<V;i++){
            adj[i] = new LinkedList<>();
        }

        adj[0].add(1);
        adj[0].add(2);
        adj[1].add(2);
        adj[2].add(0);
        adj[2].add(3);
        adj[3].add(3);
    }


    public static void Run(){
        Initialize();
        DFS();
        BFS();
    }


    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        queue.add(2);

        System.out.print("BFS:  ");


        while (!queue.isEmpty()){
            int currentNode = queue.remove();
            visited[currentNode] = true;

            System.out.print(currentNode + "  ");

            List<Integer> connectedNodes = adj[currentNode];

            for (int node : connectedNodes){
                if (visited[node]){
                    continue;
                }

                queue.add(node);
            }
        }

        System.out.println();

    }

    static void DFS(){
        boolean[] visited = new boolean[V];
        System.out.print("DFS:  ");
        rDFS(2, visited);
        System.out.println();
    }

    static void rDFS(int currentNode, boolean[] visited){
        visited[currentNode] = true;
        System.out.print(currentNode + "  ");

        List<Integer> connectedNodes = adj[currentNode];

        for (int node:
             connectedNodes) {

            if (visited[node]){
                continue;
            }

            rDFS(node, visited);
        }
    }





}



}
