package repo.Algos;

import java.util.Stack;

// Example https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/

public class ConvertAGivenExpressionToPostFixNotation {
    public static class Exercise{

        static String inFix = "2+3*4";

        public static void Run(){
            ConvertToPostFix();
        }

        static int Prec(Character ch){
            switch (ch){
                case '+':
                case '-':
                    return 1;

                case '*':
                case '/':
                    return 2;
            }

            return -1;
        }

        static void ConvertToPostFix(){
            String postfixExpression = "";
            Stack<Character> operators = new Stack<>();

            for (int i =0; i< inFix.length(); i++){

                Character ch = inFix.charAt(i);

                if (ch == ' '){
                    continue;
                }
                else if (Character.isDigit(ch)){
                    while (Character.isDigit(ch)){
                        postfixExpression += ch;
                        i++;

                        if (i >= inFix.length()){
                            break;
                        }

                        ch = inFix.charAt(i);
                    }

                    postfixExpression += " ";
                    i--;
                }
                else {
                    while (!operators.isEmpty() && Prec(ch) <= Prec(operators.peek())){
                        postfixExpression += operators.pop() + " ";
                    }

                    operators.push(ch);
                }
            }

            while (!operators.isEmpty()){
                postfixExpression += operators.pop() + " ";
            }

            System.out.println("Postfix notation : " + postfixExpression);
        }


    }

}
