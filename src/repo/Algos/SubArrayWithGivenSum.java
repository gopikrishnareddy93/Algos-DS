package repo.Algos;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {
    public static class Exercise{

        static int arrayLength;

        static int[] array;

        static int targetSum;


        public static void Initialize()
        {
            arrayLength = 10;
            array = new int[]{1, 2, 3, 4, 5,6,7,8,9,10};
            targetSum = 15;
        }

        public static void Run(){
            Initialize();
            BruteForceAppraoch();

        }

        public static void BruteForceAppraoch(){

            // slidingWindowLength is for various lengths
            for (int slidingWindowLength=1; slidingWindowLength < arrayLength; slidingWindowLength++){

                // upperbound is used a sliding window of length i
                for (int upperbound=slidingWindowLength,lowerbound = 0; upperbound < arrayLength && lowerbound < upperbound; upperbound++, lowerbound++){
                    int sum = 0;
                    List<Integer> arrayList = new ArrayList<>() ;
                    // compute sum in each window
                    for (int i = lowerbound; i < upperbound; i++ ){
                        sum = sum + array[i];
                        arrayList.add(array[i]);
                    }

                    if (sum == targetSum){
                        System.out.println("Target sum found: lowerbound = " + (lowerbound + 1) + " upper bound = " + upperbound);
                        for (int num:
                             arrayList) {
                            System.out.print(num + "\t");
                        }

                        return;
                    }


                }

            }
        }

    }


}
