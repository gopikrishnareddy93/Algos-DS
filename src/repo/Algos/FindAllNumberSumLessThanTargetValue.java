package repo.Algos;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumberSumLessThanTargetValue {

    public static class Exercise{

        static List<Integer> nums;
        static List<List<Integer>> result;
        static int targetValue;

        static void Initialize(){
            nums = new ArrayList<Integer>();

            nums.add(1);
            nums.add(2);
            nums.add(3);
            nums.add(5);
            nums.add(7);
            nums.add(8);
            nums.add(12);

            result = new ArrayList<>();
            targetValue = 10;
        }

        public static void Run(){
            Initialize();
            rfind(new ArrayList<>(), 0, targetValue);
            print();
        }

        static void rfind(List<Integer> subArray, int start, int rem){

            if (rem < 0 ){
                return;
            }
            
            result.add(new ArrayList<>(subArray));

            for (int i = start; i < nums.size(); i++){
                subArray.add(nums.get(i));
                rfind(subArray, i, rem - nums.get(i));
                subArray.remove(subArray.size() -1);
            }
        }


        static void print(){

            for (List<Integer> tempList:
                 result) {

                for (int num:
                     tempList) {
                    System.out.print(num + " ");
                }

                System.out.println();


            }
        }

    }

}
