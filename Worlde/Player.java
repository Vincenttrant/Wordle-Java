package Wordle;

import java.util.ArrayList;


// Class to hold the Player's information.
public class Player
{
    public static int winStreak;
    private static ArrayList<String> wordsUsed = new ArrayList<>();

// Win Streak functions.

    public static int getWinStreak()
    {
        return winStreak;
    }
    public static void increaseWinStreak()
    {
        winStreak++;
    }
    public static void setWinStreak(int i)
    {
        winStreak = i;
    }

    // Adds a word to the list of used words.
    public static void addUsedWord(String w)
    {
        wordsUsed.add(w);
    }

    // Gets the list of words used by the Player.
    public static void showUsedWords()
    {
        System.out.println("Words Used: ");
        for(int i = 0; i < wordsUsed.size(); i++)
        {
            System.out.println(wordsUsed.get(i));
        }
        System.out.println();
    }
}