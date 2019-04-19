package repo.Algos;

public class PositionOfFirstSetBitToTheRight {


    public static class Example {



        public static void Run(int N){
            System.out.println(String.format("Position of rightmost set bit : %d", returnFirstSetBitPositionToTheRight(N)));
            System.out.println(String.format("Position of rightmost set bit(Efficient) : %d", efficientlyReturnFirstSetBitPositionToTheRight(N)));
        }

        static int returnFirstSetBitPositionToTheRight(int N){
            if (N == 0){
                return 0;
            }

            int pos = 0;

            while (N > 0){
                int rem = N % 2;
                pos++;

                if (rem == 1){
                    return pos;
                }

                N = N / 2;
            }

            return -1;

        }

        static int efficientlyReturnFirstSetBitPositionToTheRight(int N){
            if (N == 0){
                return 0;
            }

            int pos = 0;
            int temp = 1;

            while (N >= temp){
                int res = N & temp;
                pos++;

                if (res != 0){
                    return pos;
                }

                temp = temp << 1;
            }

            return -1;

        }



    }


}
