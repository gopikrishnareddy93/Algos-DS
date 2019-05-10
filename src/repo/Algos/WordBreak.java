package repo.Algos;

import javax.swing.plaf.SeparatorUI;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class WordBreak {

    public static class Exercise{

        static String text = "leetcode";

        static List<String> dict;

        static void Initialize(){
            dict = new ArrayList<>();

            dict.add("leet");
            dict.add("code");
        }

        public static void Run(){
            Initialize();
            CheckIfTextIsAValidSentence();
        }

        static void CheckIfTextIsAValidSentence(){
            boolean result = false;
            int startIndex = 0, index = 0;

            while (index < text.length()){
                String subString = text.substring(startIndex, index);

                if (!CheckIfDictionaryContainsSubString(subString)) {

                    if (index == startIndex) {
                        break;
                    }

                    result = true;
//                    index = startIndex + 1;
                    startIndex = index;
                    continue;
                }

                index++;
            }

            System.out.print("Result : " + result);
        }

        static boolean CheckIfDictionaryContainsSubString(String subString){

            for (String word:
                 dict) {

                if (word.contains(subString)){
                    return true;
                }
            }

            return false;


        }


    }

}
