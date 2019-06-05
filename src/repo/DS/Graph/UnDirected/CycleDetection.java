package repo.DS.Graph.UnDirected;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {

    public static class Exercise{
        static int V;
        static LinkedList[] adj;

        static void Initialize(){
            V = 4;

            adj = new LinkedList[V];

            for (int i =0;i<V;i++){
                adj[i] = new LinkedList<>();
            }

            adj[0].add(1);
            adj[0].add(2);
           // adj[1].add(2);
            adj[2].add(0);
            adj[2].add(3);
            //adj[3].add(3);
        }

        public static void Run(){
            Initialize();
            DetectCyleBFS();
            DetectCycleDFS();
        }

        static void DetectCyleBFS(){
            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(2);

            while (!queue.isEmpty()){
                int currentNode = queue.remove();
                visited[currentNode] = true;
                List<Integer> connectedNodes = adj[currentNode];

                for (int node:
                     connectedNodes) {

                    if (visited[node]){
                        System.out.println("BFS: Cycle Detected");
                        return;
                    }

                    queue.add(node);
                }
            }

            System.out.println("BFS: No cycle detected");




        }


        static void DetectCycleDFS(){
            boolean[] visited = new boolean[V];
            boolean[] nodesInCycle = new boolean[V];


            for (int i=0;i<V;i++){
                if (rDFS(i, visited, nodesInCycle)){
                 System.out.println("DFS: Cycle detected in the graph");
                 return;
                }
            }

            System.out.println("DFS: No Cycle in the Graph");

        }


        static boolean rDFS(int currentNode, boolean[] visited, boolean[] nodesInCycle){

            if (nodesInCycle[currentNode]){
                return true;
            }

            if (visited[currentNode]){
                return false;
            }

            visited[currentNode] = true;
            nodesInCycle[currentNode] = true;

            List<Integer> connectedNodes = adj[currentNode];

            for (int node:
                 connectedNodes) {
                if (rDFS(node, visited, nodesInCycle)){
                    return true;
                }
            }

            nodesInCycle[currentNode] = false;

            return false;
        }




    }

}
