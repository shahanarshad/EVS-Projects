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
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author Shahan
 */
public class Player {

    private String playerType = new String();

    public void setplayerType(String playerType) {
        this.playerType = playerType;

    }//end of function

    public String getplayerType() {
        return this.playerType;

    }//end of function

    public void setMove(String[][] chessBoard, int xCurrent, int yCurrent, int xMove, int yMove) {
        chessBoard[xCurrent][yCurrent] = ".";
        if (getplayerType().contains("X")) {
            chessBoard[xMove][yMove] = "X";
        } else if (getplayerType().contains("Y")) {
            chessBoard[xMove][yMove] = "Y";
        }

        displayChessBoard(chessBoard);

    }//end of function
    
    public void displayChessBoard(String[][] chessBoard) {
        for (int iteratorX = 0; iteratorX < 8; iteratorX++) {
            for (int iteratorY = 0; iteratorY < 8; iteratorY++) {

                System.out.print(chessBoard[iteratorX][iteratorY]);
                if (iteratorY == 7) {
                    System.out.println("");
                }

            }

        }
        saveGame(chessBoard);

    }//end of function
    public void saveGame(String[][] chessBoard) {
        Properties prop = new Properties();
        String storeLocation = new String();
        int xIterator = 0, yIterator = 0;
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (String[] row : chessBoard) {
            sj.add(Arrays.toString(row));
        }
        storeLocation = sj.toString();
        OutputStream output = null;
        try {
            //  storeLocation=String.join("", roadMap);
            output = new FileOutputStream("SaveMove.properties");
            prop.setProperty("Status", storeLocation);
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } //end of catch
            } //end of output
        }//end of finally block

    }//end of saveGame
    
     public String[][] loadGame() {
        Properties prop = new Properties();
        int counter = 0;
        String store = new String();
        try {
            prop.load(new FileInputStream("SaveMove.properties"));
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(CreatePropertyFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           // Logger.getLogger(CreatePropertyFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[][] chessGame = new String[8][8];
        ArrayList obj = new ArrayList();
        store = prop.getProperty("Status");
        while (counter < store.length()) {
            //System.out.println("the character at:" + store.charAt(counter));
            if (store.charAt(counter) == 'X') {
                obj.add("X");
                // System.out.println("the character entered:" + store.charAt(counter));
            } else if (store.charAt(counter) == 'Y') {
                obj.add("Y");
                //System.out.println("the character entered:" + store.charAt(counter));
            } else if (store.charAt(counter) == '.') {
                obj.add(".");
                //System.out.println("the character entered:" + store.charAt(counter));
            }
            counter++;
        }
        counter = 0;
        for (int xIterator = 0; xIterator < 8; xIterator++) {
            for (int yIterator = 0; yIterator < 8; yIterator++) {
                chessGame[xIterator][yIterator] = obj.get(counter).toString();
                counter++;
            }
        }
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                System.out.print(chessGame[x][y]);
                if (y == 7) {
                    System.out.println("");
                }

            }
        }
        return chessGame;
    }//end of function
     
     public void gameMotion(String[][] chessBoard) {
        int xPos = 0, yPos = 0, xCurrentPos = 0, yCurrentPos = 0, commaIndex = 0;
        String input = new String();
        String commaInput = new String();
        String secondaryInput = new String();
        String thirdInput = new String();
        Scanner scan = new Scanner(System.in);
        String storeInput = new String();
        while (!storeInput.contains("Q")) {
            System.out.print("Which Player Do you want to Play with(Enter X or Y) or (press Q to quit): ");

            storeInput = scan.nextLine();
            secondaryInput = storeInput;
            if (secondaryInput.contains("X")) {
                System.out.print("Choose the piece of X player to move(seperated by ,):");
                secondaryInput = scan.nextLine();
                if (secondaryInput.contains(",")) {
                    commaIndex = secondaryInput.indexOf(',');
                    xCurrentPos = Integer.parseInt(secondaryInput.substring(0, commaIndex));
                    yCurrentPos = Integer.parseInt(secondaryInput.substring(commaIndex + 1));

                }
                System.out.print("Choose the location(seperated by ,):");
                commaInput = scan.nextLine();
                if (commaInput.contains(",")) {
                    commaIndex = commaInput.indexOf(',');
                    xPos = Integer.parseInt(commaInput.substring(0, commaIndex));
                    yPos = Integer.parseInt(commaInput.substring(commaIndex + 1));

                }
                if ((xPos <= 7) && (xPos >= 0) && (yPos <= 7) && (yPos >= 0) && (xCurrentPos <= 7) && (xCurrentPos >= 0) && (yCurrentPos <= 7) && (yCurrentPos >= 0)) {
                    setMove(chessBoard, xCurrentPos, yCurrentPos, xPos, yPos);
                } else {
                    System.out.println("Invalid Data entered. Game Ended!");
                    saveGame(chessBoard);
                }

            } else if (storeInput.contains("Y")) //for Input Y player
            {
                System.out.print("Choose the piece of Y player to move(seperated by ,):");
                thirdInput = scan.nextLine();
                if (thirdInput.contains(",")) {
                    commaIndex = thirdInput.indexOf(',');
                    xCurrentPos = Integer.parseInt(thirdInput.substring(0, commaIndex));
                    yCurrentPos = Integer.parseInt(thirdInput.substring(commaIndex + 1));

                }
                System.out.print("Choose the location(seperated by ,):");
                commaInput = scan.nextLine();
                if (commaInput.contains(",")) {
                    commaIndex = commaInput.indexOf(',');
                    xPos = Integer.parseInt(commaInput.substring(0, commaIndex));
                    yPos = Integer.parseInt(commaInput.substring(commaIndex + 1));

                }
                if ((xPos <= 7) && (xPos >= 0) && (yPos <= 7) && (yPos >= 0) && (xCurrentPos <= 7) && (xCurrentPos >= 0) && (yCurrentPos <= 7) && (yCurrentPos >= 0)) {
                    setMove(chessBoard, xCurrentPos, yCurrentPos, xPos, yPos);
                } else {
                    System.out.println("Invalid Data entered. Game Ended!");
                    saveGame(chessBoard);
                }

            } //end of else
        }//end of while
    }//end of gameMotion

    
    public String[][] gameBoard(String[][] chessBoard) {

        for (int iteratorX = 0; iteratorX < 8; iteratorX++) {
            for (int iteratorY = 0; iteratorY < 8; iteratorY++) {
                if ((iteratorX == 0) || (iteratorX == 1)) {
                    chessBoard[iteratorX][iteratorY] = "X";
                } else if ((iteratorX == 6) || (iteratorX == 7)) {
                    chessBoard[iteratorX][iteratorY] = "Y";
                } else {
                    chessBoard[iteratorX][iteratorY] = ".";
                }

            }

        }

        return chessBoard;
    }

    

    
}//end of class
