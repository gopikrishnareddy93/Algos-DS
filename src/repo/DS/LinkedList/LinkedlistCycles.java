package repo.DS.LinkedList;

import java.util.LinkedList;

public class LinkedlistCycles {

    public static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            next = null;
        }
    }

    public static class Example{
        static Node head;

        static void Initialize(){
            head = new Node(5);
            Push(4);
            Push(3);
            Push(2);
            Push(1);

        }

        static void Push(int value){
            Node new_node = new Node(value);
            new_node.next = head;
            head = new_node;
        }

        public static void Run(){
            Initialize();
            //DetectCycle();
            PrintLinkedListInReverse();
        }

        static void DetectCycle(){
            //create cycle
            head.next.next.next.next.next = head.next;

            // detect cycle
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

        static void PrintLinkedListInReverse(){
            Node currentNode = head, nextNode = null, previousNode = null;

            if (currentNode.next == null){
                return;
            }

            while(currentNode != null){
                nextNode = currentNode.next;
                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }

            head = previousNode;

            currentNode = head;

            while (currentNode != null){
                System.out.print(currentNode.value + "\t");
                currentNode = currentNode.next;
            }
        }

    }
}
