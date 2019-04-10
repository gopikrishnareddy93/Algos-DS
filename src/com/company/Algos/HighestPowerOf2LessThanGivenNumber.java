package com.company.Algos;

public class HighestPowerOf2LessThanGivenNumber {

    public static class Exercise{


        public static void Run(int n){
            runSlowMethod(n);
            runFastMethod(n);
        }

        static void runSlowMethod(int n){
            if (n == 0){
                System.out.println("Evaluated using slow function, result : " + n);
                return;
            }

            for (int i=0; i <= 16; i++){
                int value = 1 << i;

                if (value > n){
                    System.out.println("Evaluated using slow function, result : " + (int)Math.pow(2,i-1));
                    break;
                }
            }


        }

        static void runFastMethod(int n){
            if (n == 0){
                System.out.println("Evaluated using fast function, result : " + n);
                return;
            }

            int pow = (int)(Math.log(n)/Math.log(2));

            System.out.println("Evaluated using fast function, result : " + (int)Math.pow(2,pow));

        }

    }

}
