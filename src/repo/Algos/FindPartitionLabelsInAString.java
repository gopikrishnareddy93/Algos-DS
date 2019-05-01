package repo.Algos;

import java.util.*;

public class FindPartitionLabelsInAString {
    public static class Exercise{

        static String data = "ababcbacadefegdehijhklij";
        static List<String> result = new ArrayList<>();

        public static void Run(){
            FindAllPartitionLabels();
        }


        static void FindAllPartitionLabels(){

            int index = 0, startIndex = 0;


            // first keep track of last index for a character
            // start with first character and store all the unseen ones onto Queue
            // repeat the process until you empty the queue
            // once queue is empty then push the result onto an array
            // move to the next index and repeat it until you reach end of the string

            HashMap<Character, Integer> endIndexes = new HashMap<>();

            while (index < data.length()){
                Character ch = data.charAt(index);
                endIndexes.put(ch, index);
                index++;
            }

            index = 0;

            while (index < data.length()){
                startIndex = index;
                Character initialChar = data.charAt(index);
                Queue<Character> unprocessedCharacters = new LinkedList<>();
                HashSet<Character> seenCharacters = new HashSet<>();
                unprocessedCharacters.add(initialChar);
                seenCharacters.add(initialChar);
                int endIndex = endIndexes.get(initialChar);
                index++;

                while (index <= endIndex){
                    Character tempChar =data.charAt(index);

                    if (tempChar == initialChar){

                        if (index != endIndex){
                            index++;
                            continue;
                        }

                        // at this point update endIndex and initialCharacter to something to the right if nothing is found then exit loop
                        boolean notFound = true;

                        while (!unprocessedCharacters.isEmpty()){
                            tempChar = unprocessedCharacters.remove();

                            if (endIndexes.get(tempChar) > endIndex)
                            {
                                initialChar = tempChar;
                                endIndex = endIndexes.get(tempChar);
                                notFound = false;
                                seenCharacters.remove(initialChar);
                                break;
                            }
                        }

                        if (notFound){
                            break;
                        }
                    }
                    else{

                        if (!seenCharacters.contains(tempChar)){
                            unprocessedCharacters.add(tempChar);
                            seenCharacters.add(tempChar);
                        }
                    }

                    index++;
                }

                System.out.print(data.substring(startIndex, endIndex + 1) + "\t");
                index++;
            }

            // start with first index and after each character push it onto a set
            // find last occurance of that character and push all the seen
        }


    }

}
