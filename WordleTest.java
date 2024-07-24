import java.util.ArrayList;
public class WordleTest {
    public static void main(String[] args) {
        EasyReader prompt = new EasyReader();
        EasyReader read = new EasyReader("words.dat");
        String s = read.readLine();
        String[] testWords = s.split(" ;");
        System.out.println("Please enter a 5-letter word:");
        String promptWord = prompt.readWord();
        while(promptWord.length() > 5){
            System.out.println("Sorry, that word is not a 5 letter word.Please enter in a 5 letter word:");
            promptWord = prompt.readWord();
        }
        double score = 0.0;
        Wordle word = new Wordle(promptWord.toUpperCase());
        for(int i = 0;i < testWords.length; i++){
            word.scoreWord(testWords[i]);
            score += word.getScore();
            word.resetScore();
        }
        double aws = Math.round((score / (testWords.length * 5)) * 100);
        String tier = null;
        if(aws < 10){
            tier = " garbage";
        }
        if(aws >= 10 && aws < 12){
            tier = " pretty bad";
        }
        if(aws >= 12 && aws < 14){
            tier = "n unfavorable";
        }
        if(aws >= 14 && aws < 15){
            tier = " neutral";
        }
        if(aws >= 15 && aws < 16){
            tier = " somewhat viable";
        }
        if(aws >= 16 && aws < 17){
            tier = " reasonable";
        }
        if(aws >= 17 && aws < 18){
            tier = " pretty good";
        }
        if(aws >= 18 && aws < 20){
            tier = "n amazing";
        }
        if(aws >= 20){
            tier = " god tier";
        }
        System.out.println(word.getWord() + " is a" + tier + " word to use for Wordle, with an average Wordle score of " + aws + "%, meaning it's similar to about " + aws + " % of Wordle words.");
        System.out.println("Keep in mind that in comparison to " + testWords.length + " possible solutions(published by Wordle), a word cannot be more than about 25% similar.");
    }
}
