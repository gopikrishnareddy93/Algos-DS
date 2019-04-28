package repo.Algos;

import java.util.HashMap;

public class MostCommonWordInAParagraph {

    public static class Exercise{
        static String Paragraph = "Bob hit a ball the hit BALL, flew far after it was hit.";
        static String[] BannedWords = new String[]{"hit"};


        public static void Run(){
            FindFrequentWord();
        }

        static void FindFrequentWord(){
            String[] words = Paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
            HashMap<String, Integer> wordCounts = new HashMap<>();
            String FrequentWord = words[0];

            for (String word:
                 words) {

                if (CheckIfWordIsBanned(word) || word.equals(" ")){
                    continue;
                }

                int count = wordCounts.containsKey(word) ? wordCounts.get(word) : 0;
                count++;
                wordCounts.put(word, count);

                if (wordCounts.get(word) > wordCounts.get(FrequentWord)){
                    FrequentWord = word;
                }
            }

            System.out.println("Most frequent word : " + FrequentWord);


        }

        static boolean CheckIfWordIsBanned(String word){
            for (String bannedWord: BannedWords) {
                if (bannedWord.equals(word)){
                    return true;
                }
            }

            return false;
        }

    }

}
