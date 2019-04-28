package repo.Algos;

// time efficient                   : https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
// time and space efficient         : https://www.geeksforgeeks.org/longest-palindromic-substring-set-2/
// Longest Palindromic Subsequence  : https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

public class FindLongestPalindromicSubstring {
    public static class Exercise {
        static String input;

        static void Initialize(){
            input = "forgeeksskeegfor";
        }

        public static void Run(){
            Initialize();
//            BruteForceImplementation();
            TimeEfficientImplemention();
        }

        static void BruteForceImplementation(){
            String result = "";
            for (int i=0; i< input.length(); i++){
                for (int j=i;j<input.length();j++){
                    String subString = input.substring(i,j);
                    if (CheckIfStringIsPalindrome(subString) && subString.length() > result.length()){
                        result = subString;
                    }
                }
            }

            System.out.println(result);
        }

        static void TimeEfficientImplemention() {

            int n = input.length();
            boolean table[][] = new boolean[n][n];

            // All substrings of length 1 are palindromes
            int maxLength = 1;
            for (int i = 0; i < n; ++i)
                table[i][i] = true;

            // check for sub-string of length 2.
            int start = 0;
            for (int i = 0; i < n - 1; ++i) {
                if (input.charAt(i) == input.charAt(i + 1)) {
                    table[i][i + 1] = true;
                    start = i;
                    maxLength = 2;
                }
            }

            for (int k = 3; k <= n; ++k) {

                // Fix the starting index
                for (int i = 0; i < n - k + 1; ++i) {
                    // Get the ending index of substring from
                    // starting index i and length k
                    int j = i + k - 1;

                    // checking for sub-string from ith index to
                    // jth index iff str.charAt(i+1) to
                    // str.charAt(j-1) is a palindrome
                    if (table[i + 1][j - 1] && input.charAt(i) ==
                            input.charAt(j)) {
                        table[i][j] = true;

                        if (k > maxLength) {
                            start = i;
                            maxLength = k;
                        }
                    }
                }
            }

            System.out.print(input.substring(start, start + maxLength));
        }

        static boolean CheckIfStringIsPalindrome(String input){
            StringBuilder sb = new StringBuilder(input);
            return input.equals(sb.reverse().toString());
        }
    }
}
