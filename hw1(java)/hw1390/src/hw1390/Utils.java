/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author Kuba
 */
public abstract class Utils {
    
    public static void createOutputDirectoryPath(String path){
        
        new File(path).mkdirs();
    
    }
    
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
 
    public static ArrayList<String> wordTokenizer(String sentence){
    
        ArrayList<String> words = new ArrayList<String>();
        String[] wordsArr = sentence.replaceAll("\n", " ").toLowerCase().split(" ");
        
        for(String s : wordsArr){
            
            if(s.trim().compareTo("") != 0)
                words.add(s.trim());
        
        }
            
        return words;
        
    }
    
    public static void printUsage(){
    
        System.out.println("USAGE:\njava -jar LMB.jar inputfilename\n"
                         + "\nWhere: LMB is the executable of this program"
                         + "\ninputfilename is a plaintext file located in the ./text/ folder"
                         + "\nAll output files will be created and written to the \"lm\" directory in root");
        System.exit(1);
    
    }
    
}
