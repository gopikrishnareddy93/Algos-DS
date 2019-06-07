package repo.DS.Trees.BinarySearchTree;

public class CheckIfOneBinaryTreeIsSubtreeOfOther {

    public static class Exercise{

        static Node tree1,tree2;
        static boolean result = false;

        static void Initialize(){
            tree2 = new Node(10);
            tree2.right = new Node(6);
            tree2.left = new Node(4);
            tree2.left.right = new Node(30);

            tree1 = new Node(26);
            tree1.right = new Node(3);
            tree1.right.right = new Node(3);

            tree1.left = new Node(10);
            tree1.left.left = new Node(4);
            tree1.left.right = new Node(6);
            tree1.left.left.right = new Node(30);
        }


        public static void Run(){
            Initialize();
            CheckIfOneTreeIsSubTree();
        }


        static void CheckIfOneTreeIsSubTree(){
            boolean result = rfind(tree1, tree2);

            System.out.println("Trees Overlap : " + result);
        }

        static boolean rfind(Node tree1, Node tree2){
            if (tree1 == null && tree2 == null){
                return true;
            }

            if ((tree1 == null && tree2 != null) || (tree1 != null && tree2 == null)){
                return false;
            }

            // always have big tree in the left and small one in the right

            if (tree1.val == tree2.val) {
                return rfind(tree1.left, tree2.left) && rfind(tree1.right, tree2.right);
            }

            return rfind(tree1.left, tree2) || rfind(tree1.right, tree2);
        }


    }

    private static class Node{
        int val;
        Node left, right;

        public Node(int val){
            this.val = val;
        }
    }

}
