/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Kuba
 */
public class UnigramMap extends HashMap<String, Unigram>{
    
    public static UnigramMap generateUnigramMap(Collection<String> dataset){
    
        UnigramMap map = new UnigramMap();
        
        for(String s : dataset){
            //If the map doesn't already contain s, add it.
            if(!map.containsKey(s))
                map.put(s, new Unigram(s));
            else
                map.get(s).incFrequency();
            
        }
        
        return map;
        
    }
    
    public static UnigramMap insertUnigram(UnigramMap map, String word){
    
        if(!map.containsKey(word))
            map.put(word, new Unigram(word));
        else
            map.get(word).incFrequency();
        
        return map;
        
    }
    
    public void print(String filename) throws IOException{
    
        BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)));
    
        for(Unigram unigram : this.values()){
            output.write(unigram.getWord() + " " + unigram.getFrequency() + "\n");
        }
        
        output.close();
        
    }
    
}
