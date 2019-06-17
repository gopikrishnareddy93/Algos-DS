package repo.Algos;

import java.util.Stack;

public class EvaluatePostFixNotation {
    public static class Exercise{

        static String expression = "2 3 * 4 -";

        public static void Run(){
            EvaluateExpression();
        }

        static void EvaluateExpression(){
            Stack<Integer> valuesStack = new Stack<>();

            for (int i =0;i<expression.length();i++){

                Character ch = expression.charAt(i);

                if (ch == ' '){
                    continue;
                }

                else if(Character.isDigit(ch)){
                    int num = 0;

                    while (Character.isDigit(ch)){
                        num = 10*num + Character.getNumericValue(ch);
                        i++;
                        ch = expression.charAt(i);
                    }

                    i--;
                    valuesStack.add(num);
                }
                else {

                    int n2 = valuesStack.pop();
                    int n1 = valuesStack.pop();

                    switch (ch){
                        case '+' : valuesStack.push(n1+n2);
                            break;
                        case '-' : valuesStack.push(n1-n2);
                            break;
                        case '*' : valuesStack.push(n1*n2);
                            break;
                        case '/' : valuesStack.push(n1/n2);
                            break;
                    }
                }
            }

            System.out.println("Value = " + valuesStack.pop());
        }
    }
}
