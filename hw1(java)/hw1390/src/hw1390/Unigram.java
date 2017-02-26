package hw1390;

/**
 * Represents a unigram. Has a word and a frequency.
 * 
 * @author Kuba
 */
public class Unigram {
    
    private String word;
    private int frequency;
    private float MLEprob;
    
    public Unigram() {
        this(1, "");
    }
    
    public Unigram(int i, String s) {
        frequency = i;
        word = s;
        MLEprob = 0;
    }
    
    public Unigram(String s, int i){
        this(i, s);
    }
    
    public Unigram(String s){
        this(s, 1);
    }
    
    public float getMLEprob(){
        return MLEprob;
    }
    
    public void setMLEprob(float f){
        MLEprob = f;
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
