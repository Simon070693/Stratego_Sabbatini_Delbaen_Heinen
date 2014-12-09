package stratego;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class is the server class. It is responsible for communicating with the
 * client to get the moves the remote player wants to make and supply outputs to
 * the remote player
 * 
 * @author Delbaen Lionel
 * 
 */
public class Serveur {
	private ServerSocket socket;
	private Socket client;
	private OutputStream out;
	private InputStream in;

	public Serveur(int port) {
		try {
			// create a server socket on the specified port
			socket = new ServerSocket(port);
		
			// wait for incoming connections
			client = socket.accept();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnections();
			System.out.println("I hate all clients $#%@!");
		}
		
	}// end constructor

	/**
	 * This will close all open connections gracefully
	 */
	private void closeConnections() {
		try {
			out.close();
			in.close();
			client.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end method


	/**
	 * <code>public InputStream getSocketInputStream()</code>
	 * Returns the InputStream for reading in messages sent through this half of
	 * the socket.
	 * @return An InputStream belonging to the Socket enclosed by this class.
	 */
	public InputStream getSocketInputStream() {
		return in;
	}

	/**
	 * <code>public OutputStream getSocketOutputStream()</code>
	 * Returns the OutputStream for sending messages through this half of the
	 * socket.
	 * @return An OutputStream belonging to the Socket enclosed by this class.
	 */
	public OutputStream getSocketOutputStream() {
		return out;
	}

}// end class
