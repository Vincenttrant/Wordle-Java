package Wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
// import Wordle.Functions;

public class Main{
    public static class colors{
        public static String RESET = "\u001B[0m";
        public static String BG_GREEN = "\u001b[42m";
        public static String BG_YELLOW = "\u001b[43m";
    }

    public static int randomNum(int sizeOfArray){
        Random rand = new Random();
        return rand.nextInt(1000) % sizeOfArray;
    }

    public static ArrayList<String> readFileIntoArray(String FileName){
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FileName))){
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.toLowerCase());
            }
        }
        catch(Exception e){
            System.out.println("File not found");
        }
        return words;
    }


    private static final int EASY_TRIES = 8;
    private static final int NORMAL_TRIES = 6;
    private static final int HARD_TRUES = 3;

    public static int displayRules(String mode){
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



    public static void main(String[] args) throws Exception{
        try (Scanner input = new Scanner(System.in)) {
            int i;

            String userGuess;
            String playAgain = "y";
            ArrayList<String> words = readFileIntoArray("Data/words.txt");

            while(playAgain.equalsIgnoreCase("y")){
                String wordToGuess = words.get(randomNum(words.size()));
//              System.out.println(wordToGuess);


                System.out.println("What mode would you like to play? (easy/normal/hard)");
                String mode = input.nextLine();
                System.out.println();
                int tries = displayRules(mode);

                for(i = 0; i < tries; i++){
                    System.out.print("Enter word: ");
                    userGuess = input.nextLine();

                    while(userGuess.length() != wordToGuess.length()){
                        System.out.print("Guess a 5 letter word: ");
                        userGuess = input.nextLine();
                    }

                    if(userGuess.equalsIgnoreCase(wordToGuess)){
                        System.out.println(colors.BG_GREEN + userGuess + colors.RESET);
                        System.out.println();
                        System.out.println("Congratulations you got it correct! Would you like to play again? (y/n)");
                        playAgain = input.nextLine();
                        System.out.println();
                        break;
                    }
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
                
                if(i == tries){
                    System.out.println("You ran out of tries. The word was: " + wordToGuess);
                    System.out.println("Would you like to play again? (y/n)");
                    playAgain = input.nextLine();
                    System.out.println();
                }
            }
        }
    }
}

