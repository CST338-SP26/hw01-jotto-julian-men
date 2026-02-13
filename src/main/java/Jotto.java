import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;



//Author: Julian Mendoza
//Date: 1/29/26
//Description: The program will read a list of 5 letter words, take a word at random,
// and have the user attempt to guess with matching letters equating to points.
// It will keep track of words guessed and words chosen by the computer
@SuppressWarnings("unused")
public class Jotto {
    private static final int WORD_SIZE = 5;
    private static final boolean DEBUG = true;

    private String currentWord;
    private int score = 0;
    private final ArrayList<String> playGuesses = new ArrayList<>();
    private final ArrayList<String> playWords = new ArrayList<>();
    private String filename;
    private final ArrayList<String> wordList = new ArrayList<>();

    public Jotto(String filename)
    {
        this.filename = filename;
        readWords();
    }

    public boolean pickWord()
    {
        if(wordList.isEmpty())
        {
            return false;
        }
        if (playWords.size() == wordList.size())
        {
            System.out.println("You've guessed them all!");
            return false;
        }

        Random rand = new Random();
        currentWord = wordList.get(rand.nextInt(wordList.size()));

        if (playWords.contains(currentWord))
        {
            return pickWord();
        }

        playWords.add(currentWord);

        if (DEBUG)
        {
            System.out.println("DEBUG: "+currentWord);
        }

        return true;
    }

    public String showWordList()
    {
        StringBuilder sb = new StringBuilder("Current word list:\n");
        for (String word: wordList)
        {
            sb.append(word).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<String> showPlayerGuesses()
    {
        if(playGuesses.isEmpty())
        {
            System.out.println("No guesses yet");
        }
        else
        {
            System.out.println("Current player guesses:");
            for (String guess: playGuesses)
            {
                System.out.println(guess);
            }
        }
        return playGuesses;
    }

    public void playerGuessScores(ArrayList<String> guesses)
    {
        System.out.println("Guess Score");
        for(String guess : guesses)
        {
            System.out.println(guess + " " + getLetterCount(guess));
        }

    }
    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public ArrayList<String> readWords()
    {
        try(Scanner scan = new Scanner(new File(filename)))
        {
            while (scan.hasNextLine())
            {
                String word = scan.nextLine().trim().toLowerCase();
                if(!wordList.contains(word))
                {
                    wordList.add(word);
                }
            }
        } catch (IOException e)
        {
            System.out.println("Couldn't open " + filename);
        }
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
        wordGuess = wordGuess.toLowerCase();
        String target = currentWord.toLowerCase();

        if (wordGuess.equals(target))
        {
            return WORD_SIZE;
        }

        int count = 0;
        ArrayList<Character> uniqueLetters = new ArrayList<>();

        for (char c: target.toCharArray())
        {
            if (!uniqueLetters.contains(c))
            {
                uniqueLetters.add(c);
            }
        }

        for(char c: wordGuess.toCharArray())
        {
            if (uniqueLetters.contains(c))
            {
                uniqueLetters.remove((Character) c);
                count++;
            }
        }
        return count;
    }

    public boolean addPlayerGuess(String wordGuess)
    {
        if(!playGuesses.contains(wordGuess))
        {
            playGuesses.add(wordGuess);
            return true;
        }
        return false;
    }

    public void updateWordList()
    {
        try(FileWriter writer = new FileWriter(filename))
        {
            for(String guess : playGuesses)
            {
                if(!wordList.contains(guess))
                {
                    wordList.add(guess);
                }
            }
            for(String word: wordList)
            {
                writer.write(word+"\n");
            }
        }
        catch(IOException e)
        {
            System.out.println("Couldn't open "+filename);
        }
    }

    public String showPlayedWords()
    {
        if (playWords.isEmpty())
        {
            return "No words have been played.";
        }

        StringBuilder sb = new StringBuilder("Current list of played words:\n");
        for (String word: playWords)
        {
            sb.append(word).append("\n");
        }
        return sb.toString();
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
