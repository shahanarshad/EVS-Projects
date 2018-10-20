/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springapplication;

import javax.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Shahan
 */
public class Driver {
    //

    public static void main(String stg[]) {

        String[][] chessBoard = new String[8][8];

        try {
            Resource r = new ClassPathResource("applicationContext.xml");
            BeanFactory factory = new XmlBeanFactory(r);
            ChessGame chess = (ChessGame) factory.getBean("ChessGame");
            chess.setPlayer((Player) factory.getBean("Player"));

            chessBoard = chess.getPlayer().gameBoard(chessBoard);
            System.out.println("######################## Welcome To Chess##################### ");
            System.out.println("............................................................. ");
            chess.getPlayer().displayChessBoard(chessBoard);
            chess.userInput(chessBoard);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}//end of person class
