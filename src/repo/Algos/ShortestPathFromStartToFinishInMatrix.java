package repo.Algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathFromStartToFinishInMatrix {
    public static class Exercise{
        static char[][] matrix;

        static void Initialize(){
            matrix = new char[][] { new char[] {'1', '1', '1', '1', '1'},
                    new char[] {'S', '1', 'X', '1', '1'},
                    new char[] {'1', '1', '1', '1', '1'},
                    new char[] {'X', '1', '1', 'E', '1'},
                    new char[] {'1', '1', '1', '1', 'X'} };
        }

        public static void Run(){
            Initialize();
            FindShortestPath(matrix, 5, 5, new Point(1, 0), new Point(3, 3));

        }

        static List<Point> FindShortestPath(char[][] matrix, int rows, int cols, Point s, Point e) {
            boolean[][] visited = new boolean[rows][cols];
            Point[][] parent = new Point[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                {
                    visited[i][j] = false;
                    parent[i][j] = null;
                }

            List<Point> path = new ArrayList<>();
            int pathLength = Integer.MAX_VALUE;
            Queue q = new LinkedList<Point>();
            q.add(s);
            while (q.size() != 0)
            {
                Point curr = (Point) q.remove();
                visited[curr.x][curr.y] = true;
                //Console.Write("({0}, {1}) ", curr.x, curr.y);

                if (curr.x == e.x && curr.y == e.y)
                {
                    List<Point> currPath = new ArrayList<>();
                    while (parent[curr.x][curr.y] != s)
                    {
                        curr = parent[curr.x][curr.y];
                        currPath.add(curr);
                        System.out.println(String.format("(%s, %s) ", curr.x, curr.y));
                    }
                    System.out.println();
                    if (currPath.size() < pathLength)
                    {
                        //path.clear();
                        //path.addAll(currPath);
                    }
                    break;
                }

                // right
                if (curr.y + 1 < cols && matrix[curr.x][curr.y + 1] != 'X' && !visited[curr.x][ curr.y + 1])
                {
                    q.add(new Point(curr.x, curr.y + 1));
                    parent[curr.x][curr.y + 1] = curr;
                }
                // left
                if (curr.y - 1 >= 0 && matrix[curr.x][curr.y - 1] != 'X' && !visited[curr.x][ curr.y - 1])
                {
                    q.add(new Point(curr.x, curr.y - 1));
                    parent[curr.x][curr.y - 1] = curr;
                }
                // up
                if (curr.x - 1 >= 0 && matrix[curr.x - 1][curr.y] != 'X' && !visited[curr.x - 1][ curr.y])
                {
                    q.add(new Point(curr.x - 1, curr.y));
                    parent[curr.x - 1][curr.y] = curr;
                }

                //down
                if (curr.x + 1 < rows && matrix[curr.x + 1][curr.y] != 'X' && !visited[curr.x + 1][ curr.y])
                {
                    q.add(new Point(curr.x + 1, curr.y));
                    parent[curr.x + 1][curr.y] = curr;
                }
            }

            return path;
        }



    }

    public static class Point
    {
        public int x;
        public int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
