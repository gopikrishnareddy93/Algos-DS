package repo.DS.Matrix;

public class SpiralMatrix {

    public static class Exercise{
        static int[][] input;
        static int N;

        static void initialize(){
            N = 4;
            input = new int[N][N];
            int temp =0;
            for (int i =0; i< N;i++){
                for (int j =0;j < N; j++){
                    input[i][j] = temp++;
                }
            }
        }

        public static void Run(){
            initialize();
            startSpiralling();
        }

        static void startSpiralling(){
            int rowBegin = 0;
            int colBegin = 0;

            int rowEnd = N - 1;
            int colEnd = N - 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd){

                //move left to right

                for (int j = colBegin; j<= colEnd; j++){
                    System.out.print(input[rowBegin][j] + "\t");
                }

                rowBegin++;

                //move up to down

                for (int i = rowBegin; i<= rowEnd; i++){
                    System.out.print(input[i][colEnd] + "\t");
                }

                colEnd--;

                // move right to left

                if (rowBegin <= rowEnd){
                    for (int j=colEnd; j >= colBegin; j--){
                        System.out.print(input[rowEnd][j] + "\t");
                    }

                    rowEnd--;
                }


                // move down to up

                if (colBegin <= colEnd){

                    for (int i = rowEnd; i>= rowBegin; i--){
                        System.out.print(input[i][colBegin] + "\t");
                    }

                    colBegin++;
                }
            }


        }
    }

}
