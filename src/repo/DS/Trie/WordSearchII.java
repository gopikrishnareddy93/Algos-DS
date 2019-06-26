package repo.DS.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static class Exercise{
        static Trie rootTrie;
        static String[] words;
        static char[][] board;

        static void initialize(){
            words = new String[4];
            words[0] = "oath";
            words[1] = "pea";
            words[2] = "eat";
            words[3] = "rain";

            board = new char[4][4];
            board[0][0] = 'o';
            board[0][1] = 'a';
            board[0][2] = 'a';
            board[0][3] = 'n';
            board[1][0] = 'e';
            board[1][1] = 't';
            board[1][2] = 'a';
            board[1][3] = 'e';
            board[2][0] = 'i';
            board[2][1] = 'h';
            board[2][2] = 'k';
            board[2][3] = 'r';
            board[3][0] = 'i';
            board[3][1] = 'f';
            board[3][2] = 'l';
            board[3][3] = 'v';

            rootTrie = new Trie();
        }

        public static void Run(){
            initialize();
            buildTrie();
            findWords();
        }

        static void findWords(){
            List<String> output = new ArrayList<>();
            for (int i = 0; i < board.length; i++){
                for (int j =0; j< board[0].length; j++){
                    dfs(i, j, rootTrie, output);
                }
            }

            for (String word : output){
                System.out.print(word + "\t");
            }
        }

        static void dfs(int i, int j, Trie node, List<String> output){
            char ch = board[i][j];

            if (ch == '#' || node.next[ch - 'a'] == null){
                return;
            }

            node = node.next[ch - 'a'];

            if (node.word != null){
                output.add(node.word);
                node.word = null;
            }

            board[i][j] = '#';

            if (i > 0) {
                dfs(i - 1, j, node, output);
            }

            if (j > 0) {
                dfs(i, j - 1, node, output);
            }

            if (i < board.length - 1){
                dfs(i + 1, j, node, output);
            }

            if (j < board[0].length - 1){
                dfs(i , j + 1, node, output);
            }

            board[i][j] = ch;
        }

        static void buildTrie(){
            for (String word:
                 words) {

                Trie node = rootTrie;

                for (Character ch:
                     word.toCharArray()) {
                    int index = ch-'a';

                    if (node.next[index] == null){
                        node.next[index] = new Trie();
                    }

                    node = node.next[index];
                }

                node.word = word;
            }
        }

        static class Trie{
            String word;
            Trie[] next = new Trie[26];
        }

    }

}
