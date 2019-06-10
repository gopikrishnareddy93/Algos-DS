package repo.DS.Trees.RegularTree;

import repo.Algos.ReverseWordsInAString;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfTwoTreesAreEqual {

    public static class Exercise{
        static Node tree1, tree2;

        static void initialize(){
            tree1 = new Node(1);
            tree1.left = new Node(2);
            tree1.right = new Node(3);

            tree2 = new Node(1);
            tree2.right = new Node(2);
            tree2.right.right = new Node(3);
        }

        public static void Run(){
            initialize();
            compareTrees();
        }

        static void compareTrees(){
            boolean result = true;
            Queue<Node> queue1 = new LinkedList<>();
            Queue<Node> queue2 = new LinkedList<>();

            queue1.add(tree1);
            queue2.add(tree2);

            while (!queue1.isEmpty()){
                Node temp1 = queue1.remove();
                Node temp2 = queue2.remove();

                result = isNodesEqual(temp1, temp2);

                if (!result){
                    result = false;
                    break;
                }

                if (temp1 == null){
                    continue;
                }

                if (!isNodesEqual(temp1.left, temp2.left)){
                    result = false;
                    break;
                }

                queue1.add(temp1.left);
                queue2.add(temp2.left);

                if (!isNodesEqual(temp1.right, temp2.right)){
                    result = false;
                    break;
                }

                queue1.add(temp1.right);
                queue2.add(temp2.right);
            }

            if (result){
                System.out.println("Binary trees are equal");
            }
            else {
                System.out.println("Binary trees are not equal");
            }


        }

        static boolean isNodesEqual(Node node1, Node node2){
            if (node1 == null && node2 == null){
                return true;
            }

            if (node1 == null || node2 == null){
                return false;
            }

            return node1.value == node2.value;
        }



        static class Node{
            int value;
            Node left, right;

            Node(int val){
                value = val;
                left = null;
                right = null;
            }
        }

    }
}
