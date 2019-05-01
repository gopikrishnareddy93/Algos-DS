package repo.Algos;

import java.util.ArrayList;
import java.util.List;

public class FindTheNumberOfWaterDropsListCanHold {

    static int[] list = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};


    public static class Exercise{

        public static void Run(){
            CalculateNumberOfDrops();
        }

        static void CalculateNumberOfDrops(){

            int leftMax, rightMax = -1, index = 0;
            List<List<Integer>> resultSet = new ArrayList<>();
            int result = 0;
            int leftMaxIndex = 0, rightMaxIndex = 0;

            while (index < list.length - 1){
                // identify left index first
                if (list[index] < list[index + 1]){
                    index++;
                    continue;
                }

                leftMaxIndex = index;
                leftMax = list[index];
                index++;

                // identify right index next
                while (index < list.length && list[index] < leftMax){
                    index++;
                }

                // not a valid hold
                if (leftMaxIndex == index - 1){
                    continue;
                }

                // we reached end of the list
                if (index == list.length){
                    index = leftMaxIndex+1;
                    continue;
                }

                rightMax = list[index];
                rightMaxIndex = index;

                int maxHeight = Math.min(leftMax,rightMax);

                for (int i = leftMaxIndex; i< rightMaxIndex; i++){
                    result += Math.abs(maxHeight-list[i]);
                }
            }

            System.out.println("Capacity = " + result);
        }


    }

}


