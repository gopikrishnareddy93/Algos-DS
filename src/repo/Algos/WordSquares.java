package repo.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquares {
    public static class Exercise{
        static String[] words = {"area","lead","wall","lady","ball"};
        static List<List> result = new ArrayList<>();

        public static void Run(){
            bruteForce();
        }

        private static void bruteForce(){
            rBruteForceHelper(new ArrayList<String>(), Arrays.asList(words));
            for (List<String> list : result){
                for (String word : list){
                    System.out.print(word + ",");
                }
                System.out.println();
            }

        }

        private static void rBruteForceHelper(List<String> words, List<String> remainingWords){
            // if number of words is more than each word length then return
            if (words.size() > 0){
                if (words.get(0).length() < words.size()){
                    return;
                }

                if (words.get(0).length() == words.size()){
                    if (validateList(words)){
                        result.add(new ArrayList(words));
                    }

                    return;
                }

                if (remainingWords.size() == 0){
                    return;
                }
            }

            for (String word: remainingWords) {
                words.add(word);

                List<String> remainingWordsCopy = new ArrayList<>(remainingWords);
                remainingWordsCopy.remove(word);
                rBruteForceHelper(words, remainingWordsCopy);

                words.remove(words.size() - 1);
            }
        }

        private static boolean validateList(List<String> words){
            if (words.size() == 0){
                return false;
            }

            if (words.get(0).length() != words.size()){
                return false;
            }

            for (int i = 0; i < words.size(); i++) {
                for (int j = 0; j < words.get(0).length(); j++){
                    if (words.get(i).charAt(j) != words.get(j).charAt(i)){
                        return false;
                    }
                }
            }

            return true;
        }


    }

}
