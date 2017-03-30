import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Kuba
 */
public class Client {
    
    private static final String OUTPUT_PATH = "./out/"; 
    private static final String TRANSITIONS_NAME = "transitions.txt";
    private static final String EMISSIONS_NAME = "emissions.txt";
    private static final String TAG_FREQ_NAME = "tagfreq.txt";
    
    private static final String START_TAG = "<s>";
    private static final String END_TAG = "</s>";
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        ArrayList<String> sentences = null;
        String filename = null;
        
        try{
        
            filename = "train.txt";
            sentences = tokenizeFile(filename);
            
        }catch(FileNotFoundException e){
            
            System.out.println("Error: file " + filename + " could not be found");
            return;
            
        }
        
        printTransmissions(sentences);
        printEmissions(sentences);
        
        sc.close();
        
    }
    
    private static void printTransmissions(ArrayList<String> sentencelist){
    
        String outpath = OUTPUT_PATH + TRANSITIONS_NAME;
        new File(OUTPUT_PATH).mkdirs();
        
        //Compile a list of all the tags that appear
        HashMap<String, Long> tags = new HashMap();
        for(String s : sentencelist){
            
            String[] tokens = s.split(" ");
            
            //Parse the word so that only the tag is left
            for(int i = 0; i < tokens.length; i++){
            
                if(tokens[i].compareTo(END_TAG) != 0 && tokens[i].compareTo(START_TAG) != 0)
                    tokens[i] = tokens[i].split("/")[1];
            
                if(!tags.containsKey(tokens[i])){
                    
                    tags.put(tokens[i], (long)1);
                    System.out.println("New tag added: " + tokens[i]);
                    
                }else{
                    
                    tags.put(tokens[i], tags.get(tokens[i])+1);
                    
                }
            
            }
            
        }
        
        //Generate the word matrix now
        WordMatrix wordMatrix = new WordMatrix();
        
        tags.forEach((k,v) -> {
        
            if(k.compareTo(END_TAG) == 0)
                return;
                
            WordMap newWord = new WordMap();
            tags.forEach((k1,v1) -> {
                
                if(k1.compareTo(START_TAG) == 0)
                    return;
                
                newWord.put(k1, new Long(0));
                
            });
            wordMatrix.put(k, newWord);
        
        });
        
        //Populate the word matrix
        
        
        
        //Print the word matrix and its values
        wordMatrix.forEach((k1,v1) -> {
        
            v1.forEach((k2, v2) -> 
                    
                    System.out.printf("%-7s | %-7s : %d ", k1, k2, v2)
        
            );
              
            System.out.println();
                
        });
        
    }
    
    private static void printEmissions(ArrayList<String> sentencelist){
    
        String outpath = OUTPUT_PATH + EMISSIONS_NAME;
        new File(OUTPUT_PATH).mkdirs();
        
        
        
    }
    
    private static ArrayList<String> tokenizeFile(String filename) throws FileNotFoundException{
    
        ArrayList<String> toRtn = new ArrayList();
        Scanner sc = new Scanner(new File(filename));
        String s;
        int lineNum;
        
        while(sc.hasNextLine()){
        
            lineNum = sc.nextInt();
            if(lineNum == -1)
                break;
            
            s = sc.nextLine().trim();
            s = "<s> " + s;
            s = s + " </s>";
            
            //System.out.println(s);
            
            toRtn.add(s);

        }
            
        sc.close();
        return toRtn;
        
    }
    
}
