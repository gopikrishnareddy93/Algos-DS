package repo.DS.Queue;

import java.util.Collections;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/min-heap-in-java/

public class MaxHeap {

    public static class Exercise{
        static PriorityQueue<Integer> minHeap;

        static void Initialize(){
            //important step to change queue behavior
            minHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public static void Run(){
            Initialize();
            AddELements();
            RemoveElements();
        }

        static void AddELements(){
            minHeap.offer(10);
            minHeap.offer(300);
            minHeap.offer(200);
            minHeap.offer(30);
            minHeap.offer(40);
        }

        static void RemoveElements(){
            while (!minHeap.isEmpty()){
                System.out.println(minHeap.poll());
            }

        }
    }
}
