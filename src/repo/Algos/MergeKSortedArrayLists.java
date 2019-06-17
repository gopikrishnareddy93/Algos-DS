package repo.Algos;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedArrayLists {
    public static class Exercise{
        static int[][] input;
        static int k;

        static void initialize(){
            k = 4;

            input = new int[k][k];

            int[] tempList = new int[k];

            tempList[0] = 1;
            tempList[1] = 5;
            tempList[2] = 9;
            tempList[3] = 11;

            input[0] = tempList;

            tempList = new int[k];

            tempList[0] = 2;
            tempList[1] = 6;
            tempList[2] = 10;
            tempList[3] = 14;

            input[1] = tempList;

            tempList = new int[k];

            tempList[0] = 3;
            tempList[1] = 7;
            tempList[2] = 11;
            tempList[3] = 15;

            input[2] = tempList;

            tempList = new int[k];

            tempList[0] = 4;
            tempList[1] = 8;
            tempList[2] = 12;
            tempList[3] = 16;

            input[3] = tempList;
        }

        public static void Run(){
            initialize();
            mergeLists();
        }

        static void mergeLists(){
            Queue<ListNode> queue = new PriorityQueue();
            List<Integer> output = new ArrayList<>();

            for (int i =0; i< k ;i++){
                ListNode node = new ListNode(input[i][0], i, 0);
                queue.add(node);
            }

            while (!queue.isEmpty()){
                ListNode node = queue.remove();
                output.add(node.value);

                if (node.elementIndex + 1 < input[node.arrayIndex].length){
                    ListNode nextNode = new ListNode(input[node.arrayIndex][node.elementIndex + 1], node.arrayIndex, node.elementIndex + 1);
                    queue.add(nextNode);
                }
            }

            for (int value:
                 output) {
                System.out.print(value + "\t");
            }


        }

        static class ListNode implements Comparable<ListNode>{
            int value;
            int arrayIndex;
            int elementIndex;

            ListNode(int val, int ai, int ei){
                value= val;
                arrayIndex = ai;
                elementIndex = ei;
            }

            @Override
            public int compareTo(ListNode otherNode){
                return this.value - otherNode.value;
            }
        }


    }


}
