package repo.Algos;

public class PrintAllPossibleCombinationsOfLengthK {

    public static class Excercise{

        static Character[] data = new Character[]{'a', 'b', 'c', 'd'};
        static int subStringLength = 3;

        static void Initialize(){
        }


        public static void Run(){
            Initialize();
            PrintSusListofLengthK();
        }

        static void PrintSusListofLengthK(){

            for(int i = 0; i<= data.length - subStringLength; i++){
             for (int j = i+1; j<= data.length - subStringLength + 1; j++){
                System.out.print(data[i] + "\t");
                for (int k = j; k < j + subStringLength - 1; k++){
                    System.out.print(data[k] + "\t");
                }
                System.out.println();
             }
            }
        }


    }

}
