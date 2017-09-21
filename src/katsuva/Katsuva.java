package katsuva;
import java.io.*;
import java.util.*;


class Identifier{
   int value;
   int scope;
   String type; // if needed
   
   Identifier()
   {
       value=-999;
       scope=0;
       type=null;
   }
}

public class Katsuva {
    
    static String[] input;
    static int line_number;
    static Set<String> pre_defined = new HashSet<String>();
    static Map<Integer,Integer> from_endfrom = new HashMap<Integer,Integer>(); // to store line numbers start of scope to end of scope of loops
    static Map<Integer,Integer> if_endif = new HashMap<Integer,Integer>();   // to store start and end of scope of 
    static Map<Integer,Integer> continue_ = new HashMap<Integer,Integer>();
    static Map<Integer,Integer> break_ = new HashMap<Integer,Integer>();
    static Map<String,Identifier> user_variables = new HashMap<String,Identifier>();
    static Stack from_=new Stack();
    static Stack if_=new Stack();
    static int scope=0;
    
    
    public static void main(String[] args) throws Exception {
        initialize();
        String base = "..\\katsuva\\src\\katsuva\\";
        String fileName = "input.txt"; // to be changed to command line input from user
        fileName = base + fileName;
        line_number=-1;
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextLine()) {
          lexicalAnalysis(sc.nextLine());
        }
        if(!(from_.isEmpty()))
           ;// from without end_from
        if(!(if_.isEmpty()))
           ;// if without end_if
        System.out.println(user_variables.toString());
        System.out.println(from_endfrom.toString());
        System.out.println(if_endif.toString());
        System.out.println(continue_.toString());
        System.out.println(break_.toString());
    }
    public static void initialize()   // initializing the pre defined variables
    {
        pre_defined.add("is");
        pre_defined.add("from");
        pre_defined.add("if");
        pre_defined.add("end_if");
        pre_defined.add("end_from");
        pre_defined.add("continue");
        pre_defined.add("break");
        pre_defined.add("to");
        pre_defined.add("inc_by");
        pre_defined.add("write");
        pre_defined.add("else");
        pre_defined.add("in");
    }
    public static void lexicalAnalysis(String line)
    { line_number++;
        if(line.equals(""))
            return;
          String[] lexeme=line.split(" ");
          lexeme[0]=lexeme[0].toString();
          if(lexeme[0].equals("if"))
          {
              scope++;
              if_.push(line_number);
          }
          if(lexeme[0].equals("from"))
          {
              scope++;
              from_.push(line_number);
          }
          if(lexeme[0].equals("end_if"))
          {
              scope--;
              try{if_endif.put((int)if_.pop(),line_number);}
              catch(Exception e)
              {
                  //end_if without if
              }
          }
          if(lexeme[0].equals("end_from"))
          {
              scope--;
              try{from_endfrom.put((int)from_.pop(),line_number);}
              catch(Exception e)
              {
                 // end_from without from  
              } 
          }
          if(lexeme[0].equals("continue"))
          {
              try{continue_.put(line_number,(int)from_.peek());}
              catch(Exception e)
              {
                 //if continue occurs after end_from 
              }
              return;
          }
          if(lexeme[0].equals("break"))
          {
              try{break_.put(line_number,(int)from_.peek());} // this needs to be changed
              catch(Exception e)
              {
                 //if break occurs after end_from 
              }
              return;
          }
          int i;
          for(i=0;i<lexeme.length;i++)
          {
              try{Integer.parseInt(lexeme[i]);}
              catch(Exception e)
              {
                 if(!pre_defined.contains(lexeme[i]))  
                  {
                     Identifier temp=new Identifier();
                     temp.scope=scope;                
                     user_variables.put(lexeme[i],temp);
                 }
             }    
          }   
        System.out.println(line);  
    }  
}
