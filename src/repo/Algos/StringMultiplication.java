package repo.Algos;

public class StringMultiplication {
    public static class Exercise{

        public static void Run(){
            String num1 = "999";
            String num2 = "999";
            int m = num1.length(), n = num2.length();
            int[] resultArray = new int[m + n];

            int[] num1Array = new int[m];
            int[] num2Array = new int[n];

            //converting num1 to int array
            for (int i = 0; i < m; i++){
                num1Array[i] = num1.charAt(i) - '0';
            }

            //converting num2 to int array
            for (int i = 0; i < n; i++){
                num2Array[i] = num2.charAt(i) - '0';
            }

            //Start multiplication
            //j handles second number
            //i handles first number
            //start from last digit in num2
            for (int j = n - 1; j >= 0; j--){
                //reset carry after each iteration
                int carry = 0;

                for (int i = m - 1; i >= 0; i--){
                    // For calculating index for storing the result we use below approach
                    // index = [m + n - 1] - [(m - i - 1) + (n - j - 1)]
                    // index = i + j + 1
                    int value = num1Array[i] * num2Array[j] + carry + resultArray[i + j + 1];
                    resultArray[i + j + 1] = value % 10;
                    carry = value / 10;
                }

                // if there is any overflow then add overflow to element
                // at index = [m + n] - [m + (n - j)] = j
                resultArray[j] += carry;
            }

            for (int i = 0; i < m + n; i++){
                System.out.print(resultArray[i]);
            }
        }

    }

}
