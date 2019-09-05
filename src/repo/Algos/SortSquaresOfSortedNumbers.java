package repo.Algos;

import java.util.ArrayList;
import java.util.List;

public class SortSquaresOfSortedNumbers {

    public static class Exercise{

        public static void Run(){
            sortSquaresOfSortedNumbers();
        }

        static void sortSquaresOfSortedNumbers(){

            int index =0;
            int[] numbers = new int[]{-4, 1,2,3};

            int negativeEndIndex = Integer.MAX_VALUE;
            int positiveStartIndex = Integer.MIN_VALUE;

            while (index < numbers.length){
                if (numbers[index] >= 0){
                    negativeEndIndex = index - 1;
                    positiveStartIndex = index;
                    break;
                }

                index++;
            }

            List<Integer> resultList = new ArrayList<>();

            while (negativeEndIndex >= 0 && positiveStartIndex < numbers.length){

                int leftValue = numbers[negativeEndIndex]*numbers[negativeEndIndex];
                int rightValue = numbers[positiveStartIndex]*numbers[positiveStartIndex];

                if (leftValue > rightValue){
                    resultList.add(rightValue);
                    positiveStartIndex++;
                }
                else {
                    resultList.add(leftValue);
                    negativeEndIndex--;
                }
            }

            while (negativeEndIndex >= 0){
                resultList.add(numbers[negativeEndIndex]*numbers[negativeEndIndex]);
                negativeEndIndex--;
            }

            while (positiveStartIndex < numbers.length){
                resultList.add(numbers[positiveStartIndex]*numbers[positiveStartIndex]);
                positiveStartIndex++;
            }

            for (int value:
                 resultList) {
                System.out.print(value + "\t");
            }

        }


    }
}
