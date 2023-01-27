package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Map<String, Count> wordCount = new HashMap<>();

        Path path = Paths.get("for_trying.txt");
        File fileName = path.toFile();
        float totalCount = 0f;

        String line;
        String word;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                Scanner scan = new Scanner(line);
                scan.useDelimiter("\s|\n|\\!|\\,|\\.|\\(|\\)|\\{|\\}|\\:|\\;|\\'");
                
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

        
        System.out.printf("Total number of words : %f\n\n", totalCount);





        for (String w:wordCount.keySet()) {
            Count count = wordCount.get(w);
            System.out.printf("Word is : %s\n", w);
            System.out.printf("Count is : %.0f\n", count.getWordCount());
            System.out.printf("Frequency is : %.5f", count.evaluate(count.getWordCount(), totalCount));
            System.out.println("");
        }
    }
}