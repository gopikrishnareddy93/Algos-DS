package repo.DS.Trees.BinarySearchTree;

import sun.awt.image.ImageWatched;
import sun.security.krb5.internal.crypto.Des;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeSerializeAndDeserialize {
    public static class Exercise{
        static TreeNode original, deserializeOne ;

        static void Initialize(){
            original = new TreeNode("1");
            original.left = new TreeNode("2");
            original.right = new TreeNode("3");

            original.right.left = new TreeNode("4");
            original.right.right = new TreeNode("5");
        }

        public static void Run(){
            Initialize();
            String result = Serialize();
            Deserialize(result);
        }

        static String Serialize(){
            if (original == null){
                return "";
            }

            TreeNode node = original;
            Queue<TreeNode> yetToVistNodes = new LinkedList<>();

            yetToVistNodes.add(node);
            String result = "";


            while (!yetToVistNodes.isEmpty()){

                TreeNode temp = yetToVistNodes.remove();

                if (temp == null)
                {
                    result += "null, ";
                    continue;
                }

                result += temp.val + ", ";

                yetToVistNodes.add(temp.left);
                yetToVistNodes.add(temp.right);
            }
            System.out.println(result);

            return result;
        }

        static void Deserialize(String object){
            String[] nodes = object.split(",");

            Queue<String> parents = new LinkedList<>();
            Queue<String> children = new LinkedList<>();
            int index = 0, level=0;
            int startIndex = 0;

            while (index < nodes.length){


                for (int i = 0; i<= level; i++){

                }

                // first step is to push parents based on level
                // seconds step is to push children based on parents level

                //increment counters

                startIndex += Math.pow(2,level) - 1;
                level++;


            }
        }



    }

    public static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(String x) { val = x; }
    }
}
