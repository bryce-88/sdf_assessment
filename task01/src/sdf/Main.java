package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        
        HashMap<String, Count> wordCount = new HashMap<>();

        Path path = Paths.get(args[0]);
        File fileName = path.toFile();
        float totalCount = 0f;

        String line;
        String word;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\\p{Punct}","");
                Scanner scan = new Scanner(line);
                
                while (scan.hasNext()) {
                    word = scan.next().toLowerCase();
            
                    Count count = wordCount.get(word);
                    if (count == null) {
                        count = new Count(word);
                        wordCount.put(word, count);
                    }

                    count.add();
                    totalCount++;
                }
                scan.close();
            }
            br.close();
            fr.close();
        } catch(FileNotFoundException ex) {
            ex.getMessage();
        }

        
        System.out.printf("Total number of words : %.0f\n\n", totalCount);

        //code block below will print out count and frequency for each unique word
        // for (String w:wordCount.keySet()) {
        //     Count count = wordCount.get(w);
        //     System.out.printf("Word is : %s\n", w);
        //     System.out.printf("Count is : %.0f\n", count.getWordCount());
        //     System.out.printf("Frequency is : %.5f", count.evaluate(count.getWordCount(), totalCount));
        //     System.out.println("");
        // }
        

        //attempting to print sorted array
        Map<String, Count> rankedMap = Count.sortByValue(wordCount);
        for (Map.Entry<String, Count> i : rankedMap.entrySet()) {
            System.out.println("Word : " + i.getKey()
                               + ", "
                               + i.getValue());   
        }


    }
}