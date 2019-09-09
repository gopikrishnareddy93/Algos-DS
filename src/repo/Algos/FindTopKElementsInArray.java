package repo.Algos;

import java.util.PriorityQueue;

public class FindTopKElementsInArray {
    public static class Exercise{
        public static void Run(){
            int[] array = new int[]{ 1, 23, 12, 9, 30, 2, 50 };
//            PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1- n2);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int K =3;

            for (int i = 0; i < array.length; i++){
                minHeap.offer(array[i]);

                if (minHeap.size() > K)
                {
                    minHeap.poll();
                }
            }

            while (!minHeap.isEmpty()){
                System.out.print(minHeap.poll() + "\t");
            }
        }
    }


}
