package repo.Algos;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPossibleCombinationsInADialPad {
    public static class Exercise{
        static String input = "13";
        static List<String> result = new ArrayList<>();

        public static void Run(){
            rGenerateLetterCombinations(0, new ArrayList<>(), input);
            printResult();
        }

        static void rGenerateLetterCombinations(int index, List<String> leftArray, String input){
            if (index >= input.length() ){
                return;
            }

            //terminate recursion
            if (index == input.length() - 1){
                String[] letters = getDialPadCharsForAGivenDigit(input.charAt(index));

                for (String str:
                     leftArray) {
                    for (String ch: letters){
                        result.add(str + ch);
                    }
                }

                return;
            }

            //generate recursive call
            String[] letters = getDialPadCharsForAGivenDigit(input.charAt(index));
            List<String> tempArray = new ArrayList<>();
            if (leftArray.size() == 0){
                leftArray.add("");
            }

            for (String str:
                    leftArray) {
                for (String ch: letters){
                    tempArray.add(str + ch);
                }
            }

            rGenerateLetterCombinations(index+1, tempArray, input);
        }


        static String[] getDialPadCharsForAGivenDigit(Character ch){
            switch (ch){
                case '2':
                    return new String[]{"a", "b" , "c"};

                case '3':
                    return new String[]{"d", "e" , "f"};

                case '4':
                    return new String[]{"g", "h" , "i"};

                case '5':
                    return new String[]{"j", "k" , "l"};

                case '6':
                    return new String[]{"m", "n" , "o"};

                case '7':
                    return new String[]{"p", "q" , "r", "s"};

                case '8':
                    return new String[]{"t", "u" , "v"};

                case '9':
                    return new String[]{"w", "x" , "y", "z"};
            }

            return new String[]{""};
        }

        static void printResult(){
            for (String str:
                    result){
                System.out.print(str + "\t");
            }
        }



    }

}
