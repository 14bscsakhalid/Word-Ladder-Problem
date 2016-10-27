/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Anas
 */
public class DictionaryP {

    public static boolean DicPars(String s) throws FileNotFoundException, IOException {

        Set<String> wordDict = dictionarySet.SetRet();

        int size = wordDict.size();
        List<String> list = new ArrayList<String>(wordDict);

//            System.out.println(s);
//           System.out.println(size);
        for (int i = 0; i < size; i++) {
            if (s == null ? list.get(i) == null : s.equals(list.get(i))) {
                return true;
            }
        }

        return false;
    }

}
