import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import cs1.Keyboard;

public class Hangman {

	private static final String FILENAME = "Words.txt";
    private ArrayList<String> Words = new ArrayList<String>();
    private ArrayList<String> playerLetters = new ArrayList<String>();
    private ArrayList<String> playerGuesses = new ArrayList<String>();
    private String word;
    private int tries;
    
    public static boolean play(){
        Hangman Hob = new Hangman();
        return Hob.playHelp();
    }
    
    public boolean playHelp(){
        readWords(); //reads words into file
        word = Words.get((int) (Math.random() * Words.size())); //chooses a word to for play
        //System.out.println(word);
        for (int x = 0; x < word.length(); x++){
            playerLetters.add("_ ");
        }
        String s = "Welcome to hangman! Here, a word is chosen at random, and you have to guess the word by guessing letters that you think appear in the word.  If you guess 6 letters wrong, you lose! Good luck!";
        s += "\nYour word:\n";
        System.out.println(s);
        System.out.println(playerLetters);
        //System.out.println(word);
        s = "Pick a letter! You have already guessed the following letters: ";
        System.out.println(s);
        System.out.println(playerGuesses);
        System.out.println("What letter would you like to guess?");
        while (tries < 6){
            String guess = Keyboard.readString();
            if (playerGuesses.contains(guess)){
                System.out.println("Sorry, you already guessed that letter! Guess another");
                guess = Keyboard.readString();
            }
            playerGuesses.add(0, guess);
            //System.out.println(tries);
            boolean inWord = true;
            for (int x = 0; x <word.length(); x++){
                //System.out.println(x);
                //System.out.println(word.substring(x, x+1));
                if (word.substring(x, x + 1).equals( guess)){
                    System.out.println("Congratulations, that letter is in the word");
                    inWord = false;
                    playerLetters.set(x, guess);

                }
            }
            
            if (win()) {
                System.out.println("Congratulations! You guessed the word! You win!");
                return true;
            }
            
            
            System.out.println("Current word: ");
            System.out.println(playerLetters);
            System.out.println("\nYour guesses");
            System.out.println(playerGuesses);
            if (inWord){
                tries += 1;
            }
            System.out.println("Guess Again");
        }
        
        System.out.println("Sorry, you didn't guess the word.  Better luck next time!");
        return false;
    }

    
    public boolean win(){
        for (int x = 0; x < playerLetters.size(); x++){
            if (playerLetters.get(x) == "_ "){
                return false;
            }
        }
        return true;
    }
    
	public void readWords(){
        //Reads Words for hangman into ArrayList Words
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				Words.add(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

        }
	}
    
    public static void main(String[] args){
        Hangman bob = new Hangman();
        bob.playHelp();
    }

}
