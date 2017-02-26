/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1390;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a bigram table.
 * 
 * @author Kuba
 */
public class BigramMatrix extends ArrayList<BigramList>{
    
    //Ignores the first word, because nothing precedes it.
    public static BigramMatrix generateBigramMap(Collection<String> dataset){
    
        BigramMatrix matrix = new BigramMatrix();
        
        ArrayList<String> uniqueStrings = new ArrayList<String>();
        for(String s : dataset)
        {
        
            if(!uniqueStrings.contains(s))
                uniqueStrings.add(s);
        
        }
        
        //Create a 2d arraylist of all possible bigrams
        for(String unique1 : uniqueStrings){
        
            BigramList bigramlist = new BigramList(unique1);
            
            for(String unique2 : uniqueStrings)
                bigramlist.add(new Bigram(unique1, unique2));
        
            matrix.add(bigramlist);
            
        }
        
        /*
        for(BigramList b : matrix)
        {    
            for(Bigram bigram : b)
                System.out.print(String.format("%-25s", "[" + bigram.getFirstword() + "," + bigram.getSecondword() + "]"));
        
            System.out.println();
            
        }
        */
        
        String firstWord, secondWord;
        
        for(int i = 0; i < dataset.size()-1; i++){
        
            firstWord = ((List<String>)dataset).get(i);
            secondWord = ((List<String>)dataset).get(i+1);
            
            //Iterates through each column
            for(BigramList bigramlist : matrix)
            {
                //Skip this row if the first word doesn't match
                if(bigramlist.getFirstword().compareTo(firstWord) != 0)
                    continue; 
                
                //Iterates through this row
                for(Bigram bigram : bigramlist){
                
                    if(bigram.getSecondword().compareTo(secondWord) == 0){
                        //Only increment one bigram's frequency
                        bigram.incFrequency();
                        break;
                    }
                    
                }
            
            }
            
        }
        
        return matrix;
        
    }
    
    public void print(String filename, UnigramMap unigrams) throws IOException{
        
        BufferedWriter output = new BufferedWriter(new FileWriter(new File(filename)));
        
        boolean format = false;
        String format1;
        String format2;
        
        if(format){
            
            output.write(String.format("%-15s %-15s %-1c %-5s %-5s\n", "First word", "Second word", '#', "MLEpr", "Lapla"));
            format1 = "%-15s %-15s %1d ";
            format2 = "%5.3f ";
            
        }else{
        
            format1 = "%s %s %d ";
            format2 = "%f ";
        
        }
        
        //Cycle through each bigram in this map
        for(BigramList x : this){
            
            //Cycle through each preceding word in this bigram
            for(Bigram y : x){
                
                y.setMLEProb((float)(1+y.getFrequency())/(unigrams.get(y.getFirstword()).getFrequency()+unigrams.size()+1));
                
                output.write(String.format(format1, y.getFirstword(), y.getSecondword(), y.getFrequency()));
                output.write(String.format(format2, (float) y.getFrequency()/unigrams.get(y.getFirstword()).getFrequency()));
                output.write(String.format(format2, y.getMLEProb()));
                output.write('\n');
                
            }
            
        }
        
        output.close();
    
    }
    
    public ArrayList<Bigram> toArrayList(){
    
        ArrayList<Bigram> toRtn = new ArrayList<Bigram>();
        
        for(BigramList b : this)
            for(Bigram bigr : b)
                toRtn.add(bigr);
    
        return toRtn;
        
    }
    
    public void printTopBigrams(UnigramMap unigrams, String filename) throws IOException{
    
        final int NUM_TOP_BIGRAMS = 20;
        
        ArrayList<Bigram> bigramsList = this.toArrayList();
        
        //Calculates joint mle probability on the fly
        for(Bigram b : bigramsList)
            b.setJointProb(b.getMLEProb()*unigrams.get(b.getSecondword()).getMLEprob());
        
        Collections.sort(bigramsList, new Comparator<Bigram>() {
            
            @Override
            public int compare(Bigram a, Bigram b) {
                
                return ((Float)b.getJointProb()).compareTo((Float)a.getJointProb());
                
            }
            
        });
        
        BufferedWriter out = new BufferedWriter(new FileWriter(new File(filename)));
        
        for (int i = 0; i < NUM_TOP_BIGRAMS; i++) {
            Bigram temp = bigramsList.get(i);
            out.write(String.format("%s %s %f\n", 
                    temp.getFirstword(), 
                    temp.getSecondword(), 
                    temp.getJointProb())
            );
        
        }
        
        out.close();
    
    }
    
}
