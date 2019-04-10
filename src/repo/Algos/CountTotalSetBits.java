package repo.Algos;

public class CountTotalSetBits {

    public static class Exercise{


        public static void Run(int n){

            int count = 0;

            for (int i=1; i <= n; i++){
                int j=i;
                while (j > 0){
                    if (j%2 == 1){
                        count++;
                    }
                    j=j/2;
                }
            }

            System.out.println("Number of set bits : " + count);
        }

    }

}
