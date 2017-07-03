/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fishingchampion;

import byui.cit260.fishingChampion.model.Game;
import byui.cit260.fishingChampion.model.Player;
import byui.cit260.fishingChampion.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Keith Downing
 */
public class FishingChampion {
    
    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        FishingChampion.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        FishingChampion.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        FishingChampion.inFile = inFile;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        FishingChampion.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        FishingChampion.player = player;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
           FishingChampion.inFile = new BufferedReader(new InputStreamReader(System.in));
           FishingChampion.outFile = new PrintWriter(System.out, true);
           try {
               String filePath = "log.txt";
               FishingChampion.logFile = new PrintWriter(filePath);
           } catch (Exception e) {
               System.out.println("Exception: " + e.toString() +
                                  "\nCause: " + e.getCause() +
                                  "\nMessage: " + e.getMessage());
           }
           StartProgramView startProgramView = new StartProgramView();
           startProgramView.display();
       } catch (Throwable te) {
           System.out.println(te.getMessage());
           te.printStackTrace();
       } finally {
           try {
               if (FishingChampion.inFile != null)
                   FishingChampion.inFile.close();
               if (FishingChampion.outFile != null)
                   FishingChampion.outFile.close();
               if (FishingChampion.logFile != null)
                   FishingChampion.logFile.close();
           } catch (IOException ex) {
               System.out.println("Error closing files");
               return;
           }
       }
    }
    
}
