import java.util.ArrayList;
public class Wordle{
    String testWord;
    double score;
    public Wordle(String testWord){
        this.testWord = testWord;
        this.score = 0.0;
    }
    public void scoreWord(String word){
        ArrayList<Character> charList = new ArrayList<>();
        for(int i = 0;i < word.length();i++){
            charList.add(word.charAt(i));
        }
        for(int x = 0;x < testWord.length();x++){
            char letter = testWord.charAt(x);
            for(int y = 0;y < charList.size(); y++){
                if(letter == charList.get(y)){
                    if(x == y){
                        score += 1;
                    } else {
                        score += 0.5;
                    }
                }
            }
        }
    }
    public double getScore(){
        return score;
    }
    public void resetScore(){
        score = 0;
    }
    public String getWord(){
        return testWord;
    }
}