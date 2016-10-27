
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anas
 */
public class dictionarySet {

    public static Set<String> SetRet() throws FileNotFoundException, IOException {
        File file = new File("dictionary.json");
        BufferedReader br = new BufferedReader(new FileReader(file));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            JSONObject obj = new JSONObject(line);

            Set<String> f = obj.keySet();

            return f;
        } finally {
            br.close();
        }
    }
}
