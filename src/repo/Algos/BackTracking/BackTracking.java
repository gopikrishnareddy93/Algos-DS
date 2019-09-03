package repo.Algos.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackTracking {
    public static class Exercise{
        static int[] array = new int[]{
                1,2,3,4
        };

        public static void Run(){
            //generateAllCombinations();
            generateAllPermutations();
        }

        static void generateAllCombinations(){
            List<List<Integer>> result = new ArrayList<>();
            rGenerateCombinations(new ArrayList<>(), 0, result);
            print(result);
        }

        static void rGenerateCombinations(List<Integer> tempArray, int start, List<List<Integer>> result){
            if (start > array.length){
                return;
            }

            result.add(new ArrayList<>(tempArray));

            for (int i = start; i< array.length;i++){
                tempArray.add(array[i]);
                rGenerateCombinations(tempArray, i + 1, result);
                tempArray.remove(tempArray.size() - 1);
            }
        }


        static void generateAllPermutations(){
            List<List<Integer>> result = new ArrayList<>();
            HashMap<Integer, Boolean> used = new HashMap<>();
            rGeneratePermutations(new ArrayList<>(), result, used);
            print(result);
        }

        static void rGeneratePermutations(List<Integer> tempArray, List<List<Integer>> result, HashMap<Integer, Boolean> used){
            result.add(new ArrayList<>(tempArray));

            if (tempArray.size() >= array.length){
                return;
            }

            for (int i = 0; i< array.length; i++){
                if (used.containsKey(i) && used.get(i)){
                    continue;
                }

                used.put(i,true);
                tempArray.add(array[i]);
                rGeneratePermutations(tempArray, result, used);
                tempArray.remove(tempArray.size() - 1);
                used.put(i,false);
            }


        }

        static void print(List<List<Integer>> result){
            for (List<Integer> list:
                 result) {
                for (int num:
                     list) {
                    System.out.print(num + "  ");
                }

                System.out.println();
            }
        }
    }

}
