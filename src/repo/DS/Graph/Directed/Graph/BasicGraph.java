package repo.DS.Graph.Directed.Graph;


import java.util.*;

// Useful links :
// 1. BFS : https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

public class BasicGraph {
    public static class Example{
        // N is for number of nodes in the Graph
        static int n = 4;

        static LinkedList<Integer> adjList[];

        static void Initialize(){
            adjList = new LinkedList[n];
            for (int i = 0; i < n; i++){
                adjList[i] = new LinkedList<>();
            }

            AddEdge(0,1);
            AddEdge(0,2);
            AddEdge(1,2);
            AddEdge(2,0);
            AddEdge(2,3);
            AddEdge(3,3);
        }

        static void AddEdge(int from, int to){
            adjList[from].add(to);
        }

        public static void Run(){
            Initialize();
            PrintGraph(Direction.BFS);
            PrintGraph(Direction.DFS);
        }

        static void PrintGraph(Direction direction){
            System.out.print(direction + " :\t");
            switch (direction){
                case BFS:
                    PrintBFS(2);
                    break;
                case DFS:
                    PrintDFS(2);
                    break;
            }

            System.out.println();
        }

        static void PrintBFS(int start){
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> YetToVisit = new LinkedList<Integer>();
            YetToVisit.add(start);

            while (YetToVisit.size() != 0){
                int currentNode = YetToVisit.remove();

                if (visited.contains(currentNode)){ continue;}
                visited.add(currentNode);
                System.out.print(currentNode + "\t");

                for (int node: adjList[currentNode]) {
                    if (visited.contains(node)){ continue;}
                    YetToVisit.add(node);
                }
            }
        }

        // stack to keep track of nodes being visited
        // Queue is to keep track of other unvisited nodes at the same level

        static void PrintDFS(int start){
            Set<Integer> visited = new HashSet<>();
            Stack<Integer> CurrentNodesBeingVisited = new Stack<>();
            Queue<Integer> YetToVisitNodes = new LinkedList<>();

            CurrentNodesBeingVisited.push(start);

            while (!CurrentNodesBeingVisited.empty()){
                int currentNode = CurrentNodesBeingVisited.pop();

                if (visited.contains(currentNode)){ continue;}
                visited.add(currentNode);
                System.out.print(currentNode + "\t");

                boolean foundFirstUnvisitedNode = false;

                for (int node : adjList[currentNode]) {
                    if (visited.contains(node)){ continue; }

                    if (!foundFirstUnvisitedNode){
                        CurrentNodesBeingVisited.push(node);
                        foundFirstUnvisitedNode = true;
                    }
                    else
                    {
                     YetToVisitNodes.add(node);
                    }
                }

                if (CurrentNodesBeingVisited.empty()){
                    if (!YetToVisitNodes.isEmpty()){
                        CurrentNodesBeingVisited.push(YetToVisitNodes.remove());
                    }

                }

            }

        }




    }

enum Direction {
    BFS,
    DFS
}

}
