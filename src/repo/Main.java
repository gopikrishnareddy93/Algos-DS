package repo;


import repo.Algos.CheckStringRotation;
import repo.Algos.CountTotalSetBits;
import repo.Algos.NearestSmallerNumbers;
import repo.DS.Array.BasicArray;

public class Main {

    public static void main(String[] args) {
        RunAlgosApps();
        RunDSApps();

    }

    static void RunAlgosApps(){
//        CountTotalSetBits.Exercise.Run(6);
//        HighestPowerOf2LessThanGivenNumber.Exercise.Run(10);
//        CheckStringRotation.Exercise.Run("amazon", "azonam");

        NearestSmallerNumbers.Execercise.Run(new int[]{1, 6, 4, 10, 2, 5}, 6);
    }

    static void RunDSApps(){
//        BasicArray.Example.Run();
//        BasicStack.Example.Run();
//        BasicQueue.Example.Run();
//        BasicBinaryTree.Example.Run();
//        BasicGraph.Example.Run();
//        LinkedlistCycles.Example.Run();
    }
}
