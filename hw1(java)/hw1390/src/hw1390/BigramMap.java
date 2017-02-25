/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Kuba
 */
public class BigramMap extends HashMap<String, Bigram>{
    
    //Ignores the first word, because nothing precedes it.
    public static BigramMap generateBigramMap(Collection<String> dataset){
    
        BigramMap map = new BigramMap();
        String firstWord, secondWord;
        
        for(int i = 1; i < dataset.size(); i++){
        
            secondWord = ((List<String>)dataset).get(i);
            firstWord = ((List<String>)dataset).get(i-1);
            
            //If the bigram map has this second word already...
            if(map.containsKey(secondWord)){
            
                //Increment the bigram's frequency...
                map.get(secondWord).incFrequency();
                //And update the bigram's word map with the word that precedes it.
                map.get(secondWord).addUnigram(firstWord);
                
            }else{
            //Otherwise...
                
                //Create a new bigram
                Bigram newBigram = new Bigram(secondWord);
                //Update the bigram's map with the word that precedes it
                newBigram.addUnigram(firstWord);
                //Add it to the master bigram map
                map.put(secondWord, newBigram);
            
            }
            
        }
        
        return map;
        
    }
    
    public void print(String filename, int numUnigrams) throws IOException{
    
    
        BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)));
    
        //Cycle through each bigram in this map
        for(Bigram bigram : this.values()){
            
            //Cycle through each preceding word in this bigram
            for(Unigram unigram : bigram.getMap().values()){
            
                output.write(unigram.getWord() + " " + bigram.getWord() + " " + unigram.getFrequency());
                output.write(" " + String.format("%.3f", (float) unigram.getFrequency()/bigram.getFrequency()) + " ");
                output.write(" " + String.format("%.3f", (float)(1+unigram.getFrequency())/(bigram.getFrequency()+numUnigrams)) + " ");
                output.write('\n');
                
            }
            
        }
        
        output.close();
        
    
    
    }
    
}
