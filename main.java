package ticTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main {
	
	//two array lists to keep track of player and cpu positions..global
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
	
	// array to represent tic tac toe gameboard
	char [][] gameBoard = {{' ', '|', ' ', '|', ' '},
			{'-', '+', '-', '+', '-'}, 
			{' ', '|', ' ', '|', ' '}, 
			{'-', '+', '-', '+', '-'}, 
			{' ', '|', ' ', '|', ' '}};
	
	//prints the game board
	printGameBoard(gameBoard);
	
	/*prompts player to place piece
	stores player's and cpu positions in global arraylist
	checks valid position. a position not taken already
	if invalid prompts user/cpu to place again*/
	while(true) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter your placement 1-9: ");
		int playerPos = scan.nextInt();
		
		//checks player position
		while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
			System.out.println("Position taken! Enter a correct position");
			playerPos = scan.nextInt();
		}
		
		//prints players position
		System.out.println(playerPos);
		//places players positions
		placePiece(gameBoard, playerPos, "player");
		//randomizes cpu piece placement
		Random rand = new Random();
		int cpuPos = rand.nextInt(9) + 1;
		
		
		//checks valid cpu position
		
		while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPositions)) {
			System.out.println("Position taken! Enter a correct position CPU");
			cpuPos = rand.nextInt(9)+ 1;
		}
		//place cpu position
		placePiece(gameBoard, cpuPos, "cpu");
		//prints updated board
		printGameBoard(gameBoard);
		
		//variable to store checkWinner method
		String result = checkWinner();
		//prints out result if there is one
		System.out.println(result);
	
	}

}
	//method for gameBoard
	public static void printGameBoard(char[][] gameBoard) {
		for(char[] row : gameBoard) {
			for(char c : row) {
				System.out.print(c);
		}
				System.out.println();
	}
}	
	//method to place piece
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("player")) {
				symbol = 'X';
				playerPositions.add(pos);
			} else if(user.equals("cpu")) {
				symbol = '0';
				cpuPositions.add(pos);
			}
		//creates spaces 1-9 for tic tac toe board and placement in the	game board array
		switch(pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
	}
		
}
	//lists all possible winning outcomes by giving appropriate array indexes
	//also checks and returns  for winner and tie
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		List<List> win = new ArrayList<List>();
		win.add(topRow);
		win.add(midRow);
		win.add(botRow);
		win.add(leftCol);
		win.add(midCol);
		win.add(rightCol);
		win.add(cross1);
		win.add(cross2);
		
		for(List l : win) {
			if(playerPositions.containsAll(l)) {
				return "Congratulations! You Win!";
			}else if (cpuPositions.containsAll(l)) {
				return "CPU wins! Better Luck Next Time";
			}
						}
		if (playerPositions.size() + cpuPositions.size()== 9) {
			return "TIE!";

		}
		
		return "";
	}
	}