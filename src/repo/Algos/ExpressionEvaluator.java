package repo.Algos;

import java.util.Stack;

public class ExpressionEvaluator {

    public static class Exercise{

        static String expression = "-2-4-6";
        static Stack<Character> operatorStack = new Stack<>();
        static Stack<Integer> valueStack = new Stack<>();


        public static void Run(){
            EvaluateExpression();
        }

        // stage 1 : single digit no spaces and only + and - operations
        // stage 2 : Single digits with different operators
        // stage 3 : multiple digits, parentheses basically any expression

        static void EvaluateExpression(){
            TokenizeExpression();

//            System.out.print("Operators Stack : ");
//
//            while (!operatorStack.isEmpty()){
//                System.out.print(operatorStack.pop() + "\t");
//            }
//
//            System.out.println("\nValue Stack : ");
//
//            while (!valueStack.isEmpty()){
//                System.out.print(valueStack.pop() + "\t");
//            }

            int result;

            while (!operatorStack.isEmpty()){
                Character op = operatorStack.pop();

                switch (op){
                    case '+' :
                        result = valueStack.pop() + valueStack.pop();
                        valueStack.push(result);
                        break;
                    case '-' :
                        result = -1*valueStack.pop() + valueStack.pop();
                        valueStack.push(result);
                        break;

                }
            }

            System.out.println("Result = " + valueStack.pop());


        }

        static void TokenizeExpression(){
            Stack<Character> temp = new Stack<>();
            char[] expArray = expression.toCharArray();

            int index=0;

            while(index < expArray.length){
                switch (expArray[index]){
                    case '+':
                        valueStack.push(GetTokenFromStack(temp));
                        operatorStack.push(expArray[index]);
                        break;
                    case '-':

                        if (!temp.isEmpty()){
                            valueStack.push(GetTokenFromStack(temp));
                            operatorStack.push('+');
                            temp.push(expArray[index]);
                            break;
                        }

                        temp.push(expArray[index]);
                        break;

                        // Here stack should be empty
                    default:
                        temp.push(expArray[index]);

                }

                index++;
            }


            if (!temp.isEmpty()){
                valueStack.push(GetTokenFromStack(temp));
            }

        }

        static Integer GetTokenFromStack(Stack<Character> stack){

            String result = "";

            while (!stack.isEmpty()){

                Character temp = stack.pop();

                if (temp == '-'){
                    result = temp + result;
                }
                else {
                    result = result + temp;
                }


            }

            return Integer.parseInt(result);
        }



    }

}
