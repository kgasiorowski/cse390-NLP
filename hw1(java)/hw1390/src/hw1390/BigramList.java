package hw1390;

import java.util.ArrayList;

/**
 * A list of bigrams, with a string denoting the first word
 * to make sorting and searching easier.
 * 
 * @author Kuba
 */
public class BigramList extends ArrayList<Bigram>{
    
    private String firstword;
    private int frequency;
    
    public BigramList(String s) {
        firstword = s;
    }
    
    public String getFirstword(){
        return firstword;
    }
    
    public void setFirstword(String string){
        firstword = string;
    }
    
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
    
}
