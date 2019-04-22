package repo.Algos;

//link : https://www.geeksforgeeks.org/count-pairs-array-whose-sum-less-x/

public class FindPairOfNumbersWhoseSumIsClosestToTargetSum {
    public static class Example{
        static int[] list;
        static int targetSum;

        static void Initialize(){
            list = new int[]{10, 22, 28, 29, 30, 40};
            targetSum = 54;
        }

        public static void Run(){
            Initialize();
//            RegularApproach();
            EfficientApproach();
        }

        static void RegularApproach(){
            String pair = new String();
            int maxSum = Integer.MIN_VALUE;
            for (int i =0 ; i< list.length; i++){
                for (int j = i+1 ; j < list.length; j++){
                    int tempSum = list[i] + list[j];
                    if ( tempSum <= targetSum && tempSum > maxSum){
                        pair = "[" + list[i] + ", " + list[j] + "]";
                    }
                }
            }

            System.out.println(pair);
        }

        static void EfficientApproach(){
            int l = 0, r = list.length-1;
            String pair = new String();
            int maxSum = Integer.MIN_VALUE;

            while (l < r){
                int tempSum = list[l] + list[r];
                if (tempSum < targetSum)
                {
                    if (maxSum < tempSum){
                        pair = "[" + list[l] + ", " + list[r] + "]";
                    }

                    l++;
                }

                // Move to smaller value
                else
                    r--;
            }


            System.out.println(pair);
        }
    }
}
