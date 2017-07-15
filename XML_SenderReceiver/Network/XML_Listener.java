package Network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A server program which accepts inputs from clients.
 * When clients connect, a new thread is
 * started to handle incoming data for each client.
 * 
 * The program is runs in an infinite loop, so shutdown in platform
 * dependent.  If you ran it from a console window with the "java"
 * interpreter, Ctrl-C generally will shut it down.
 */
public class XML_Listener 
{
	/**
	 * Application method to run the server runs in an infinite loop
	 * listening on port that user inputs. When a connection is requested, it
	 * spawns a new thread to do the servicing and immediately returns
	 * to listening.  The server keeps a unique client number for each
	 * client that connects just to show interesting logging
	 * messages.  It is certainly not necessary to do this.
	 */
	public static void main(String[] args) throws Exception 
	{
		System.out.println("The Server (Listener) is running.");
		System.out.println("Enter Ctrl-C to exit!");
		int clientNumber = 0;
		int serverPortNumber = 0;
		String serverPortNumberStr = "";

		// See if a server port number was passed in
		// if not then open GUI to get server port number
		if (args.length > 0) {
			serverPortNumberStr = args[0];
		}
		else {

			// Get the server port number from a dialog box.
			JFrame frame = new JFrame("Server Port");
			serverPortNumberStr = JOptionPane.showInputDialog(
					frame,
					"No port number argument passed in - enter the port number that the Server (Listener) is to use:",
					"Enter Server Port Number",
					JOptionPane.QUESTION_MESSAGE);
		}

		// Make sure good port # entered
		try 
		{
			serverPortNumber = Integer.parseInt(serverPortNumberStr);
		}
		catch (NumberFormatException e) 
		{
			System.out.println(e);
			System.out.println("Invalid port number exiting this program!");
			System.exit(1);
		}

		// Tell user what port the server is using
		System.out.println("This server/listener is listening on port: " + serverPortNumberStr + "\n");

		// Wait for connections
		ServerSocket listener = new ServerSocket(serverPortNumber);
		try 
		{
			while (true)
			{
				new Listener(listener.accept(), clientNumber++).start();
			}
		} finally 
		{
			listener.close();
		}
	}

	/**
	 * A private thread to handle incoming data on incoming
	 * socket.  The client terminates from outside so we
	 * see error when they are gone.
	 */
	private static class Listener extends Thread 
	{
		private Socket socket;
		private int clientNumber;

		public Listener(Socket socket, int clientNumber) 
		{
			this.socket = socket;
			this.clientNumber = clientNumber;
			log("\nNew connection with client# " + clientNumber + " at " + socket + "\n");
		}

		/**
		 * run() - Services this thread's client.
		 * 
		 * NOTE: As the stream between the client and server never
		 * closes we will never get a "-1" for bytes read in.
		 * However, per "CI Message Agent" XML protocol the XML message
		 * must end with a "</XmlMessageTransfer>" element (tag) and that
		 * is the clue that this server (listener) has received a full
		 * XML message from a CI Message Agent.
		 * 
		 */
		public void run()
		{
			try 
			{

				byte[] bytes = new byte[1024];
				String result = "";
				int n = 0;

				// Get XML message and put into a byte array
				InputStream in = socket.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				// Get messages from the client forever, stream never closes,
				// and show the data received
				// So we loop through here forever waiting for incoming
				// messages
				while (true) {
					// Read in bytes until we see the "</XmlMessageTransfer>" tag
					while(true) {
						// The 'read' method blocks until input data is available, end of file is detected,
						// or an exception is thrown.
						n = in.read(bytes);
						baos.write(bytes,0,n);
						result = baos.toString();
						// See if we are to break out of this while loop
						if (result.contains("</XmlMessageTransfer>")){
							break;
						}

					}
					// Show result (incoming message)
					log("\nData in:\n" + result);

					/**
					 *
					 * At this point, call a method to process the message
					 * that you received.
					 *     processMessage(result);
					 *       - Schema check
					 *       - Take action
					 *
					 */

					// Reset the variables for next XML message
					baos.reset();
					result = "";
				}
			} catch (IOException | IndexOutOfBoundsException e) {
				log("\nError handling client# " + clientNumber + ": " + e);
				log("Client may have closed its connection to this server\\listener");
			} finally {
				try {
					socket.close();
				} catch (IOException e) {
					log("\nCouldn't close a socket, what's going on?");
				}
				log("Connection with client# " + clientNumber + " closed");
			}
		}

		/**
		 * Logs a simple message.  In this case we just write the
		 * message to the server applications standard output.
		 */
		private void log(String message) {
			System.out.println(message);
		}
	}

}
