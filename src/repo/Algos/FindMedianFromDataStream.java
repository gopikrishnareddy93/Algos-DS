package repo.Algos;

import java.util.*;

public class FindMedianFromDataStream {

    public static class Exercise{
        static List<Integer> data = new ArrayList<>();
        static Queue<Integer> upperHalf = new PriorityQueue<>(); //min heap
        static Queue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder()); // max heap

        public static void Run(){
            RegularApproach();
            HeapBasedApproach();
        }

        static void HeapBasedApproach(){
            addNumH(1);
            CalculateMedianH();
            addNumH(3);
            CalculateMedianH();
            addNumH(5);
            CalculateMedianH();
            addNumH(7);
            CalculateMedianH();
            addNumH(9);
            CalculateMedianH();
            addNumH(6);
            CalculateMedianH();
        }

        static void addNumH(int num){
            lowerHalf.add(num);
            upperHalf.add(lowerHalf.remove());

            if (lowerHalf.size() < upperHalf.size()){
                lowerHalf.add(upperHalf.remove());
            }
        }

        static void CalculateMedianH(){
            if (lowerHalf.size() == upperHalf.size()){
                System.out.println("Median = " + (lowerHalf.peek() + upperHalf.peek())/2);
                return;
            }

            System.out.println("Median = " + lowerHalf.peek());
        }

        static void RegularApproach(){
            addNum(1);
            CalculateMedian();
            addNum(3);
            CalculateMedian();
            addNum(5);
            CalculateMedian();
            addNum(7);
            CalculateMedian();
            addNum(9);
            CalculateMedian();
            addNum(6);
            CalculateMedian();
        }

        static void CalculateMedian(){
            int length = data.size();

            if (length%2 == 0){
                System.out.println("Median = " + (data.get(length/2 - 1) + data.get(length/2))/2);
            }
            else{
                System.out.println("Median = " + (data.get(length/2)));
            }
        }

        static void addNum(int num){
            int index = data.size() > 0 ? BinarySearch(num) : 0;
            data.add(index, num);
            //printData();
        }

        static int BinarySearch(int num){
            int index;
            int lowerBound = 0;
            int upperBound = data.size() > 0 ? data.size() -1 : 0;

            while(true){
                index = (lowerBound + upperBound) / 2;

                // found place to insert
                if (num == data.get(index)){
                    break;
                }

                // search right
                if (num > data.get(index)){
                    lowerBound = index+1;

                    if (lowerBound > upperBound){
                        index++;
                        break;
                    }
                }

                // search left
                if (num < data.get(index)){
                    upperBound = index-1;

                    if (lowerBound > upperBound){
                        break;
                    }
                }

            }

            return index;
        }

        static void printData(){
            data.forEach(num -> System.out.print(num + "\t"));
        }


    }



}
