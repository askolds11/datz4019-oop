package jtm.extra14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient implements Runnable {
	private static String host = "localhost"; // host to connect to
	// buffered readers from standard input and server socket stream
	private static BufferedReader stdin, srvin;
	private static PrintWriter srvout; // writer to server socket stream
	private static Socket server; // server socket
	private static Thread t; // thread for server message reader
	// use the same port number as port in src/resources/appplication.properties
	// file:
	static final int port = 7700;

	public static void main(String[] args) {
		// TODO create new socket to the server
		// add buffered reader to standard input
		// add print writer to socket's stream

			// TODO Use ChatClient constructor with server socket as a parameter
			// for constructor of a new thread, to asynchronously read messages
			// from the server. Then start this thread.
			// HINT:
			// If JUnit test fails with timeout, thats probably because it could not
			// read data from client (or server, if client didn't send data) in
			// timely manner.

			ChatClient sc; // reference to ChatClient for server message reader
							// thread

			// TODO read messages from standard input and send them
			// to server socket exit from loop and program, if exit or quit is
			// entered

			// TODO handle possible exceptions and exit with error status

			// TODO close all data streams
	}

	@Override
	public void run() {
		// TODO read messages in the loop sent from server socket
		// in this thread
		// TODO handle exceptions
	}

	public ChatClient(Socket server) {
		// TODO try to create buffered reader to passed server socket
		// TODO handle exceptions
	}

}
