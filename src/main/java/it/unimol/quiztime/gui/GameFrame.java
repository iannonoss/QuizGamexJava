package it.unimol.quiztime.gui;

import it.unimol.quiztime.handler.HandlerPlayer;
import it.unimol.quiztime.handler.HandlerQuiz;
import javax.swing.*;
import java.awt.*;



public class GameFrame extends JFrame {

    private final GameBoard gameBoard;


    public GameFrame(HandlerQuiz handlerQuiz, HandlerPlayer handlerPlayer) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(new Color(20,20,16));
        this.setLayout(null);
        this.setResizable(false);
        this.gameBoard = new GameBoard(this, handlerQuiz, handlerPlayer);
        this.add(gameBoard);

    }

}
