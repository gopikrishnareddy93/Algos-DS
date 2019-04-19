package repo.Algos;

public class DoesRectanglesOverlap {

    public static class Example {

        static Point l1,r1,l2,r2;

        static void Initialize(){
            l1 = new Point(0,10);
            r1 = new Point(10,0);
            l2 = new Point(5,5);
            r2 = new Point(15,0);
        }

        public static void Run(){
            Initialize();
            System.out.println(String.format("Rectangles Overlap : %b", DoOverlap()));

        }

        static boolean DoOverlap(){
            CheckAndRearrangeDataPoints();

            if (l2.X <= r1.X && r2.Y <= l1.Y){
                return true;
            }


            return false;
        }

        static void CheckAndRearrangeDataPoints(){

            // no need to swap coordinates
            if (l1.X < l2.X){
                return;
            }

            // swap coordinates

            Point tempL1 = l1,tempR1 = r1;
            l1 = l2;
            r1 = r2;
            l2 = tempL1;
            r2 = tempR1;
        }


    }

    public static class Point {
        public int X;
        public int Y;

        public Point(int X, int Y){
            this.X = X;
            this.Y = Y;
        }
    }

}
