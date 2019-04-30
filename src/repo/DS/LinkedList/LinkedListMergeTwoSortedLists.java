package repo.DS.LinkedList;

public class LinkedListMergeTwoSortedLists {

    public static class Exercise {

        static Node head1, head2, result;

        static void Initialize(){
            head1 = new Node(1);
            head1.Next = new Node(3);
            head1.Next.Next = new Node(5);

            head2 = new Node(2);
            head2.Next = new Node(4);
            head2.Next.Next = new Node(6);
        }

        public static void Run(){
            Initialize();
            Merge();
            Print();
        }

        static void Merge(){
            Node list1 = head1, list2 = head2;

            if (list1.Value < list2.Value){
                result = new Node(list1.Value);
                list1 = list1.Next;
            }
            else {
                result = new Node(list2.Value);
                list2 = list2.Next;
            }

            Node currentNodeInResult = result;


            while (list1 != null && list2 != null){

                if (list1.Value < list2.Value){
                    currentNodeInResult.Next = new Node(list1.Value);
                    list1 = list1.Next;
                }
                else {
                    currentNodeInResult.Next = new Node(list2.Value);
                    list2 = list2.Next;
                }

                currentNodeInResult = currentNodeInResult.Next;
            }

            while (list1 != null){
                currentNodeInResult.Next = new Node(list1.Value);
                list1 = list1.Next;
                currentNodeInResult = currentNodeInResult.Next;
            }

            while (list2 != null){
                currentNodeInResult.Next = new Node(list2.Value);
                list2 = list2.Next;
                currentNodeInResult = currentNodeInResult.Next;
            }
        }


        static void Print(){
            Node currentNodeInResult = result;
            while (currentNodeInResult != null){
                System.out.print(currentNodeInResult.Value + "\t");
                currentNodeInResult = currentNodeInResult.Next;
            }

        }


    }


    public static class Node {
        public int Value;
        public Node Next;

        public Node(int value){
            this.Value = value;
        }
    }


}
