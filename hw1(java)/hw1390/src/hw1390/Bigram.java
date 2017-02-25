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
public class Bigram {
    
    private int frequency;
    private String word;
    private UnigramMap map;
    
    public String getWord() {
        return word;
    }
    
    private Bigram(){
        this("");
    }
    
    public Bigram(String s){    
        frequency = 1;
        word = s;
        map = new UnigramMap();
    }
    
    public void incFrequency(){
        frequency++;
    }
    
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setMap(UnigramMap map) {
        this.map = map;
    }

    public int getFrequency() {
        return frequency;
    }

    public UnigramMap getMap() {
        return map;
    }
    
    public void addUnigram(String word){
    
        map = UnigramMap.insertUnigram(map, word);
    
    }
    
}
