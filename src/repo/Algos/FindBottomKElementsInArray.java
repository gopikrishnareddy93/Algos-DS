package repo.Algos;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindBottomKElementsInArray {
    public static class Exercise{

        public static void Run(){
            int[] array = { 1, 23, 12, 9, 30, 2, 50 };
            int K = 3;

//            Comparator<Integer> customComparator = new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2 - o1;
//                }
//            };

//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(customComparator);
//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2) -> n2 - n1);
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i =0; i< array.length; i++){
                maxHeap.offer(array[i]);

                while (maxHeap.size() > K){
                    maxHeap.poll();
                }
            }

            while (!maxHeap.isEmpty()){
                System.out.print(maxHeap.poll() + "\t");
            }
        }
    }
}
