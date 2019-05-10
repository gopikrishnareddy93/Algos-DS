package repo.DS.LinkedList;


import java.util.Collections;
import java.util.PriorityQueue;

public class MergeTwoSortedLinkedLists {

    public static class Exercise{

        static ListNode[] lists;
        static ListNode result;

        static void Initialize(){
            lists = new ListNode[3];

            lists[0] = new ListNode(1);
            lists[0].next = new ListNode(4);
            lists[0].next.next = new ListNode(5);


            lists[1] = new ListNode(1);
            lists[1].next = new ListNode(3);
            lists[1].next.next = new ListNode(4);


            lists[2] = new ListNode(2);
            lists[2].next = new ListNode(6);
        }

        public static void Run(){
            Initialize();
            //MergeListsUsingLinkedLists();
            MergeListsUsingMinHeap();
        }


        static void MergeListsUsingLinkedLists(){
            int lowestValueIndex = -1, lowestValue = Integer.MAX_VALUE;
            ListNode currentNode;

            for (int i=0;i<lists.length; i++){
                currentNode = lists[i];

                if (currentNode != null && currentNode.val < lowestValue){
                    lowestValue = currentNode.val;
                    lowestValueIndex = i;
                }
            }

            result = new ListNode(lowestValue);
            lists[lowestValueIndex] = lists[lowestValueIndex].next;

            ListNode resultHeadCopy = result;


            while (true){
                lowestValue = Integer.MAX_VALUE;
                lowestValueIndex = -1;
                for (int i=0;i<lists.length; i++){
                    currentNode = lists[i];

                    if (currentNode != null && currentNode.val < lowestValue){
                        lowestValue = currentNode.val;
                        lowestValueIndex = i;
                    }
                }

                if (lowestValueIndex == -1){
                    break;
                }

                resultHeadCopy.next = new ListNode(lowestValue);
                lists[lowestValueIndex] = lists[lowestValueIndex].next;
                resultHeadCopy = resultHeadCopy.next;
            }

            ListNode temp = result;
            while (temp != null){
                System.out.print(temp.val + "\t");
                temp = temp.next;
            }
        }

        static void MergeListsUsingMinHeap(){
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int lowestValueIndex, lowestValue;
            ListNode currentNode;

            while (true){
                lowestValue = Integer.MAX_VALUE;
                lowestValueIndex = -1;
                for (int i=0;i<lists.length; i++){
                    currentNode = lists[i];

                    if (currentNode != null && currentNode.val < lowestValue){
                        lowestValue = currentNode.val;
                        lowestValueIndex = i;
                    }
                }

                if (lowestValueIndex == -1){
                    break;
                }

                minHeap.offer(lowestValue);
                lists[lowestValueIndex] = lists[lowestValueIndex].next;
            }

            while (!minHeap.isEmpty()){
                System.out.print(minHeap.remove() + "\t");
            }
        }



    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}


