
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anas
 */
class WordNode {

    String word;
    int numSteps;

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord) throws IOException {
        Set<String> wordDict = dictionarySet.SetRet();
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        Map<String, String> childparent = new HashMap<>();
        queue.add(new WordNode(beginWord, 1));
        List<String> list = new ArrayList<String>(wordDict);
        list.add(endWord);

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;

            if (word.equals(endWord)) {
                System.out.println(endWord);
                String temp = childparent.get(endWord);
                while (temp == null ? beginWord != null : !temp.equals(beginWord)) {
                    System.out.println(temp);
                    temp = childparent.get(temp);

                }
                System.out.println(beginWord);
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (wordDict.contains(newWord)) {
                        childparent.put(newWord, word);
                        queue.add(new WordNode(newWord, top.numSteps + 1));
                        wordDict.remove(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }

        return 0;
    }
}
