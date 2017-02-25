/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

/**
 *
 * @author Kuba
 */
public class Unigram {
    
    private String word;
    private int frequency;

    public Unigram() {
        this(1, "");
    }
    
    public Unigram(int i, String s) {
        frequency = i;
        word = s;
    }
    
    public Unigram(String s, int i){
        this(i, s);
    }
    
    public Unigram(String s){
        this(s, 1);
    }
    
    public void incFrequency(){
        frequency++;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getFrequency(){
        return frequency;
    }
    
    public void setWord(String word) {
        this.word = word;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
}
