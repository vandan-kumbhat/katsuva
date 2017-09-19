/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katsuva;

/**
 *
 * @author Vandan
 */

import java.util.*;

// for reading input file(source)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;


public class Katsuva {
    static String[] input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        //later take as input
        String base = "C:\\Users\\Vandan\\Desktop\\SEVEN\\subjects\\plt\\project\\real\\katsuva\\src\\katsuva\\";
        String fileName = "input.txt";
        fileName = base + fileName;
        
        Scanner sc = new Scanner(new File(fileName));
        //List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
          lexicalAnalysis(sc.nextLine());
          
        }
        
        //initialising symbol table, see keywords should be already identified
        /*
        input  = lines.toArray(new String[0]);    
        for(int i=0;i<input.length;i++){
            
            lexicalAnalysis(input[i]);
        }
        */
    }
    
    public static void lexicalAnalysis(String line)
    {
        System.out.println(line);
        
    }
    
}
