package repo.Algos;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Hint use hash map solution

public class FindPairOfNumbersWhoseSumIsEqualToTargetSum {

    public static class Example{

        static int[] list;
        static int targetSum;

        static void Initialize(){
            list = new int[]{7, 0, -4, 5, 2, 3};
            targetSum = 5;
        }

        public static void Run(){
            Initialize();
//            RegularApproach();
            GreedyApproach();
        }

        static void RegularApproach(){
            for (int i =0 ; i< list.length; i++){
                for (int j = i+1 ; j < list.length; j++){
                    if (list[i] + list[j] == targetSum){
                        System.out.println("[" + list[i] + ", " + list[j] + "]");
                    }
                }
            }
        }

        static void GreedyApproach(){
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i=0; i < list.length; i++){
                if (map.containsKey(list[i])){
                    System.out.println("[" + list[i] + ", " + map.get(list[i]) + "]");
                }else {
                    map.put(targetSum - list[i], list[i]);
                }
            }

        }

    }

}
