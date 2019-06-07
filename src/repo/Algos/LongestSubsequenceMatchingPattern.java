package repo.Algos;

public class LongestSubsequenceMatchingPattern {

    public static class Exercise{

        static int[] input = {1,2,3,6,7,8};

        public static void Run(){
            calculateLongestSubSequence();
        }

        static void calculateLongestSubSequence(){
            //direction = 1 means up else down
            int direction;
            int result = 0;
            int[] peakValleyTracker = {0,0,0};

            if (input[0] < input[1]){
                direction = 1;
            }
            else {
                direction = 0;
            }

            int i =1;

            for (i =1; i < input.length;i++){

                if (input[i-1] < input[i] && direction != 1){
                    peakValleyTracker = leftShiftArray(peakValleyTracker, i);

                    if (peakValleyTracker[2] - peakValleyTracker[0] > result){
                        result = peakValleyTracker[2] - peakValleyTracker[0];
                    }
                    direction = 1;
                }
                else if (input[i-1] > input[i] && direction != 0) {
                    peakValleyTracker = leftShiftArray(peakValleyTracker, i);

                    if (peakValleyTracker[2] - peakValleyTracker[0] > result){
                        result = peakValleyTracker[2] - peakValleyTracker[0];
                    }

                    direction = 0;
                }
            }

            if (peakValleyTracker[2] != i-1 && peakValleyTracker[2] != 0){
                peakValleyTracker = leftShiftArray(peakValleyTracker, i);
            }


            if (peakValleyTracker[2] - peakValleyTracker[0] > result){
                result = peakValleyTracker[2] - peakValleyTracker[0];
            }

            System.out.println("Result : " + result);

        }

        static int[] leftShiftArray(int[] input, int value){
            input[0] = input[1];
            input[1] = input[2];
            input[2] = value;

            return input;
        }


    }
}
