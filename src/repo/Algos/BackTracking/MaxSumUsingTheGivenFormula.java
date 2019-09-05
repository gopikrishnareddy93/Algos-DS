package repo.Algos.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumUsingTheGivenFormula {
    public static class Exercise{
        //        static int[] array = new int[]{1,2,3,4,-5,6,7};
        static int[] array = new int[]{1,2,-3, 4, 5};
        static int length = array.length;


        public static void Run(){
            printMaxSumOfTheArrayAfterDivingArrayUsingTheFollowingCriteria();
        }

        private static void printMaxSumOfTheArrayAfterDivingArrayUsingTheFollowingCriteria(){
            int max = Integer.MIN_VALUE;
            int[] sumArray = new int[length];
            sumArray[0] = array[0];

            for (int i = 1; i < length; i++){
                sumArray[i] = sumArray[i - 1] + array[i];
            }

            List<List<List<Integer>>> result = new ArrayList<>();
            List<List<Integer>> tempArray = new ArrayList<>();

            rHelper(tempArray, 0, result);

            for (List<List<Integer>> listArray:result) {
                boolean sign = true;
                int tempSum = 0;

                for (List<Integer> list:listArray) {
                    if (sign){
                        tempSum += Sum(list);
                    }
                    else {
                        tempSum -= Sum(list);
                    }

                    sign = !sign;
                }
                max = Math.max(max, tempSum);
            }

            System.out.println(String.format("Max Sum = %d", max));
        }

        private static void rHelper(List<List<Integer>> ta, int ci, List<List<List<Integer>>> result){


            if (ci >= length){
                List<List<Integer>> newTa1 = new ArrayList<>(ta);
                result.add(newTa1);
                return;
            }

            if (ta.size() == 4){
                List<List<Integer>> newTa1 = new ArrayList<>(ta);

                List lastItem = newTa1.remove(newTa1.size() - 1);

                for (int i = ci; i < length; i++){
                    lastItem.add(array[i]);
                }

                newTa1.add(lastItem);

                result.add(newTa1);
                return;
            }

            List<List<Integer>> newTa0 = DeepClone(ta);
            newTa0.add(new ArrayList<>());
            rHelper(newTa0, ci, result);

            List<List<Integer>> newTa1 = DeepClone(ta);
            newTa1.add(new ArrayList<>());
            newTa1.get(newTa1.size() - 1).add(array[ci]);
            rHelper(newTa1, ci + 1, result);

            List<List<Integer>> newTa2 = DeepClone(ta);
            if (newTa2.size() == 0){
                newTa2.add(new ArrayList<>());
            }
            newTa2.get(newTa2.size() - 1).add(array[ci]);
            rHelper(newTa2, ci + 1, result);
        }

        private static List<List<Integer>> DeepClone(List<List<Integer>> inputArray){
            List<List<Integer>> outputArray = new ArrayList<>();

            if (inputArray.size() == 0){
                return new ArrayList<>();
            }

            for (List list:
                    inputArray) {
                outputArray.add(new ArrayList<>(list));
            }

            return outputArray;
        }

        private static int Sum(List<Integer> list){
            int sum = 0;
            for (int num:
                    list) {
                sum += num;
            }

            return sum;
        }
    }

}
