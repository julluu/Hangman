import java.util.Scanner;

class Main {

    public static void main(String args[]){
        
        WordList w = new WordList("words.txt");
        System.out.println(w.giveWords());

        Hangman h = new Hangman(w, 5);
        System.out.println(h.word()); 

        Scanner input = new Scanner(System.in);
        
        System.out.println("The hidden word...\n");
        System.out.println(h.getHidden());

        System.out.println("Guesses left: "  + h.guessesLeft());
        System.out.println("Guessed letters: " + h.guesses() + "\n");
        System.out.print("Guess a letter: ");

        do {
            Character arvaus = input.next().toLowerCase().charAt(0);
            System.out.println();

        if (h.guess(arvaus) == true) {
            h.updateHiddenWord(arvaus);
            if(!h.theEnd()){
            System.out.println("The hidden word...");
            System.out.println("\n" + h.updateHiddenWord(arvaus)); 
            System.out.println("\nGuesses left: "  + h.guessesLeft());
            System.out.println("Guessed letters: " + h.guesses()+ "\n");
            System.out.print("Guess a letter: ");
            }
            if (h.theEnd() && h.guessesLeft()>0) {
                System.out.println("\nCongratulations! You won!!! \n" +
                "The hidden word was: \"" + h.word() +"\"");
            }
            else {
            h.updateHiddenWord(arvaus);
            if (h.guessesLeft()==0) {
                System.out.println("Sorry, you lost!\n" +
                            "The hidden word was: \"" + h.word() + "\"");
            }
    
        }
        }  
        else {
        h.updateHiddenWord(arvaus);
        if (h.guessesLeft()==0) {
                System.out.println("Sorry, you lost!\n" +
                            "The hidden word was: \"" + h.word() + "\"");
        }
        else {
        System.out.println("The hidden word...\n");
        System.out.println("\n" + h.updateHiddenWord(arvaus)); 
        System.out.println("\nGuesses left: "  + h.guessesLeft());
        System.out.println("Guessed letters: " + h.guesses()+ "\n");
        System.out.print("Guess a letter: ");
        }
        }
    }
        while (h.guessesLeft()!=0 && !h.theEnd());
        input.close();
}
}
