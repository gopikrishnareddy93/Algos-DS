package repo.DS.Graph.Directed;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {

    public static class Exercise{
        static int V;
        static LinkedList[] adj;


        static void Initialize(){
            V = 6;

            adj = new LinkedList[V];

            for (int i =0;i<V;i++){
                adj[i] = new LinkedList<>();
            }

            adj[5].add(2);
            adj[5].add(0);
            adj[4].add(0);
            adj[4].add(1);
            adj[2].add(3);
            adj[3].add(1);
        }

        public static void Run(){
            Initialize();
            TopologicalSort();

        }

        static void TopologicalSort(){
            Stack stack = new Stack();
            boolean[] visited = new boolean[V];

            for (int i = 0; i<V;i++){
                if (!visited[i]){
                    rDFS(i, visited, stack);
                }
            }

            while (!stack.isEmpty()){
                System.out.print(stack.pop() + "  ");
            }

        }

        static void rDFS(int currentNode, boolean[] visited, Stack stack){
            visited[currentNode] = true;

            List<Integer> connectedNodes = adj[currentNode];

            for (int node: connectedNodes){
                if (visited[node]){
                    continue;
                }

                rDFS(node, visited, stack);
            }

            stack.push(currentNode);
        }

    }

}
