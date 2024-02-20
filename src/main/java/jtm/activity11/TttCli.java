package jtm.activity11;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Simple Tic-tac-toe game which works in command line
 * 
 * Both users should use the same the same terminal
 * 
 * Do not change this class!
 * 
 */
public class TttCli {
	private int size; // Size of one size of the board
	private char[] board; // board of the game
	private char move = '×'; // char for current move
	private Scanner scanner; // reader from the input stream
	private PrintWriter writer; // writer to the output stream

	public TttCli(InputStream input, OutputStream output, int size) {
		scanner = new Scanner(input);
		writer = new PrintWriter(output);
		if (size < 1)
			end();
		this.size = size;
		board = new char[size * size];
		for (int i = 0; i < size * size; i++)
			// if cells are more than 10, wrap numbers of cells only for last decimal digit
			board[i] = (char) ((i % 10) + '0');
	}

	/**
	 * Put move into place
	 * 
	 * @param place — cell of the board
	 * @return — true if valid move, false if invalid, exit if negative number
	 */
	private boolean put(int place) {
		if (place < 0)
			end();
		if (place < size * size && board[place] != '×' && board[place] != '○') {
			board[place] = move;
			toggleMove();
			return true;
		}
		return false;
	}

	/**
	 * Toggle pieces of moves
	 */
	private void toggleMove() {
		if (move == '×')
			move = '○';
		else
			move = '×';
	}

	/**
	 * Read typed number from standard input
	 * 
	 * @return — read number (may be negative)
	 */
	private int read() {
		write("Enter place:");
		return Integer.parseInt(scanner.next());
	}

	/**
	 * Write passed message to the standard output
	 * 
	 * @param message — message to be printed out
	 */
	private void write(String message) {
		writer.println(message);
		writer.flush();
	}

	/**
	 * Play game till there are moves or negative cell number is passed
	 */
	public void play() {
		int moves = 0;
		write(toString());
		while (moves < size * size) {
			if (put(read()))
				moves++;
			else
				write("Wrong move!");
			write(toString());
		}
		end();
	}

	/**
	 * Exit game
	 */
	private void end() {
		write("Game ended!");
		System.exit(0);
	}

	/**
	 * Return textual representation of the board
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				output.append(board[x + y * size]);
			}
			output.append('\n');
		}
		return output.toString();
	}

	/**
	 * Start the game as stand-alone java application
	 * 
	 * @param args — size of the board
	 */
	public static void main(String[] args) {
		int size = 3;
		if (args != null && args.length == 1)
			size = Integer.parseInt(args[0]);
		TttCli game = new TttCli(System.in, System.out, size);
		game.play();
	}

}
