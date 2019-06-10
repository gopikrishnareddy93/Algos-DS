package repo.Algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ListDiffarence {

    public static class Exercise{
        static List<Character> list1;
        static List<Character> list2;
        static List<List<Character>> result;

        static void Initialize(){
            list1 = new ArrayList<>();
            list1.add('a');
            list1.add('a');
            list1.add('b');
            list1.add('c');

            list2 = new ArrayList<>();
            list2.add('a');
            list2.add('b');
            list2.add('b');
            list2.add('d');

            result = new ArrayList<>();
        }

        public static void Run(){
            Initialize();
            calculateDifference();
        }

        static void calculateDifference(){
            HashMap<Character, Integer> list1Map = new HashMap<>();
            HashMap<Character, Integer> list2Map = new HashMap<>();

            for (Character ch:
                 list1) {
                if (list1Map.containsKey(ch)){
                    int value = list1Map.get(ch) + 1;
                    list1Map.put(ch, value);
                }
                else {
                    list1Map.put(ch, 1);
                }
            }

            for (Character ch:
                    list2) {
                if (list2Map.containsKey(ch)){
                    int value = list2Map.get(ch) + 1;
                    list2Map.put(ch, value);
                }
                else {
                    list2Map.put(ch, 1);
                }
            }

            List<Character> listDiff1 = new ArrayList<>();
            for (char list1Key:
                 list1Map.keySet()) {
                if (!list2Map.containsKey(list1Key)){
                    listDiff1.add(list1Key);
                    continue;
                }

                int diff = list1Map.get(list1Key) - list2Map.get(list1Key);

                for (int i = 0; i< diff; i++){
                    listDiff1.add(list1Key);
                }
            }

            result.add(listDiff1);


            List<Character> listDiff2 = new ArrayList<>();
            for (char list2Key:
                    list2Map.keySet()) {
                if (!list1Map.containsKey(list2Key)){
                    listDiff2.add(list2Key);
                    continue;
                }

                int diff = list2Map.get(list2Key) - list1Map.get(list2Key);

                for (int i = 0; i< diff; i++){
                    listDiff2.add(list2Key);
                }
            }

            result.add(listDiff2);


            //print List differences

            for (List<Character> list:
                 result) {
                System.out.print("[");

                for (char ch:
                     list) {
                    System.out.print(ch + " ");
                }

                System.out.println("]");
            }

        }


    }
}
