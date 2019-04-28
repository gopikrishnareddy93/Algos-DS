package repo.Algos;

public class FindPairOfNumberWhoseSumMatchesTargetValueFromRight {
    public static class Exercise{

        static int[] numbers = new int[]{2,3,8,2,2};
        static int targetSum = 4;

        public static void Run(){
            FindPair();
        }

        static void FindPair(){

            int prevoiuslyFoundIndexL = -1, prevoiuslyFoundIndexR = -1;

            for (int i = 1; i < numbers.length; i++){
                if (2*numbers[i-1] == targetSum){
                    prevoiuslyFoundIndexL = i-1;
                    prevoiuslyFoundIndexR = i-1;
                }

                if (numbers[i] + numbers[i-1] == targetSum){
                    prevoiuslyFoundIndexL = i-1;
                    prevoiuslyFoundIndexR = i;
                }
            }


            if (prevoiuslyFoundIndexL >= 0){
                System.out.println("Pair found : (" + prevoiuslyFoundIndexL + ", " + prevoiuslyFoundIndexR + ")");
            }

        }
    }

}
