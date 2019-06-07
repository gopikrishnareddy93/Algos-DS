package repo.DS.Trees.BinarySearchTree;

import sun.awt.image.ImageWatched;
import sun.reflect.generics.tree.Tree;
import sun.security.krb5.internal.crypto.Des;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeSerializeAndDeserialize {
    public static class Exercise{
        static TreeNode original, deserializedOne ;

        static void Initialize(){
            original = new TreeNode("1");
            original.left = new TreeNode("2");
            original.right = new TreeNode("5");

            original.left.left = new TreeNode("3");
            original.left.right = new TreeNode("4");
        }

        public static void Run(){
            Initialize();
            String result = Serialize(original);
            System.out.println(result);
            TreeNode node = Deserialize(result);
            result = Serialize(node);
            System.out.println(result);
        }

        static String Serialize(TreeNode node){
            return rSerialize(node);
        }

        static String rSerialize(TreeNode node){
            if (node == null){
                return  "null,";
            }

            String str = node.val + ",";
            str += rSerialize(node.left);
            str += rSerialize(node.right);

            return str;
        }


        static TreeNode Deserialize(String object){
            String[] data_array = object.split(",");
            List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
            return rDeserialize(data_list);
        }

        static TreeNode rDeserialize(List<String> data){
            if (data.get(0).equals("null")){
                data.remove(0);
                return null;
            }

            TreeNode node = new TreeNode(data.get(0));
            data.remove(0);
            node.left = rDeserialize(data);
            node.right = rDeserialize(data);

            return node;
        }
    }

    private static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(String x) { val = x; }
    }
}
