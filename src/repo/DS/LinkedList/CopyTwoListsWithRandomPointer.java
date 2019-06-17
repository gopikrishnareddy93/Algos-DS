package repo.DS.LinkedList;

public class CopyTwoListsWithRandomPointer{

    public static class Exercise{
        static Node head, new_head;

        static void initialize(){

            Node one = new Node("1");
            Node second = new Node("2");
            Node third = new Node("3");

            one.next = second;
            second.next = third;

            one.random = third;
            second.random = one;
            third.random = second;

            head = one;
        }

        public static void Run(){
            initialize();
            printList(head);
            copyLinkedList();
            printList(new_head);

        }

        static void copyLinkedList(){

            // 1. create a node copy and place it before the node
            Node node = head;

            while (node != null){
                Node next = node.next;
                node.next = new Node(node.value);
                node.next.next = next;

                node = next;
            }

            // 2. Adjust random node addresses
            node = head;

            while (node != null){
                node.next.random = node.random.next;
                node = node.next.next;
            }


            // 3. Separate those two lists
            new_head = new Node("-1");
            Node tempNode = new_head;
            node = head;

            while (node != null){
                tempNode.next = node.next;
                node = node.next.next;
                tempNode = tempNode.next;
            }

            //remove the extra first node
            new_head = new_head.next;
        }


        static void printList(Node node){
            while (node != null){
                String value = node.value;

                if (node.random != null){
                    value = value + "|" + node.random.value;
                }

                System.out.print(value + "\t\t");
                node = node.next;
            }

            System.out.println();
        }





        static class Node{
            String value;
            Node next, random;

            Node(String val){
                value = val;
                next = null;
                random = null;
            }
        }


    }

}
