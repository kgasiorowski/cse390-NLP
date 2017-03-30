
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kuba
 */
public class WordMap extends HashMap<String, Long>{
    
    private long frequency;
    
    public long getFrequency(){return frequency;}
    public void setFrequency(long f){frequency = f;}
    public void incFrequency(){frequency++;}
    
    public WordMap(){
        
        super();
        frequency = 0;
        
        
    }
    
    public WordMap(long l){
        
        super();
        frequency = l;
        
    }
    
}
