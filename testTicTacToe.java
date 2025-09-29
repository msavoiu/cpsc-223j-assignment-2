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
  //File name: testTicTacToe.java
  //Compile : javac testTicTacToe.java
  //Purpose: This is the top level module. This module activates the user interface.
  //Educational purpose of this testTicTacToe class:
    //   1. Opens the program and defines the components that will appear in the UI
    //   2. Sets the size of a UI.

import javax.swing.JFrame;

// Sets the size for the UI
public class testTicTacToe
{
    public static void main(String[] args)
    {
        // Constructor call
        ticTacToeFrame ui = new ticTacToeFrame();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ui.pack();

        ui.setVisible(true);
    }
}