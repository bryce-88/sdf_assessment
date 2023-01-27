package sdf;

public class Count {

    String word;
    private float wordCount = 0f; //this is frequency
    private float result = 0f;

    
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


    public float getWordCount() {
        return wordCount;
    }


    public void setWordCount(float wordCount) {
        this.wordCount = wordCount;
    }


    public float getResult() {
        return result;
    }


    public void setResult(float result) {
        this.result = result;
    }



    //methods


    public void add() {
		wordCount++;
	}
    
    public float evaluate(float frequency, float totalCount) {
        float result = frequency/totalCount;
        return result;
    }



    // @Override
    // public int compareTo(Object o) {
    //     // TODO Auto-generated method stub
    //     return this.getResult().compareTo(o.getResult());
    // }



}
