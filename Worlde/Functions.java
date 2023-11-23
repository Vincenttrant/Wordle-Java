package Wordle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

// Utility class to hold functions for the game
public class Functions {

    // Returns a random number between 0 and sizeOfArray
    public static int randomNum(int sizeOfArray){
        Random rand = new Random();
        return rand.nextInt(1000) % sizeOfArray;
    }

    // Reads the words from the file into an ArrayList
    // Returns the list of words
    public static ArrayList<String> readFileIntoArray(String FileName){
        ArrayList<String> listOfWords = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FileName))){
            String line;
            while((line = reader.readLine()) != null){
                listOfWords.add(line.toLowerCase());
            }
        }
        catch(Exception e){
            System.out.println("File not found");
        }
        return listOfWords;
    }



    // Displays the rules of the game based on the selected mode.
    // Returns the number of tries the user has
    public static int displayRules(String mode){
        final int EASY_TRIES = 8;
        final int NORMAL_TRIES = 6;
        final int HARD_TRUES = 3;

        switch(mode){
            case "easy":
                System.out.println("Worlde - Guess the word in 8 tries\n");
                return EASY_TRIES;
            case "normal":
                System.out.println("Worlde - Guess the word in 6 tries\n");
                return NORMAL_TRIES;
            case "hard":
                System.out.println("Worlde - Guess the word in 3 tries\n");
                return HARD_TRUES;
            default:
                System.out.println("Default mode.");
                System.out.println("Worlde - Guess the word in 6 tries\n");
                return NORMAL_TRIES;
        }
    }
}