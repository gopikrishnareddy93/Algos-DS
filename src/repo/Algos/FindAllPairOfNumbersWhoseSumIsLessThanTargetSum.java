package repo.Algos;

//link : https://www.geeksforgeeks.org/count-pairs-array-whose-sum-less-x/

public class FindAllPairOfNumbersWhoseSumIsLessThanTargetSum {

    public static class Exercise{

        static int[] list;
        static int targetSum;

        static void Initialize(){
            list = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
            targetSum = 5;
        }

        public static void Run(){
            Initialize();
//            RegularApproach();
            EfficientSolution();
        }

        static void RegularApproach(){
            int result = 0;
            for (int i =0 ; i< list.length; i++){
                for (int j = i+1 ; j < list.length; j++){
                    if (list[i] + list[j] < targetSum){
                        System.out.println("[" + list[i] + ", " + list[j] + "]");
                        result++;
                    }
                }
            }

            System.out.println("Total number of pairs = " + result);
        }

        static void EfficientSolution(){
            int l = 0, r = list.length-1;
            int result = 0;

            while (l < r){
                if (list[l] + list[r] < targetSum)
                {
                    result += (r - l);

                    for (int i = l ; i <= r; i++){
                        System.out.println("[" + list[l] + ", " + list[i] + "]");
                    }

                    l++;
                }

                // Move to smaller value
                else
                    r--;
            }

            System.out.println("Total number of pairs = " + result);

            return;

        }


    }
}
