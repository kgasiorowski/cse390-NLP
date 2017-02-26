package hw1390;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

/**
 * Represents a list of unigrams. Essentially, this is every word
 * encountered. Uses HashMap to speed up lookup times.
 * 
 * @author Kuba
 */
public class UnigramMap extends HashMap<String, Unigram>{
    
    /**
     * Generates a unigramMap based on a collection of Strings.
     * 
     * @param dataset
     * @return 
     */
    public static UnigramMap generateUnigramMap(Collection<String> dataset){
    
        UnigramMap map = new UnigramMap();
        
        for(String s : dataset){
            //If the map doesn't already contain s, add it.
            if(!map.containsKey(s))
                map.put(s, new Unigram(s));
            else
                map.get(s).incFrequency();
            
        }
        
        map.calculateUnigramMLE(dataset.size());
        return map;
        
    }
    
    /**
     * Calculates the MLE probability for each unigram in this map.
     * 
     * @param numtokens 
     */
    private void calculateUnigramMLE(int numtokens){
        
        for(Unigram unigram : this.values())
            unigram.setMLEprob((float)unigram.getFrequency()/numtokens);
            
    }
    
    /**
     * Inserts a unigram into this map. If it already exists,
     * increment its count and do nothing.
     * 
     * If not, create a new unigram and add it with a frequency of 1.
     * 
     * @param map
     * @param word
     * @return 
     */
    public static UnigramMap insertUnigram(UnigramMap map, String word){
    
        if(!map.containsKey(word))
            map.put(word, new Unigram(word));
        else
            map.get(word).incFrequency();
        
        return map;
        
    }
    
    /**
     * Prints this set of unigrams' information to the file specified
     * by "filename".
     * 
     * @param filename
     * @throws IOException 
     */
    public void print(String filename) throws IOException{
    
        BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)));
        
        for(Unigram unigram : this.values()){
            output.write(String.format("%s %d %.5f\n", unigram.getWord(), unigram.getFrequency(), unigram.getMLEprob()));
        }
        
        output.close();
        
    }
    
}
