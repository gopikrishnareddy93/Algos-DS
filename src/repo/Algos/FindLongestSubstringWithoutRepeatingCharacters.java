package repo.Algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindLongestSubstringWithoutRepeatingCharacters {
    public static class Exercise{

        static String text="pwwkew";
        static List<String> maxLengthsArray = new ArrayList<>();
        static List<String> backupLengthsArray = new ArrayList<>();


        public static void Run(){
            FindtheSubstring();
        }

        static void FindtheSubstring(){

            int k =1;
            int length = text.length();
            boolean foundSubStringOfLengthK = true;
            String result = text.substring(0,1);

//            for (int i=0; i< length; i++){
//                maxLengthsArray.add(text.substring(i,i+1));
//            }

            while (foundSubStringOfLengthK){
                foundSubStringOfLengthK = false;
                k++;

                for (int i=0; i< length-k;i++){
                    String temp = text.substring(i, i+k);

                    if (!checkIfGivenStringHasDuplicates(temp)){
                        foundSubStringOfLengthK=true;
                        result = temp;
                        break;
                    }
                }
            }

            System.out.println("Biggest Substring without any duplicate characters : " + result);
        }


        static boolean checkIfGivenStringHasDuplicates(String text){
            char[] chars= text.toCharArray();
            HashSet<Character> characters = new HashSet<>();

            for (char ch:
                 chars) {

                if (characters.contains(ch)){
                    return true;
                }else {
                    characters.add(ch);
                }
            }

            return false;
        }

    }
}
