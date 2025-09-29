//Author information:
  //Author: Madeline Savoiu
  //Email: savoiu@csu.fullerton.edu

//Program information:
  //Program name: Tic-Tac-Toe
  //Programming language: Java
  //Files: testTicTacToe.java, ticTacToeFrame.java, ticTacToeAlgorithm.java, run.sh
  //Date project began:  2025-Sept-21
  //Date of last update: 2025-Sept-28
  //Status: Complete
  //Nice feature: Human player cannot select squares on the game board before the game begins and the computer makes its move.
  //Base test system: Linux system with Bash shell and openjdk-14-jdk.

//This module
//File name: ticTacToeFrame.java
//Compile : javac ticTacToeFrame.java
//Purpose: This class defines the user interface
//This module (class) is called from the testTicTacToe class.

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.*;

// For computer moves
import java.util.concurrent.ThreadLocalRandom;

public class ticTacToeFrame extends JFrame {
    // Variables to track game state
    private int[][] gameBoard = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    // -1 -> game not started, 0 -> no win, 1 -> human win, 2 -> computer win
    private int gameState = -1;
    // 1 -> human's turn, 2 -> computer's turn
    private int turn = 1; 

    // UI
    private JPanel programNamePanel = new JPanel();
        private JLabel programNameLabel = new JLabel("Tic Tac Toe programmed by Madeline Savoiu");

    private JPanel gameBoardPanel = new JPanel();
        private JButton[][] buttons = new JButton[3][3];


    private JPanel infoPanel = new JPanel(new BorderLayout());
        private JPanel textPanel = new JPanel();
            private JLabel instructionsLabel = new JLabel("<html>X = Human<br>O = Computer<br>Computer plays first<br>To play click on open space</html>");
            private JLabel winnerLabel = new JLabel("The winner is");

        private JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            private JButton clearButton = new JButton("Clear");
            private JButton beginButton = new JButton("Begin");
            private JButton exitButton = new JButton("Exit");

    // Game logic
    private void computerMove() {
        if (gameState != 0 || turn != 2) {
            return;
        }

        int randomRow = ThreadLocalRandom.current().nextInt(0, 3);
        int randomCol = ThreadLocalRandom.current().nextInt(0, 3);

        // Randomly generate until you land on an empty cell
        while (gameBoard[randomRow][randomCol] != 0) {
            randomRow = ThreadLocalRandom.current().nextInt(0, 3);
            randomCol = ThreadLocalRandom.current().nextInt(0, 3);
        }

        gameBoard[randomRow][randomCol] = 2;
        buttons[randomRow][randomCol].setText("O");
        buttons[randomRow][randomCol].setForeground(new Color(242, 5, 132));


        if (ticTacToeAlgorithm.computerWon(gameBoard)) {
            winnerLabel.setText("The winner is computer");
            gameState = 2;
        }
    }

    private void humanMove(int row, int col) {
        if (gameBoard[row][col] == 0 && gameState == 0) {

            gameBoard[row][col] = 1;
            buttons[row][col].setText("X");
            buttons[row][col].setForeground(new Color(37, 150, 190));

            if (ticTacToeAlgorithm.humanWon(gameBoard)) {
                winnerLabel.setText("The winner is human");
                gameState = 1;
            } else {
                turn = 2;
                computerMove();
            }
        }
    }

    private void resetGame() {
        gameState = -1;
        turn = 1;
        winnerLabel.setText("The winner is");

        // Reset board and button representation
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameBoard[r][c] = 0;
                buttons[r][c].setText("");
            }
        }
    }

    // Constructor
    public ticTacToeFrame() {

        super("Tic Tac Toe");

        setSize(300, 500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setTitle("Tic Tac Toe");

        programNamePanel.setBounds(0, 0, 300, 50);
        gameBoardPanel.setBounds(0, 50, 300, 300);
        infoPanel.setBounds(0, 350, 300, 100);


        // First panel     <==================================================================
        programNamePanel.setSize(300, 50);

        programNameLabel.setForeground(Color.WHITE);
        programNamePanel.add(programNameLabel);

        programNamePanel.setBackground(new Color(1, 180, 142));
        add(programNamePanel);

        // Second panel     <==================================================================
        gameBoardPanel.setPreferredSize(new Dimension(300, 300));
        gameBoardPanel.setLayout(new GridLayout(3, 3)); // Layout for tic-tac-toe
        gameBoardPanel.setBackground(new Color(1, 180, 142));

        // Add buttons
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c] = new JButton("");
                buttons[r][c].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[r][c].setBackground(Color.WHITE);

                final int row = r;
                final int col = c;

                buttons[r][c].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        humanMove(row, col);
                    }
                });

                gameBoardPanel.add(buttons[r][c]);
            }
        }

        add(gameBoardPanel);

        // Third panel     <==================================================================
        infoPanel.setSize(300, 150);
        infoPanel.setBackground(new Color(1, 180, 142));

        textPanel.setSize(150, 150);
        textPanel.setBackground(new Color(1, 180, 142));

        controlsPanel.setSize(150, 150);
        controlsPanel.setBackground(new Color(1, 180, 142));

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));

        instructionsLabel.setForeground(Color.WHITE);
        textPanel.add(instructionsLabel);

        winnerLabel.setForeground(Color.WHITE);
        textPanel.add(winnerLabel);

        // Buttons
        clearButton.setBackground(Color.WHITE);
        clearButton.setForeground(new Color(1, 180, 142));
        clearButton.addActionListener(event -> resetGame());
        controlsPanel.add(clearButton);

        beginButton.setBackground(Color.WHITE);
        beginButton.setForeground(new Color(1, 180, 142));
        beginButton.addActionListener(event -> {
            gameState = 0;
            turn = 2;
            computerMove();
        });
        controlsPanel.add(beginButton);

        exitButton.setForeground(new Color(1, 180, 142));
        exitButton.setBackground(Color.WHITE);
        exitButton.addActionListener(event -> System.exit(0));
        controlsPanel.add(exitButton);

        infoPanel.add(textPanel, BorderLayout.WEST);
        infoPanel.add(controlsPanel, BorderLayout.EAST);

        add(infoPanel);
    }
};
