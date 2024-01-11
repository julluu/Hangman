
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hangman {
    
    private int guesses;
    private int count = 0;
    private String word; //word to be quessed
    private String hiddenWord = ""; //word hidden
    private char[] hidden;
    private List<Character>lettersGuessed = new ArrayList<>();

    //create a hangman game
    public Hangman(WordList wordListName, int guesses){
        List<String> lista = wordListName.giveWords();
        Random random = new Random();
        word = lista.get(random.nextInt(lista.size()));
        word = word.toLowerCase();
        this.guesses = guesses;
        createHiddenWord();
    }

    public boolean guess(Character c){
        boolean val = true;
        char a = Character.toLowerCase(c); 
        if (word.indexOf(a)>=0) {
            if(!lettersGuessed.contains(a)) {
                lettersGuessed.add(a);
                updateHiddenWord(a);
                val=true;
            }
            else {
                val=true;
            }
        }
        else {
            lettersGuessed.add(a);
            count++;
            val=false;
        }
        return val;
    }
    
    public List<Character> guesses(){
        List<Character> newList = new ArrayList<Character>();
        for (Character newGuess : lettersGuessed) {
            if(!newList.contains(newGuess)) {
                newList.add(newGuess);
            }
        }
        return newList;
    }

    public int guessesLeft(){   
      return guesses - count;
    }

    public String word(){
        return word;
    }

    public boolean theEnd(){
        if(hiddenWord.equals(word) || guessesLeft()<=0) {
        return true;
       } else {
        return false;
       }
        
    }

    private String createHiddenWord() {
        for (int i = 0; i < word.length(); i++){
            hiddenWord += "*";
        }
        hidden = hiddenWord.toCharArray();

        return hiddenWord;
    }

    public String getHidden(){
        return hiddenWord;
    }

    public String updateHiddenWord(Character c) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                hidden[i] = c;
            }
        } 
    
        StringBuilder s = new StringBuilder("");
        s.append(hidden);
        hiddenWord = s.toString();  
        return hiddenWord;
    }
}
