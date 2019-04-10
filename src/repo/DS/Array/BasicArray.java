package repo.DS.Array;

import java.util.ArrayList;
import java.util.List;

// Several interesting java functions on arrays -- sort, asList, binarySearch, copyOf, copyOfRange, deepEquals, toString
// https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html

public class BasicArray {

    public static class Example{
        static List<Integer> array;

         static void Initialize(){
            array = new ArrayList<>();
            array.add(1);
            array.add(2);
            array.add(4);
            array.add(8);
            array.add(16);
        }

        public static void Run(){
            Initialize();
            Print();
            InsertAtEnd();
            Print();
            RemoveAtTheBegining();
            Print();
        }

        static void Print(){
            for (int i=0; i < array.size();i++){
                System.out.print(array.get(i) + "\t");
            }
            System.out.println();
        }

        static void InsertAtEnd(){
            array.add(32);
        }

        static void RemoveAtTheBegining(){
            array.remove(0);
        }
    }




}
