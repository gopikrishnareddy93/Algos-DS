package repo.DS.LinkedList;

public class AddTwoNumbersLinkedList {

    public static class Example {
        static Node num1, num2, result;

        static void Initialize(){
            num1 = new Node(8);
            num1.Next = new Node(8);
            num1.Next.Next = new Node(3);
            //num1.Next.Next.Next = new Node(3);

            num2 = new Node(3);
            num2.Next = new Node(4);
            num2.Next.Next = new Node(5);
        }

        public static void Run(){
            Initialize();
            addNumbersByReversingTwoNumbers();
        }

        static void addNumbersByReversingTwoNumbers(){

            Node tmp1 = reverseLinkedList(num1), tmp2 = reverseLinkedList(num2);
            int carry = 0, sum=0;

            result = new Node(tmp1.Value + tmp2.Value);
            tmp1 = tmp1.Next;
            tmp2 = tmp2.Next;

            Node currentNode = result;

            while (tmp1 != null || tmp2 != null){
                sum = carry;

                if (tmp1 != null){
                    sum += tmp1.Value ;
                    tmp1 = tmp1.Next;
                }

                if (tmp2 != null){
                    sum += tmp2.Value;
                    tmp2 = tmp2.Next;
                }

                Node tmpResult = new Node(sum % 10);
                carry = sum >= 10 ? 1 : 0;
                currentNode.Next = tmpResult;

                currentNode = currentNode.Next;
            }

            if (carry > 0){
                currentNode.Next = new Node(carry);
            }

            result = reverseLinkedList(result);

            printResultLinkedList();
        }

        static Node reverseLinkedList(Node head){
            if (head == null){
                return null;
            }

            Node next = head.Next, prevoius = head, current;

            while (next != null){
                current = next;
                next = current.Next;
                current.Next = prevoius;
                prevoius = current;
            }

            head.Next = null;

            return prevoius;
        }

        static void printResultLinkedList(){
            if (result == null){
                return;
            }

            Node tmp = result;

            while (tmp != null){
                System.out.print(tmp.Value + "\t");
                tmp = tmp.Next;
            }

            System.out.println();
        }



    }

    static class Node{
        public int Value;
        public Node Next;

        public Node(int value){
            this.Next = null;
            this.Value = value;
        }
    }

}
