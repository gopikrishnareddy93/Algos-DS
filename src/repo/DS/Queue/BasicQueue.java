package repo.DS.Queue;

import java.util.LinkedList;
import java.util.Queue;


// Interesting functions --  add, remove, poll, element, peek
// Poll -- Retrieves and removes the head of this queue, or returns null if this queue is empty.


public class BasicQueue {
    public static class Example{
        static Queue<Integer> queue;

        static void Initialize(){
//            Queues can be initialized in two ways
//            1. Priority queue ordered based on comparater
//            2. Linked list where insertion order in preserved
//          queue = new PriorityQueue<>();
            queue = new LinkedList<Integer>();

            queue.add(1);
            queue.add(2);
            queue.add(4);
            queue.add(8);
            queue.add(16);
        }

        public static void Run(){
            Initialize();
            Print();
            InsertAtTheEnd();
            Print();
            RemoveAtTheBeginning();
            Print();
            PollFunction();
            Print();
            ElementFunction();
            Print();
            PeekFunction();
            Print();
        }


        static void Print(){
            queue.forEach(x -> {
                System.out.print(x + "\t");
            });

            System.out.println();

        }

        static void InsertAtTheEnd(){
            queue.add(32);
        }

        static void RemoveAtTheBeginning(){
            queue.remove();
        }

        static void PollFunction(){
            queue.poll();
        }

        static void ElementFunction(){
            queue.element();
        }

        static void PeekFunction(){
            queue.peek();
        }
    }
}
