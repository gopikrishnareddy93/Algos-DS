package repo.Algos.BinarySearch;

public class BinarySearch {
    public static class Exercise{

        public static void Run(){
            searchForAnTargetElement();
            searchForAnElementClosestToTheTarget();
            searchForAnElementInARotatedArray();
        }

        static void searchForAnTargetElement(){
            int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
            int target = 5;
            int l = 0, r = array.length - 1;
            int mid;

            while (l <= r){
                mid = (l + r)/2;

                if (array[mid] == target){
                    System.out.println(String.format("Found the target element %d at index: %d", target, mid));
                    break;
                }
                else if (array[mid] < target){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }

        //https://www.geeksforgeeks.org/find-closest-number-array/
        static void searchForAnElementClosestToTheTarget(){
            int[] array = new int[]{2,4,7,10,15,25,50};
            int target = 11;
            int l = 0, r = array.length - 1;
            int mid;

            while (l < r){
                mid = (l + r)/2;

                if (array[mid] == target){
                    l = mid;
                    break;
                }
                else if (array[mid] < target){
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }

            System.out.println(String.format("Found the element closet to the target %d at index = %d value = %d", target, l, array[l]));
        }

        static void searchForAnElementInARotatedArray(){
            int[] array = new int[]{10,15,25,50,2,4,7};
            int target = 4;
            int l = 0, r = array.length - 1;
            int mid;

            //first find the index of the smallest element
            while (l < r){
                mid = (l + r) / 2;
                if (array[mid] > array[r]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }

            int rotIndex = l,realmid;
            l = 0; r = array.length - 1;

            while (l <= r){
                mid = (l + r) /2;
                realmid = (mid + rotIndex)%array.length;
                if (array[realmid] == target){
                    System.out.println(String.format("Found the target element %d at index: %d", target, realmid));
                    break;
                }
                else if (array[realmid] > target){
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
    }
}
