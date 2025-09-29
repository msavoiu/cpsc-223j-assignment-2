#!/bin/bash

#Program name: Tic Tac Toe
#Author: Madeline Savoiu
#Email: savoiu@csu.fullerton.edu
#File name:  run.sh
#Preconditions:
#   1.  All source files are in one directory
#   2.  This file, run.sh, is in that same directory
#   3.  The shell is currently active in that same directory
#How to execute: Enter "sh run.sh" without the quotes.

echo Remove old byte-code files if any exist
rm *.class

echo View list of source files
ls -l *.java

echo Compile ticTacToeFrame.java and ticTacToeAlgorithm.java
javac ticTacToeFrame.java ticTacToeAlgorithm.java

# javac ticTacToeFrame.java

echo Compile testTicTacToe.java
javac testTicTacToe.java

echo Execute the tic-tac-toe program
java testTicTacToe

echo End of execution. Have a nice day.