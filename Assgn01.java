/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Anas
 */
public class Assgn01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //executioner.ececution();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first word: ");
        String word1 = input.next().toUpperCase();
        System.out.print("Enter second word: ");
        String word2 = input.next().toUpperCase();
        if (word1.length() != word2.length()) {
            System.err.print("Error! Words' length not Same!");
            System.exit(1);
        }
        boolean found = false;
        boolean process = false;
        found = DictionaryP.DicPars(word1);
        if (found == true) {
            found = DictionaryP.DicPars(word2);
            process = true;
            if (found == false) {
                System.err.print("Error!" + word2 + " not in dictionary!");
                System.exit(1);
            }
        } else {
            System.err.print("Error!" + word1 + " not in dictionary!");
            System.exit(1);
        }
        if (process == true) {

            int i = WordLadder.ladderLength(word1, word2);
            System.out.println("Number of total steps: " + i);
        }
    }
}
