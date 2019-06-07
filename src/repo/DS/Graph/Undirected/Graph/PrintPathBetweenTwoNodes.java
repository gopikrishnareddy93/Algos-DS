package repo.DS.Graph.Undirected.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class PrintPathBetweenTwoNodes {

    public static class Exercise{

        static List<List<Integer>> graph;
        static int src, dst;
        static Stack<Integer> result;
        static HashSet<Integer> visited;

        static void Initialize(){
            graph = new ArrayList<>();

            List<Integer> adjList1 = new ArrayList<>();
            adjList1.add(1);
            adjList1.add(2);
            adjList1.add(3);

            graph.add(adjList1);

            List<Integer> adjList2 = new ArrayList<>();
            adjList2.add(0);

            graph.add(adjList2);

            List<Integer> adjList3 = new ArrayList<>();
            adjList3.add(0);

            graph.add(adjList3);

            List<Integer> adjList4 = new ArrayList<>();
            adjList4.add(0);

            graph.add(adjList4);

            src = 1;
            dst = 3;

            visited = new HashSet<>();

            result = new Stack<>();
        }

        public static void Run(){
            Initialize();
            PrintPath();
        }


        static void PrintPath(){

            boolean found = rfind(src);

            if (found){
                while (!result.isEmpty()) {
                    System.out.print(result.pop() + "\t");
                }

                System.out.print(src + "\t");
            }else {
                System.out.println("Nodes are disconnected");
            }
        }

        static boolean rfind(int node){

            if (visited.contains(node)){
                return false;
            }

            visited.add(node);

            if (node == dst){
                return true;
            }

            List<Integer> adjList = graph.get(node);

            for (int tmp:
                 adjList) {

                result.push(tmp);

                boolean tmpResult = rfind(tmp);

                if (tmpResult){
                    return tmpResult;
                }

                result.pop();
            }

            return false;
        }
    }

}
