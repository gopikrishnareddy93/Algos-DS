package repo.Algos;

public class ReverseWordsInAString {
    public static class Exercise{

        static String input = "Hello this is test string 123";

        public static void Run(){
            reverseWords();
        }

        static void reverseWords(){
            String[] wordArray = input.split(" ");
            String result = "";

            if (input.length()<= 1){
                System.out.println(input);
                return;
            }

            for (String word:
                 wordArray) {
                result = word + " " + result;
            }

            System.out.println(result.substring(0, result.length() - 1));
        }


    }
}
