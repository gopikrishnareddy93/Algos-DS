package repo.DS.Queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeap {

    public static class Exercise{
        static PriorityQueue<Integer> minHeap;

        static void Initialize(){
            minHeap = new PriorityQueue<>();
        }

        public static void Run(){
            Initialize();
            AddELements();
            RemoveElemenets();
        }

        static void AddELements(){
            minHeap.offer(10);
            minHeap.offer(300);
            minHeap.offer(200);
            minHeap.offer(30);
            minHeap.offer(40);
        }

        static void RemoveElemenets(){
            while (!minHeap.isEmpty()){
                System.out.println(minHeap.poll());
            }

        }
    }
}
