package repo.Algos;

// Find the nearest smaller numbers on left side in an array

public class NearestSmallerNumbers {

    public static class Exercise {


        public static void Run(int[] arr, int n) {
            printPrevSmaller(arr, n);
        }

        static void printPrevSmaller(int[] arr, int n) {

            // Always print empty or '_'
            // for first element
            System.out.print("_, ");

            // Start from second element
            for (int i = 1; i < n; i++) {
                // look for smaller
                // element on left of 'i'
                int j;
                for (j = i - 1; j >= 0; j--) {
                    if (arr[j] < arr[i]) {
                        System.out.print(arr[j] + ", ");
                        break;
                    }
                }

                // If there is no smaller
                // element on left of 'i'
                if (j == -1)
                    System.out.print("_, ");
            }

        }
    }

}
