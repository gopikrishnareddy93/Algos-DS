package repo.DS.Trees.BinarySearchTree;

// Useful links :
// 1. https://www.geeksforgeeks.org/binary-tree-set-1-introduction/
// 2. https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BasicBinaryTree {

    public static class Example{
        static Node root;


        static void Initialize(){
            root = new Node(1);

            root.left = new Node(2);

            root.left.left = new Node(3);
            root.left.left.left = new Node(4);
            root.left.left.right = new Node(5);

            root.left.right = new Node(6);

            root.left.right.left = new Node(7);
            root.left.right.right = new Node(8);

            root.right = new Node(9);

            root.right.left = new Node(10);

            root.right.left.left = new Node(11);
            root.right.left.right = new Node(12);

            root.right.right = new Node(13);

            root.right.right.left = new Node(14);
            root.right.right.right = new Node(15);

        }

        public static void Run(){
            Initialize();
            PrintTree(NodeTraversal.InOrder);
            PrintTree(NodeTraversal.PreOrder);
            PrintTree(NodeTraversal.PostOrder);
            System.out.println("Tree Depth : " + GetTreeDepth(root));

        }

        static void PrintTree(NodeTraversal mode){
            System.out.print(mode + " :\t");
            switch(mode){
                case InOrder:
                    PrintInOrderTraversal(root);
                    break;
                case PreOrder:
                    PrintPreOrderTraversal(root);
                    break;
                case PostOrder:
                    PrintPostOrderTraversal(root);
                    break;
            }
            System.out.println();
        }

        static void PrintInOrderTraversal(Node node){
            if (node == null){
                return;
            }

            PrintInOrderTraversal(node.left);
            System.out.print(node.key + "\t");
            PrintInOrderTraversal(node.right);
        }

        static void PrintPreOrderTraversal(Node node){
            if (node == null){
                return;
            }

            System.out.print(node.key + "\t");
            PrintPreOrderTraversal(node.left);
            PrintPreOrderTraversal(node.right);
        }

        static void PrintPostOrderTraversal(Node node){
            if (node == null){
                return;
            }

            PrintPostOrderTraversal(node.left);
            PrintPostOrderTraversal(node.right);
            System.out.print(node.key + "\t");
        }

        static int GetTreeDepth(Node node){
            if (node == null){
                return 0;
            }

            return 1 + Math.max(GetTreeDepth(node.left), GetTreeDepth(node.right));
        }


        Set<Set<Character>>  permute(Set<Character> c, int k){

            return permuteCollection(new HashSet<>(), k, c);
        }

        Set<Set<Character>>  permuteCollection(Set<Character> input, int k, Set<Character> remainingNodes){

            if (input.size() == k){
                Set<Set<Character>> result = new HashSet<>();
                result.add(input);
                return result;
            }

            HashSet<Character> visitedNodes = new HashSet<Character>();

            for (Character element: remainingNodes) {

                if (remainingNodes.size() == k){
                    Set<Set<Character>> result = new HashSet<>();
                    result.add(input);
                    return result;
                }

                Set<Character> newInputStream = input.stream().collect(Collectors.toSet());
                newInputStream.add(element);

                remainingNodes.stream().collect(Collectors.toSet());
                newInputStream.remove(element);

                permuteCollection(newInputStream,k, remainingNodes);

                visitedNodes.add(element);

            }
        }

    }





}

class Node {
    int key;
    Node left,right;

    public Node(int key){
        this.key=key;
        left = null;
        right = null;
    }
}

enum NodeTraversal {
    InOrder,
    PreOrder,
    PostOrder
}