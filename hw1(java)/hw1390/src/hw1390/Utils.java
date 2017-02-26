package hw1390;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Static class meant for random methods that don't belong anywhere else.
 * 
 * @author Kuba
 */
public abstract class Utils {
    
    /**
     * Ensures that the output path exists.
     * 
     * @param path 
     */
    public static void createOutputDirectoryPath(String path){
        
        new File(path).mkdirs();
    
    }
    
    /**
     * Tokenizes sentences simply with the "." delimiter.
     * 
     * @param filename
     * @return
     * @throws FileNotFoundException 
     */
    public static ArrayList<String> sentenceTokenizer(String filename) throws FileNotFoundException{
    
        ArrayList<String> sentenceList = new ArrayList<String>();
        
        Scanner sc = new Scanner(new File(filename));
        
        String token;
        String sentence = "";
        while(sc.hasNext()){
        
            token = sc.next();
            sentence += " " + token + " ";
            
            if(!sc.hasNext()){
                sentenceList.add(sentence.trim());
                break;
            }
            
            if(token.endsWith(".")){
                sentence = sentence.trim();
                sentenceList.add(sentence);
                sentence = "";
            }
            
        }
                
        sc.close();
        
        return sentenceList;
        
    }
 
    /**
     * Tokenizes words from a sentence based only one whitespace.
     * 
     * @param sentence
     * @return 
     */
    public static ArrayList<String> wordTokenizer(String sentence){
    
        ArrayList<String> words = new ArrayList<String>();
        String[] wordsArr = sentence.replaceAll("\n", " ").toLowerCase().split(" ");
        
        for(String s : wordsArr){
            
            if(s.trim().compareTo("") != 0)
                words.add(s.trim());
        
        }
            
        return words;
        
    }
    
    /**
     * Prints usage information and exits the program.
     */
    public static void printUsage(){
    
        System.out.println("USAGE:\njava -jar LMB.jar inputfilename\n"
                         + "\nWhere: LMB is the executable of this program"
                         + "\ninputfilename is a plaintext file located in the ./text/ folder"
                         + "\nAll output files will be created and written to the \"lm\" directory in root");
        System.exit(1);
    
    }
    
}
