
import java.io.FileWriter;
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

public class executioner {

    public static void ececution() throws IOException {
        Set<String> wordDict = dictionarySet.SetRet();
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        Map<String, String> childparent = new HashMap<>();
        String beginWord;

        List<String> list = new ArrayList<String>(wordDict);
        int size = list.size();

        String csv = "C:\\Users\\Anas Khalid\\Documents\\output.csv";
        FileWriter writer = new FileWriter(csv);
        String data;

        for (int k = 0; k < size; k++) {
            beginWord = list.get(k);
            queue.add(new WordNode(beginWord, 1));
            for (int j = 0; j < size; j++) {
                String endWord = list.get(j);
                list.add(endWord);
                if(beginWord == null ? endWord == null : beginWord.equals(endWord)){
                j++;
                }
                while (!queue.isEmpty()) {
                    WordNode top = queue.remove();
                    String word = top.word;

                    if (word.equals(endWord)) {
                        writer.append(endWord + ",");
                        String temp = childparent.get(endWord);
                        while (temp == null ? beginWord != null : !temp.equals(beginWord)) {
                            writer.append(temp + ",");
                            temp = childparent.get(temp);

                        }
                        writer.append(beginWord + ",");
                        writer.append(top.numSteps + ",,");
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

            }

        }
    }
}
