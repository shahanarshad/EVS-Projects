/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shahan
 */
public class ChessGame {

    String[][] chessBoard = new String[8][8];
    private Player obj = new Player();

    public void setPlayer(Player obj) {
        this.obj = obj;

    }

    public Player getPlayer() {
        return this.obj;

    }

    void userInput(String[][] chessBoard) {

        try {
            Scanner scan = new Scanner(System.in);
            String checkInput = new String();
            while (!checkInput.contains("Q")) {
                System.out.print("Do you want to resume previous game or Play a new game(Press R for Resume OR N for new game OR Q for Quit: ");
                checkInput = scan.nextLine();
                if (checkInput.contains("N")) {  //To Play New Game
                    getPlayer().gameMotion(chessBoard);
                }//end of main if
                else if (checkInput.contains("R")) {
                    chessBoard = getPlayer().loadGame();
                    getPlayer().gameMotion(chessBoard);
                }
            }//end of loop
            System.out.println("Game Ended");
            // saveGame(chessBoard);
            System.exit(0);
        }//end of try
        catch (Exception e) {
            e.printStackTrace();
        }

    }//end of userInput Function 

    

}
