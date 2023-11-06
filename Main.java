package Wordle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Wordle.Functions;

public class Main{
    public class colors{
        public static String RED_TEXT = "\u001B[31m";
        public static String YELLOW_TEXT = "\u001B[33m";
        public static String RESET = "\u001B[0m";
        public static String GREEN_TEXT = "\u001B[32m";
    }

    public static int randomNum(int sizeOfArray){
        Random rand = new Random();
        int randNum = rand.nextInt(1000) % sizeOfArray;
        return randNum;
    }
    
    public static ArrayList<String> readFileIntoArray(String FileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(FileName));
        String line;
        ArrayList<String> words = new ArrayList<>();
        while((line = reader.readLine()) != null){
            words.add(line);
        }
        reader.close();
        return words;
    }
    public static void displayRules(String mode){
        if(mode == "hard"){

        }
        else{
            System.out.println("Guess the word in 6 tries");
            System.out.println("Each guess must be a valid word.");
            System.out.println("The color of the letter will change to show how close your guess was to the word.");
            System.out.println("Examples:");
            System.out.println(colors.GREEN_TEXT+"W"+colors.RESET+"hile");
        }
    }



    public static void main(String[] args) throws Exception{
        try (Scanner input = new Scanner(System.in)) {
            int i;
            String userGuess;
            ArrayList<String> words = new ArrayList<>();
            words = Wordle.Functions.readFileIntoArray("words.txt");
            //words = readFileIntoArray("words.txt");
            String wordToGuess = words.get(randomNum(words.size()));
            displayRules("easy");
            for(i = 0; i < 6; i++){
                System.out.println("Enter word:");
                userGuess = input.nextLine();
                while(userGuess.length() > wordToGuess.length()){
                    System.out.println("Guess is too long, guess a 5 letter word");
                    userGuess = input.nextLine();
                }
                if(userGuess.equalsIgnoreCase(wordToGuess)){
                    System.out.println(colors.GREEN_TEXT + userGuess + colors.RESET);
                    System.out.println("Congratulations you got it correct! Would you like to play again?");
                    break;
                }
                else
                {
                    int j = 0;
                    char[] letters = userGuess.toCharArray();
                    for(char c : letters){
                        if(c == wordToGuess.charAt(j)){
                            System.out.print(colors.GREEN_TEXT+c+colors.RESET);
                        }
                        else if(wordToGuess.contains(Character.toString(c))){
                            System.out.print(colors.YELLOW_TEXT + c + colors.RESET);
                        }
                        else
                        {
                            System.out.print(colors.RED_TEXT+c+colors.RESET);
                        }
                        j++;
                    }
                    System.out.println();
                    }
                }
        }
        }
    }

