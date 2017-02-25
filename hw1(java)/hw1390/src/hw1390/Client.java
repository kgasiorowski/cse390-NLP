/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kuba
 */
public class Client {
 
    private static final String TEXT_PATH = "./text/";
    
    public static void main(String args[]){
    
        ArrayList<String> masterWordList = new ArrayList<String>();
        String filename = TEXT_PATH + "1.txt";
        
        try{
        
            ArrayList<String> sentences = Utils.sentenceTokenizer(filename);
            ArrayList<String> words;
            
            for(String s : sentences){
            
                words = Utils.wordTokenizer(s);
                for(String w : words){
                    
                    masterWordList.add(w);
                
                }
                
            }
                
        }catch(IOException e){
            System.out.println("File: " + filename + " not found.");
        }
        
        UnigramMap uniMap = UnigramMap.generateUnigramMap(masterWordList);
        BigramMap bimap = BigramMap.generateBigramMap(masterWordList);
        
        try{
            uniMap.print("unigram.lm");
            bimap.print("bigram.lm", uniMap.size());
        }catch(IOException e){
            System.out.println("Output file couldn't be opened");
        }
        
    }
    
}
