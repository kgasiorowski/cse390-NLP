
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
public class WordList extends ArrayList<WordList>{
    
    private String name;
    private long freq;
    
    public String getName(){return name;}
    public void setName(String n){name = n;}
    
    public long getFreq(){return freq;}
    public void setFreq(long l){freq = l;}
    
    public boolean contains(String s){
        
        for(WordList w : this){
        
            if(w.name.compareTo(s)==0)
                return true;
            
        }
        
        return false;
        
    }
    
}
