package repo.Algos;

public class EncodeStringWIthShortestLength {

    public static class Exercise{

        public static void Run(){
            encodeStringWithShortestPath();
        }

        static void encodeStringWithShortestPath(){
            String input = "abcdeabcde";
            int n = input.length();
            String[][] dp = new String[n][n];

            for (int l = 0; l < n; l++){
                for (int i =0;i < n - l; i++){
                    int j = i+l;
                    String sub = input.substring(i, j+1);

                    if (sub.length() < 5){
                        dp[i][j] = sub;
                    }
                    else {
                        dp[i][j] = sub;

                        for (int k = i; k < j ; k++){
                            if (dp[i][j].length() > dp[i][k].length() + dp[k+1][j].length()){
                                dp[i][j] = dp[i][k] + dp[k+1][j];
                            }
                        }

                        for (int k = 0; k < sub.length(); k++){
                            String repeat = sub.substring(0, k + 1);

                            if (repeat != null && sub.length()%repeat.length() == 0 && sub.replaceAll(repeat,"").length() == 0){
                                String shorter = sub.length()/repeat.length() + "[" + dp[i][i+k] + "]";

                                if (shorter.length() < dp[i][j].length()){
                                    dp[i][j] = shorter;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(dp[0][n-1]);



        }

    }

}
