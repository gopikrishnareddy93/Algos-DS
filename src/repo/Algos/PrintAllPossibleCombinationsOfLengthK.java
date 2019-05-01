package repo.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPossibleCombinationsOfLengthK {

    public static class Excercise{

        static Character[] data = new Character[]{'a', 'b', 'c', 'd', 'e', 'k'};
        //static Character[] data = new Character[]{'a', 'b', 'c', 'd'};
        static int subStringLength = 3;
        static ArrayList<ArrayList<Character>> resultSet = new ArrayList<>();

        static void Initialize(){
        }


        public static void Run(){
            Initialize();
            PrintSubListofLengthK();
            PrintResultSet();
        }

        static void PrintSubListofLengthK(){

//            for(int i = 0; i<= data.length - subStringLength; i++){
//             for (int j = i+1; j<= data.length - subStringLength + 1; j++){
//                System.out.print(data[i] + "\t");
//                for (int k = j; k < j + subStringLength - 1; k++){
//                    System.out.print(data[k] + "\t");
//                }
//                System.out.println();
//             }
//            }

            rPrintSubListofLengthK(new ArrayList<>(),  new ArrayList<Character>(Arrays.asList(data)));
        }


        static void rPrintSubListofLengthK(ArrayList<Character> left, ArrayList<Character> right){

            if (left.size() == subStringLength-1){
                for (Character value: right) {
                    ArrayList<Character> temp = (ArrayList) left.clone();
                    temp.add(value);
                    resultSet.add(temp);
                }

                return;
            }

            ArrayList<Character> rightCopy = (ArrayList) right.clone();

            for (Character value: right) {
                ArrayList<Character> leftCopy = (ArrayList) left.clone();
                leftCopy.add(value);

                rightCopy.remove(value);

                rPrintSubListofLengthK(leftCopy, rightCopy);
            }
        }

        static void PrintResultSet(){
            for (ArrayList<Character> subset : resultSet){
                for (int i = 0; i< subset.size(); i++){
                    System.out.print( subset.get(i) + "\t");
                }

                System.out.println();
            }
        }


    }

}
