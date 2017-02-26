/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

import java.util.ArrayList;

/**
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
