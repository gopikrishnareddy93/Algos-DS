package repo.Algos;

public class PermutationOfAString {

    public static class Example{

        public static void Run(String input){
            permutate(input,0, input.length()-1);
        }

        static void permutate(String inputString, int pos1, int pos2){

            if (pos1 == pos2){
                System.out.println(inputString);
                return;
            }

            for (int i=pos1; i<=pos2; i++){
                inputString = interchangeCharacters(inputString, pos1, i);
                permutate(inputString, pos1+1, pos2);
                inputString = interchangeCharacters(inputString, pos1, i);
            }
        }

        static String interchangeCharacters(String input, int pos1, int pos2){
            char temp;
            char[] tmpArray = input.toCharArray();
            temp = tmpArray[pos1];
            tmpArray[pos1] = tmpArray[pos2];
            tmpArray[pos2] = temp;
            return String.valueOf(tmpArray);
        }
    }

}
