package repo.Algos;

public class FindPairOfNumberWhoseSumMatchesTargetValueFromLeft {

    public static class Exercise{

        static int[] numbers = new int[]{2,3,8,5,6};
        static int targetSum = 4;

        public static void Run(){
            FindPair();
        }

        static void FindPair(){
            for (int i = 1; i < numbers.length; i++){
                if (2*numbers[i-1] == targetSum){
                    System.out.println("Pair found : (" + (i-1) + ", " + (i-1) + ")");
                    return;
                }

                if (numbers[i] + numbers[i-1] == targetSum){
                    System.out.println("Pair found : (" + (i) + ", " + (i-1) + ")");
                    return;
                }
            }

        }
    }

}
