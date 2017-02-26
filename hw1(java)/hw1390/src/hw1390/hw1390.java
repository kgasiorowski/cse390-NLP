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
 * 
 * @author Kuba
 */
public class hw1390 {
 
    private static final String TEXT_PATH = "./text/";
    private static final String OUTPUT_PATH = "./lm/";
    
    public static void main(String args[]){
        
        String filename = "";
        
        try {
            
            filename = TEXT_PATH + args[0];
            
        } catch (ArrayIndexOutOfBoundsException e) {
            
            Utils.printUsage();
            
        }
        
        Utils.createOutputDirectoryPath(OUTPUT_PATH);
        ArrayList<String> masterWordList = new ArrayList<String>();
        
        System.out.println("FILENAME: " + filename);
        
        try{
        
            System.out.println("PARSING SENTENCES");
            ArrayList<String> sentences = Utils.sentenceTokenizer(filename);
            ArrayList<String> words;
            
            System.out.println("PARSING WORDS");
            for(String s : sentences){
                
                words = Utils.wordTokenizer(s);
                for(String w : words)
                    masterWordList.add(w);
                
            }
                
        }catch(IOException e){
            System.out.println("File: " + filename + " not found.");
            System.exit(1);
        }
        
        System.out.println("GENERATING UNIGRAM STATISTICS");
        UnigramMap uniMap = UnigramMap.generateUnigramMap(masterWordList);
        
        System.out.println("GENERATING BIGRAM STATISTICS (this may take " + 
                            "some time depending on corpus size)");
        BigramMatrix bimap = BigramMatrix.generateBigramMap(masterWordList);
        
        try{
            System.out.println("WRITING UNIGRAM STATISTICS TO: " + OUTPUT_PATH + "unigram.lm");
            uniMap.print(OUTPUT_PATH + "unigram.lm");
            
            System.out.println("WRITING BIGRAM STATISTICS TO: " + OUTPUT_PATH + "bigram.lm (this may take " + 
                            "some time depending on corpus size)");
            bimap.print(OUTPUT_PATH + "bigram.lm", uniMap);
            
            System.out.println("WRITING TOP 20 BIGRAMS TO: top-bigrams.txt");
            bimap.printTopBigrams(uniMap, OUTPUT_PATH + "top-bigrams.txt");
            
        }catch(IOException e){
            System.out.println("Some output file couldn't be opened.");
        }
        
        System.out.println("DONE!");
        
    }
    
}
