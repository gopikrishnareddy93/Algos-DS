package repo.DS.LinkedList;


// didn't implement random part

public class LinkedListDeepClone {

    public static class Exercise {
        static Node org, result;

        static void Initialize(){
            org = new Node(1);
            Node secondNode = new Node(2);
            Node thirdNode = new Node (3);
            Node fourthNode = new Node (4);

            org.Next = secondNode;
            secondNode.Next = thirdNode;
            thirdNode.Next = fourthNode;


        }


        public static void Run(){
            Initialize();
            DeepClone();
        }

        static void DeepClone(){
            Node currentNode = org, newCurrentNode;

            result = new Node(currentNode.Value);
            newCurrentNode = result;
            currentNode = currentNode.Next;

            while (currentNode != null){
                newCurrentNode.Next = new Node(currentNode.Value);
                currentNode = currentNode.Next;
                newCurrentNode = newCurrentNode.Next;
            }


            PrintLinkedList();
        }

        static void PrintLinkedList(){
            Node currentNode = result;
            while (currentNode!=null){
                System.out.print(currentNode.Value + "\t");
                currentNode = currentNode.Next;
            }

            System.out.println();

        }





    }

    public static class Node{
        public int Value;
        public Node Next;
        public Node Random;

        public Node(int value){
            this.Next = null;
            this.Random = null;
            this.Value = value;
        }

        public Node(int value,Node _next,Node _random){
            this.Next = _next;
            this.Random = _random;
            this.Value = value;
        }
    }

}
