package repo.DS.Stack;


// Interesting functions --  empty, peek, pop, push, search
// Search -- Returns the 1-based position where an object is on this stack. If the object o occurs as an item in this stack, this method returns the distance from the top of the stack of the occurrence nearest the top of the stack; the topmost item on the stack is considered to be at distance 1. The equals method is used to compare o to the items in this stack.


import java.util.Stack;

public class BasicStack {

    public static class Example{
        static Stack<Integer> stack;

        static void Initialize(){
            stack = new Stack<Integer>();

            stack.push(1);
            stack.push(2);
            stack.push(4);
            stack.push(8);
            stack.push(16);
        }

        public static void Run(){
            Initialize();
            Print();
            InsertElementAtTheEnd();
            Print();
            RemoveElementAtTheEnd();
            Print();
        }

        static void Print(){
//            stack.forEach(x ->{
//                System.out.print(x + "\t");
//            });
//
//            System.out.println();

            for (int x:stack
                 ) {
                System.out.print(x + "\t");
            }

            System.out.println();
        }

        static void InsertElementAtTheEnd(){
            stack.push(32);
        }

        static void RemoveElementAtTheEnd(){
            stack.pop();
        }

    }

}
