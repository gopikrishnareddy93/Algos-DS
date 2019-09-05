package repo.Algos;

import java.util.Arrays;
import java.util.TreeSet;

// https://www.programcreek.com/2016/08/maximum-sum-of-subarray-close-to-k/

public class FindPairOfNumbersWhoseSumIsClosestToTargetSumInUnSortedArray {
    public static class Example{
        static int[] list;
        static int targetSum;

        static void Initialize(){
            list = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            targetSum = 16;
        }

        public static void Run(){
            Initialize();
//            RegularApproach();
            //EfficientApproachUsingSorting();
            EfficientApproachUsingSorting();
        }

        static void RegularApproach(){
            String pair = new String();
            int maxSum = Integer.MIN_VALUE;
            for (int i =0 ; i< list.length; i++){
                for (int j = i+1 ; j < list.length; j++){
                    int tempSum = list[i] + list[j];
                    if ( tempSum <= targetSum && tempSum > maxSum){
                        pair = "[" + list[i] + ", " + list[j] + "]";
                    }
                }
            }

            System.out.println(pair);
        }

        static void EfficientApproachUsingSorting(){
            int l = 0, r = list.length-1;
            String pair = new String();
            int maxSum = Integer.MIN_VALUE;
            Arrays.sort(list);

            while (l < r){
                int tempSum = list[l] + list[r];
                if (tempSum <= targetSum)
                {
                    if (maxSum < tempSum){
                        pair = "[" + list[l] + ", " + list[r] + "]";
                    }

                    l++;
                }

                // Move to smaller value
                else
                    r--;
            }


            System.out.println(pair);
        }

        static void EfficientApproachUsingTreeSet(){

            String pair = new String();
            TreeSet<Integer> set = new TreeSet<>();
            int result = Integer.MIN_VALUE;

            set.add(0);

            for (int i =0; i< list.length;i++){

                Integer ceiling = set.ceiling(targetSum - list[i]);

                if (ceiling != null && result < ceiling){
                    result = ceiling;
                    pair = "[" + list[i] + ", " + ceiling + "]";
                }

                set.add(list[i]);
            }


            System.out.println(pair);
        }
    }

}
