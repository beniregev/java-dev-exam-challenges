package com.beniregev.exam_challenges.numbers_pad_challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * <div>
 *     <p>
 *         +-------+-------+-------+    Examples:
 *         |       |       |       |    1)  1 (800) flowers --> 1 (800) 356 9377
 *         |   1   |   2   |   3   |    2)  1 (800) ChefBen --> 1 (800) 243 3235
 *         |       |  abc  |  def  |
 *         +-------+-------+-------+    Your input is:
 *         |       |       |       |    a. 7-digits phone number
 *         |   4   |   5   |   6   |    b. List of strings -- e.g. ["foo", "books", "hong", "kong", "gal", "leg"]
 *         |  ghi  |  jkl  |  mno  |    c. Advanced: input phone number has unknown number of digit.
 *         +-------+-------+-------+
 *         |       |       |       |    Your output is:
 *         |  7    |   8   |   9   |    Option 1: An indication for each string whether it can be found in the phone number.
 *         | pqrs  |  tuv  | wxyz  |    Option 2: List of strings that can be found in the phone number.
 *         +-------+-------+-------+
 *                 |       |            <ul>Keep notice:
 *                 |   0   |               <li>Complexity -- O(?)</li>
 *                 | space |               <li>Memory usages</li>
 *                 +-------+            </ul>
 *     </p>
 *     <p>
 *         <div>phone number = "3662277815781519518916891"</div>
 *         <div>words = [ "foo", "bar", "baz", "dog", "foobar", "emo", "cap", "car", "cat" ]</div>
 *         <div>single word length = {1..length of phone number}</div>
 *         <div>e.g. "foo" => 366</div>
 *         <div>Trie of all words</div>
 *         <div>For each node, I will have 10 link for which the node you reach after every potential input</div>
 *
 *     </p>
 *     <p>
 *         <ul><h4>Keywords that will be nice to hear: </h4>
 *             <li>
 *                 <b>Aho-Corasick Algorithm</b> -- In the computer science,
 *                 the <i>Aho-Corasick Algorithm</i> is a string-searching
 *                 algorithm invented by Alfred V. Aho and Margaret J. Corasick.
 *                 IT's a kind of dictionary-matching algorithm that locates
 *                 elements of a finite set of strings within an input text. It
 *                 matches all strings simultaneously.
 *             </li>
 *             <li></li>
 *         </ul>
 *     </p>
 *     <p>
 *         <ul><h4>What are the steps I'm taking?</h4>
 *            <li>Build trie.</li>
 *            <li>Calculate the failure links for each node in the trie.</li>
 *            <li>
 *                Walk through the phone number, keeping track of where I
 *                am at each in phone number ==> this will give me which
 *                nodes in the trie are reachable.
 *            </li>
 *            <li>
 *                BFS from all nodes that I was at (like in step 3) along
 *                failure edges ==> that will give me all the trie nodes
 *                that are some substring of the phone number.
 *            </li>
 *            <li>Iterate through each word, check if it works.</li>
 *            <li></li>
 *            <li></li>
 *         </ul>
 *     </p>
 * </div>
 * @author binyamin.regev
 */
public class ExamNumbersPadSolution1 {
    // Mapping the numbers-pad (NumPad) numbers to the letters of the english alphabet ("abcdefghijklmnopqrstuvwxyz").
    private static final int[] NUMBERS_PAD_MAPPING = { 2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9 };

    //  TODO - BR - Added to initialize matrix of characters in "public static void main(String[])"
    private final static int NUMBER_OF_WORDS = 26;
    private final static int MAX_WORD_LENGTH = 10;

    //  Overall time & space complexity: O( length of phone number + total number of letters in the words array)
    public ArrayList<char[]> solve(char[] phoneNumberLetters, char[][] wordsLetters ) {

//        //  Using all numbers makes it more comfortable (no spaces in the middle)
//        int[] phoneNumber = new int[phoneNumberLetters.length];
//        for (int i=0; i<phoneNumber.length; i++)
//            phoneNumber[i] = phoneNumberLetters[i] - '0';
//        int[][] words = new int[wordsLetters.length][];
//        for (int i=0; i< words.length; i++)
//            words[i] = toNumber(wordsLetters[i]);
//
//        //  Build the trie ==> O(total number of letters in the words array)
//        Node trie = new Node();
//        Node[] endAt = new Node[words.length];
//        for (int i = 0; i< words.length; i++)
//            endAt[i] = trie.addWord(a, 0);
//
//        //  TODO - binyamin.regev - Build Aho, just a clever bfs ==> O(total number of letters in the words array)
//
//        //  time: O(phone number length); space: O(1)
//        Node at = trie;
//        at.visited = true;
//        for (int i : phoneNumber) {
//            at = at.nextWithFail[i];
//            at.visited = true;
//        }
//
//        //  bfs
//        ArrayDeque<Node> bfs = new ArrayDeque<>();
//        trie.dfs(bfs); //   Fill up all the start nodes of my bfs
//
//        //  O(total number of letters in the words array)
//        while (!bfs.isEmpty()) {
//            Node next = bfs.removeFirst();
//            if (next.failLink != null && !next.failLink.visited) {
//                next.failLink.visited = true;
//                bfs.addLast(next.failLink);
//            }
//        }
//
        ArrayList<char[]> toReturn = new ArrayList<>();
//        for (int i=0; i< endAt.length; i++) {
//            if (endAt[i].visited) {
//                //  This occurs as some substring of the target string
//                toReturn.add(wordsLetters[i]);
//            }
//        }
        return toReturn;
    }

    public static void main(String[] args) {
        if (args.length < 2)
            System.out.println("Not enough arguments, expected at least 2, got " + args.length);

        ExamNumbersPadSolution1 exam = new ExamNumbersPadSolution1();
        //  args[0] = "3662277815781519518916891"
        //  args[1...n] = "foo", "bar", "baz", "dog", "foobar", "emo", "cap", "car", "cat"...
        char[] phoneNumberLetters = args[0].toCharArray();
        char[][] wordsLetters = new char[NUMBER_OF_WORDS][MAX_WORD_LENGTH];
        for (int i = 1; i< args.length; i++)
            wordsLetters[i-1] = args[i].toCharArray();

        exam.solve(phoneNumberLetters, wordsLetters);
    }

    private int[] toNumber(char[] word) {
        int[] result = new int[word.length];
        for (int i=0; i<result.length; i++)
            result[i] = NUMBERS_PAD_MAPPING[word[i]-'a'];
        return result;
    }
}

class Node {
    Node[] children = new Node[10];
    Node failLink;          //  Calculated by Aho-Corasick
    Node[] nextWithFail;    //  Calculated by Aho-Corasick
    boolean visited = false;    //  flag the node as "visited"

    //  College level classic entry level to Data-Structure build a trie
    public Node addWord(int[] word, int index) {
        //  if we're at the end of this word then return the node
        if (index == word.length) return this;

        //  Which child we should go next from this node
        int child = word[index];

        //  If the next child we go to is null then it means I haven't seen it yet,
        //  and I should make a new trie node for that to prevent receiving an exception  a new one
        if (children[child] == null)
            children[child] = new Node();

        //  recursively "ask" our child for the rest of the word what will be...
        return children[child].addWord(word, index+1);
    }

    public void dfs(ArrayDeque<Node> bfs) {
        //  TODO - BR - Added to initialize "nodes"
        Node[] nodes = bfs.getFirst().children;
        for (Node child : nodes) {
            if (child != null) child.dfs(bfs);
            if (visited) bfs.addLast(this);
        }
    }

}