package repo.Algos;

import repo.DS.LinkedList.AddTwoNumbersLinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static class Exercise{

        static int[][] map = new int[][]{
                new int[] {1, 1, 1, 1, 0},
                new int[] {1, 1, 0, 1, 0},
                new int[] {1, 1, 0, 0, 0},
                new int[] {0, 0, 0, 1, 0},
        };

        static int rows = 4;
        static int columns = 5;

        static HashMap<Point, Boolean> visitedNodes = new HashMap<Point, Boolean>();

        public static void Run(){
            CountNumberOfIslands();
        }

        static void CountNumberOfIslands(){

            // count of islands
            // Do a BFS and mark all nodes visited
            // move from (0,0) to end


            int count = 0;

            for (int i = 0; i < rows ; i++){
                for (int j = 0; j < columns; j++){
                    if (visitedNodes.containsKey(new Point(i,j)) || map[i][j] == 0){
                        continue;
                    }

                    count++;
                    DoBFS(new Point(i,j));
                }
            }

            System.out.println("Number of Islands : " + count);
        }

        static void DoBFS(Point point){
            if (point == null){
                return;
            }

            if (map[point.X][point.Y] == 0){
                return;
            }

            Queue<Point> NodesYetToVisist = new LinkedList<>() ;
            NodesYetToVisist.offer(point);
            while (!NodesYetToVisist.isEmpty()){
                Point currentPoint = NodesYetToVisist.poll();

                //check if the current node is visited
                if (visitedNodes.containsKey(currentPoint)){
                    continue;
                }

                //check left
                if (currentPoint.X >= 0 && currentPoint.Y - 1 >= 0 && map[currentPoint.X][currentPoint.Y - 1] == 1  && !visitedNodes.containsKey(new Point(currentPoint.X,currentPoint.Y-1))){
                    NodesYetToVisist.offer(new Point(currentPoint.X, currentPoint.Y-1));
                }

                // check right
                if (currentPoint.X >= 0 && currentPoint.Y + 1 < columns && map[currentPoint.X][currentPoint.Y + 1] == 1 && !visitedNodes.containsKey(new Point(currentPoint.X,currentPoint.Y+1))){
                    NodesYetToVisist.offer(new Point(currentPoint.X, currentPoint.Y+1));
                }

                // check top
                if (currentPoint.X - 1 >= 0 && currentPoint.Y >= 0 && map[currentPoint.X - 1][currentPoint.Y] == 1 && !visitedNodes.containsKey(new Point(currentPoint.X - 1,currentPoint.Y))){
                    NodesYetToVisist.offer(new Point(currentPoint.X - 1, currentPoint.Y));
                }

                //check bottom
                if (currentPoint.X + 1 < rows && currentPoint.Y >= 0 && map[currentPoint.X + 1][currentPoint.Y] == 1 && !visitedNodes.containsKey(new Point(currentPoint.X + 1,currentPoint.Y))){
                    NodesYetToVisist.offer(new Point(currentPoint.X + 1, currentPoint.Y));
                }

                visitedNodes.put(currentPoint, true);
            }


        }


    }

    public static class Point{
        public int X;
        public int Y;

        public Point(int x, int y){
            this.X = x;
            this.Y = y;
        }

        @Override
        public int hashCode() {
            return this.X*11+this.Y*17;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            Point P = (Point) obj;

            if (P == null) {
                return false;
            }

            return this.X == P.X && this.Y == P.Y;
        }

    }
}
