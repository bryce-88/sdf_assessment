package sdf;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Count implements Comparable<Count>{

    String word;
    private Float wordCount = 0f;
    private Float result = 0f;
    
    public Count() {
    }


    public Count(String word) {
        this.word = word;
    }


 
    public String getWord() {
        return word;
    }


    public void setWord(String word) {
        this.word = word;
    }


    public Float getWordCount() {
        return wordCount;
    }


    public void setWordCount(Float wordCount) {
        this.wordCount = wordCount;
    }


    public Float getResult() {
        return result;
    }


    public void setResult(Float result) {
        this.result = result;
    }


    //methods


    public void add() {
		wordCount++;
	}
    
    public Float evaluate(Float frequency, Float totalCount) {
        Float result = frequency/totalCount;
        return result; 
    }


    @Override
    public int compareTo(Count o) {
        return this.getResult().compareTo(o.getResult());
    }


    //attempting to sort HashMap
    public static Map<String, Count> sortByValue(HashMap<String, Count> count) {
        
        Map<String, Count> temp
        = count.entrySet().stream().sorted((i1, i2)
                          -> i1.getValue().compareTo(i2.getValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
        
        return temp;
    }


    @Override
    public String toString() {
        return "Count = " + wordCount + ", Result = " + this.result + "]";
    }

    

}
