import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author feng3302
 * @version 0.1.0
 * @Since 1/29/26
 **/
//Author: Julian Mendoza
//Date: 1/29/26
//Description: The program will read a list of 5 letter words, take a word at random,
// and have the user attempt to guess with matching letters equating to points.
// It will keep track of words guessed and words chosen by the computer
public class Jotto {
    private static final int WORD_SIZE = 5;
    private static final boolean DEBUG = true;

    private String currentWord;
    private int score;
    private final ArrayList<String> playGuesses = new ArrayList<>();
    private final ArrayList<String> playWords = new ArrayList<>();
    private String filename;
    private final ArrayList<String> wordList = new ArrayList<>();

    public Jotto(String filename)
    {
        this.filename = filename;
    }

    public boolean pickWord()
    {
        return false;
    }

    public String showWordList()
    {
        return "";
    }

    public ArrayList<String> showPlayerGuesses()
    {
        return playGuesses;
    }

    public void playerGuessScores(ArrayList<String> guesses)
    {

    }
    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public ArrayList<String> readWords()
    {
        return wordList;
    }

    public void play()
    {

    }

    public int guess()
    {
        return 0;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public ArrayList<String> getPlayedWords() {
        return playWords;
    }

    public int getLetterCount(String wordGuess)
    {
        return 0;
    }

    public boolean addPlayerGuess(String wordGuess)
    {
        return false;
    }

    public void updateWordList()
    {

    }

    public String showPlayedWords()
    {
        return "No words have been played.";
    }

    public ArrayList<String> getWordList()
    {
        return wordList;
    }

    public ArrayList<String> getPlayerGuesses()
    {
        return playGuesses;
    }

    public String getFilename()
    {
        return filename;
    }

    public int getScore()
    {
        return score;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

}
