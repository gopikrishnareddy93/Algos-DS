package repo.Algos;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossibleStringsByIncludingSpace {

    public static class Excercise{


        public static void Run(String input){
            RecursivelyPrintStringWithSpace(ConvertToStringToList(input), 1, input.length());
        }


        static void RecursivelyPrintStringWithSpace(List<Character> input, int index, int endIndex){
            if (index >= endIndex+2){
                System.out.println(input.toString());
                return;
            }

            System.out.println(input.toString());



            for (int tempIndex = index; tempIndex < input.size(); tempIndex++)
            {
                List<Character> newInput = makeDeepCopyInteger(input);
                newInput.add(tempIndex, ' ');
                //index++;

                RecursivelyPrintStringWithSpace(newInput, tempIndex + 2, endIndex);
            }



        }

        static List<Character> ConvertToStringToList(String input){
            List<Character> chars = new ArrayList<>();

            for (char ch : input.toCharArray()) {
                chars.add(ch);
            }

            return chars;
        }

        static List<Character> makeDeepCopyInteger(List<Character> old){
            List<Character> copy = new ArrayList<Character>();
            for(Character i : old){
                copy.add(i);
            }
            return copy;
        }

    }

}
