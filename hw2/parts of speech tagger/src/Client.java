import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kuba
 */
public class Client {
    
    private static final String OUTPUT_PATH = "./out/"; 
    private static final String TRANSITIONS_NAME = "transitions.txt";
    private static final String EMISSIONS_NAME = "emissions.txt";
    
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
        
        WordList firstWords = new WordList();
        
        for(String s : sentencelist){
        
            //Parse this sentence.
            String words[] = s.split(" ");
            for(int i = 0; i < words.length-1; i++)
            {
            
                String firstScannedWord = words[i];
                String secondScannedWord = words[i+1];
            
                if(!firstWords.contains(firstScannedWord))
                    firstWords.add(firstWords);
                
            }
        
        }
        
        
    }
    
    private static void printEmissions(ArrayList<String> sentencelist){
    
        String outpath = OUTPUT_PATH + EMISSIONS_NAME;
        new File(OUTPUT_PATH).mkdirs();
        
        
        
    }
    
    private static ArrayList<String> tokenizeFile(String filename) throws FileNotFoundException{
    
        ArrayList<String> toRtn = new ArrayList();
        Scanner sc = new Scanner(new File(filename));
        String s;
        int lineNum = 0;
        
        while(sc.hasNextLine()){
        
            lineNum = sc.nextInt();
            
            s = sc.nextLine().trim();
            s = "<s> " + s;
            s = s + " </s>";
            
            System.out.println(s);
            
            toRtn.add(s);

        }
            
        sc.close();
        return toRtn;
        
    }
    
}
