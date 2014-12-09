package stratego;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * <code>public class Client</code>
 * <p>
 * This class is responsible for returning an input and output stream from a given address and port.
 * </p>
 * 
 * @author Delbaen Lionel
 */
public class Client
{
	private OutputStream	out;
	private InputStream	 in;
	private Socket	     conn;
	private boolean	     goodConnection;
	
	/**
	 * <code>public Client(String address, int port)</code>
	 * <p>
	 * Constructs a Client object with the given address and port. Provides useful methods for
	 * managing the connection.
	 * </p>
	 * 
	 * @param address
	 *            - A String with the IP address or hostname to connect to.
	 * @param port
	 *            - An int of the port to connect to.
	 */
	public Client(String hostname, int port)
	{
		// Here, all the constructor needs to do is set up the socket.
		// Get the address (it can be a domain name or IP address) the user entered and port
		InetSocketAddress socketAddress = new InetSocketAddress(hostname, port);
		// Get the IP address that the user entered.
		InetAddress address = socketAddress.getAddress();
		// Make a new socket from that IP address and the port.
		goodConnection = true;
		try
		{
			conn = new Socket(address.getHostAddress(), socketAddress.getPort());
		}
		catch (UnknownHostException e)
		{
			goodConnection = false;
		}
		catch (IOException e)
		{
			goodConnection = false;
		}
		if (!goodConnection)
			return;
		try
		{
			in = conn.getInputStream();
			out = conn.getOutputStream();
		}
		catch (IOException e)
		{
			goodConnection = false;
		}
	}// end constructor
	

	
	/**
	 * <code>public boolean connected()</code>
	 * <p>
	 * Returns whether or not this socket is properly connected to the other player.
	 * </p>
	 * 
	 * @return True if both the input and output streams are still open. False otherwise.
	 */
	public boolean connected()
	{
		// In this case, conn may be null
		if (!goodConnection)
			return false;
		if (conn.isInputShutdown())
			return false;
		if (conn.isOutputShutdown())
			return false;
		return true;
	}
	
	/**
	 * <code>public InputStream getSocketInputStream()</code>
	 * <p>
	 * Returns the InputStream for reading in messages sent through this half of the socket.
	 * </p>
	 * 
	 * @return An InputStream belonging to the Socket enclosed by this class.
	 */
	public static InputStream getSocketInputStream()
	{
		return in;
	}
	
	/**
	 * <code>public OutputStream getSocketOutputStream()</code>
	 * <p>
	 * Returns the OutputStream for sending messages through this half of the socket.
	 * </p>
	 * 
	 * @return An OutputStream belonging to the Socket enclosed by this class.
	 */
	public OutputStream getSocketOutputStream()
	{
		return out;
	}
	
	/**
	 * <code>public Socket getSocket()</code>
	 * <p>
	 * Returns the Socket that is enclosed by this class.
	 * </p>
	 * 
	 * @return The Socket for use with more advanced methods than those provided here.
	 */
	public Socket getSocket()
	{
		return conn;
	}
	
	/**
	 * <code>public void closeSocket()</code>
	 * <p>
	 * Closes the socket and releases any system resources associated with it.
	 * </p>
	 */
	public void closeSocket()
	{
		try
		{
			in.close();
			out.close();
			conn.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}