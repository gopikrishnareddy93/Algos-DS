package repo.Algos;

public class Playground {

    public static class Exercise{
        static int[][] jumps;
        static boolean[] visited;

        static void initialize(){

        }

        public static void Run(){
            initialize();
            //numberOfPatterns(4,6);



        }






        static int numberOfPatterns(int m, int n) {
            jumps = new int[10][10];
            jumps[1][3] = jumps[3][1] = 2;
            jumps[4][6] = jumps[6][4] = 5;
            jumps[7][9] = jumps[9][7] = 8;
            jumps[1][7] = jumps[7][1] = 4;
            jumps[2][8] = jumps[8][2] = jumps[1][9] = jumps[9][1] = 5;
            jumps[9][3] = jumps[3][9] = 6;
            jumps[3][7] = jumps[7][3] = 5;
            visited = new boolean[10];
            int count = 0;
            count += dfs(1, 1, 0, m, n)
                    * 4;//1,3,7,9 are symmetric, so we only need to use 1 to do it once and then multiply the result by 4
            count += dfs(2, 1, 0, m, n)
                    * 4;//2,4,6,8 are symmetric, so we only need to use 1 to do it once and then multiply the result by 4
            count += dfs(5, 1, 0, m, n);
            return count;
        }

        static int dfs(int num, int len, int count, int m, int n) {
            if (len >= m) {
                count++;
            }
            len++;
            if (len > n) {
                return count;
            }
            visited[num] = true;
            for (int next = 1; next <= 9; next++) {
                int jump = jumps[num][next];

                if (next == 6 && num == 1) {
                    System.out.println("1 -- 6");
                    System.out.println(!visited[next] && (jump == 0 || visited[jump]));
                }

                if (!visited[next] && (jump == 0 || visited[jump])) {
                    count = dfs(next, len, count, m, n);
                }


                if (next == 6 && num == 1) {
                    System.out.println("1 -- 6");
                    System.out.println(count);
                }
            }
            visited[num] = false;//backtracking
            return count;
        }
    }
}
