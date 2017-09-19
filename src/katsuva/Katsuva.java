
package katsuva;



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
        String base = "..\\katsuva\\src\\katsuva\\";
        String fileName = "input.txt";
        fileName = base + fileName;
        
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextLine()) {
          lexicalAnalysis(sc.nextLine());
          
        }
 
    }
    
    public static void lexicalAnalysis(String line)
    {
        System.out.println(line);
        
    }
    
}
