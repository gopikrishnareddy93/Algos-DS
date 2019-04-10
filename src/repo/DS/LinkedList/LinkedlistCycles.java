package repo.DS.LinkedList;

import java.util.LinkedList;

public class LinkedlistCycles {

    public static class Example{
        static Node head;

        static void Initialize(){
            head = new Node(5);
            Push(4);
            Push(3);
            Push(2);
            Push(1);

            head.next.next.next.next.next = head.next;
        }

        static void Push(int value){
            Node new_node = new Node(value);
            new_node.next = head;
            head = new_node;
        }

        public static void Run(){
            Initialize();
            DetectCycle();

        }

        static void DetectCycle(){
            Node fast = head, slow = head;
            while (slow != null && fast != null && fast.next != null){

                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast){
                    System.out.println("Loop detected");
                    break;
                }

            }


        }

    }

    public static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            next = null;
        }
    }
}
