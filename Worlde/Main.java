package Wordle;

import java.util.ArrayList;
import java.util.Scanner;

// class to define colors for the terminal
class colors{
    public static String RESET = "\u001B[0m";
    public static String BG_GREEN = "\u001b[42m";
    public static String BG_YELLOW = "\u001b[43m";
}

// Main class to run the game logic
public class Main{
    public static void main(String[] args) throws Exception{
        try (Scanner input = new Scanner(System.in)) {
            int i;

            String userGuess;
            String playAgain = "y";

            // Reads the words from the file into an ArrayList
            ArrayList<String> listOfWords = Functions.readFileIntoArray("Data/words.txt");

            // Main game loop
            while(playAgain.equalsIgnoreCase("y")){

                // Displays the words that were previously used.
                Player.showUsedWords();

                // Gets a random word from the listOfWords
                String wordToGuess = listOfWords.get(Functions.randomNum(listOfWords.size()));
                Player.addUsedWord(wordToGuess);

                // Asks the user what mode they want to play
                System.out.println("What mode would you like to play? (easy/normal/hard)");
                String mode = input.nextLine();
                System.out.println();
                int tries = Functions.displayRules(mode);

                // Loop through the number of tries
                for(i = 0; i < tries; i++){
                    System.out.print("Enter word: ");
                    userGuess = input.nextLine();

                    // Checks if word is 5 letters long
                    while(userGuess.length() != wordToGuess.length()){
                        System.out.print("Guess a 5 letter word: ");
                        userGuess = input.nextLine();
                    }

                    // Checks if the user guessed the word
                    if(userGuess.equalsIgnoreCase(wordToGuess)){
                        System.out.println(colors.BG_GREEN + userGuess + colors.RESET +  "\n");
                        Player.increaseWinStreak();
                        System.out.println("Congratulations you got it correct! Would you like to play again? (y/n)");
                        playAgain = input.nextLine();
                        System.out.println();
                        break;
                    }

                    // Checks if the user guessed a letter in the word
                    else{
                        int j = 0;
                        char[] letters = userGuess.toCharArray();
                        for(char c : letters){
                            if(c == wordToGuess.charAt(j)){
                                System.out.print(colors.BG_GREEN + c + colors.RESET);
                            }
                            else if(wordToGuess.contains(Character.toString(c))){
                                System.out.print(colors.BG_YELLOW + c + colors.RESET);
                            }
                            else{
                                System.out.print(c+colors.RESET);
                            }
                            j++;
                        }
                        System.out.println("\n");
                    }
                }

                // Checks if the user ran out of tries
                if(i == tries){
                    System.out.println("Your win streak was: " + Player.getWinStreak() +  "\n");
                    Player.setWinStreak(0);
                    System.out.println("You ran out of tries. The word was: " + wordToGuess);
                    System.out.println("Would you like to play again? (y/n)");
                    playAgain = input.nextLine();
                    System.out.println();
                }

                // If the user doesn't want to play again, display the words used
                if(playAgain.equalsIgnoreCase("n")){
                    Player.showUsedWords();
                }
            }
            System.out.println("Thanks for playing!");
        }
    }
}

