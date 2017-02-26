/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

/**
 *  Represents a bigram. Has two words a frequency.
 * 
 * @author Kuba
 */
public class Bigram {
    
    private int frequency;
    private String firstword;
    private String secondword;
    private float MLEProb;
    private float jointProb;

    
    
    private Bigram(){
        
    }
    
    public Bigram(String s1, String s2){    
        frequency = 0;
        firstword = s1;
        secondword = s2;
    }
    
    public float getJointProb() {
        return jointProb;
    }

    public void setJointProb(float jointProb) {
        this.jointProb = jointProb;
    }
    
    public void setMLEProb(float MLEProb) {
        this.MLEProb = MLEProb;
    }

    public float getMLEProb() {
        return MLEProb;
    }
    
    public String getFirstword() {
        return firstword;
    }
    
    public void setFirstword(String s) {
        firstword = s;
    }
    
    public void setSecondword(String s) {
        secondword = s;
    }
    
    public String getSecondword(){
        return secondword;
    }
    
    public void incFrequency(){
        frequency++;
    }
    
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
    
}
