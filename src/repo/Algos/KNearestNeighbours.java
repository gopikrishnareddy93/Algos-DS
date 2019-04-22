package repo.Algos;

import java.util.*;


// max heap implementation
// time complexity : O(k + (n-k)*logk)
// selection sort O(nk)
// Sorting(quick or merge sort) : O(n*lognn)



public class KNearestNeighbours {

    public static class Exercise{

        static Point center;
        static List<Point> list;
        static int k;

        static void Initalize(){
            center = new Point(0,0);
            list = new ArrayList<Point>() ;
            list.add(new Point(1,1));
            list.add(new Point(1,0));
            list.add(new Point(0,1));
            list.add(new Point(2,0));
            list.add(new Point(3,0));
            list.add(new Point(4,0));
            list.add(new Point(0,5));
            list.add(new Point(0,6));
            list.add(new Point(0,7));

            k = 4;
        }

        public static void Run(){
            Initalize();
//            MaxheapImplementation();
            SelectionSortImplementation();
//            MergeSortImplementation();
        }

        static int distance(Point p1, Point p2) {
            return (p1.X - p2.X) * (p1.X - p2.X) + (p1.Y - p2.Y) * (p1.Y - p2.Y);
        }

        static void MaxheapImplementation(){
            PriorityQueue<Point> maxHeap = new PriorityQueue<>(k + 1, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return distance(center, o2) - distance(center, o1);
                }
            });
            for (Point p : list) {
                maxHeap.offer(p);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
            Iterator<Point> i = maxHeap.iterator();
            while (i.hasNext()) {
                System.out.println(i.next());
            }
        }

        static void MergeSortImplemention(){

        }

        static void SelectionSortImplementation(){
            int n = list.size();

            for (int i =0; i < k; i++){
                Point min = list.get(i);
                for (int j=i+1; j < n;j++){
                    Point tempPoint = list.get(j);
                    if (min.compareTo(tempPoint) < 0){
                        list.set(0, tempPoint);
                        list.set(j, min);
                        min = tempPoint;
                    }
                }
                System.out.println(min);
            }
        }

        static void MergeSortImplementation(){

            mergeSort(list.toArray(new Point[list.size()]));

            for (int i =0 ; i < k ; i++){
                System.out.println(list.get(i));
            }
        }

        static Point[] mergeSort(Point[] points){
            if (points.length <= 1){
                return points;
            }

            int count = points.length;
            Point[] left = new Point[count/2];
            Point[] right = new Point[count - left.length];

            System.arraycopy(points, 0, left, 0, left.length);
            System.arraycopy(points, left.length, right, 0, right.length);

            mergeSort(left);
            mergeSort(right);

            mergeSortedArrays(left,right, points);

            return points;

        }

        static void mergeSortedArrays(Point[] left, Point[] right, Point[] result){
//Index Position in first array - starting with first element
            int iFirst = 0;

            //Index Position in second array - starting with first element
            int iSecond = 0;

            //Index Position in merged array - starting with first position
            int iMerged = 0;

            //Compare elements at iFirst and iSecond,
            //and move smaller element at iMerged
            while (iFirst < left.length && iSecond < right.length)
            {
                if (left[iFirst].compareTo(right[iSecond]) < 0)
                {
                    result[iMerged] = left[iFirst];
                    iFirst++;
                }
                else
                {
                    result[iMerged] = right[iSecond];
                    iSecond++;
                }
                iMerged++;
            }
            //copy remaining elements from both halves - each half will have already sorted elements
            System.arraycopy(left, iFirst, result, iMerged, left.length - iFirst);
            System.arraycopy(right, iSecond, result, iMerged, right.length - iSecond);
        }
    }

    public static class Point{
        public int X;
        public int Y;

        public Point(int X, int Y){
            this.X = X;
            this.Y = Y;
        }

        @Override
        public String toString(){
            return String.format("[" + this.X + ", " + this.Y + "]");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (X != point.X) return false;
            return Y == point.Y;
        }

        public int compareTo(Point o2) {
            Point center = new Point(0,0);
            return distance(center, o2) - distance(center, this);
        }

        int distance(Point p1, Point p2) {
            return (p1.X - p2.X) * (p1.X - p2.X) + (p1.Y - p2.Y) * (p1.Y - p2.Y);
        }

    }

}
