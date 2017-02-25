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
public class Utils {
    
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
        String[] wordsArr = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        
        for(String s : wordsArr)
            words.add(s);
        
        return words;
        
    }
    
}
