package repo.Algos;

// Check if a string can be obtained by rotating another string 2 places

public class CheckStringRotation {
    public static class Exercise{
        public static void Run(String input, String output){

            if (RotateAntiClockwise(input).equals(output) || RotateClockwise(input).equals(output)){
                System.out.println("strings matched after rotation");
            }
            else {
                System.out.println("strings didn't match after rotation");
            }


        }

        static String RotateClockwise(String input){
            int length = input.length();
            if (length <= 2){
                return input;
            }

            return input.substring(length-2, length) + input.substring(0, length-2);
        }

        static String RotateAntiClockwise(String input){
            int length = input.length();
            if (length <= 2){
                return input;
            }

            return input.substring(2) + input.substring(0, 2);
        }
    }
}
