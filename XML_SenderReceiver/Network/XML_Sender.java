package Network;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A simple Swing-based client for the sender client.
 * It has a main frame window that shows what was
 * sent to the server (listener).
 */
public class XML_Sender 
{

	private PrintWriter out;
	private JFrame frame = new JFrame("XML Sender (Client)");

	private GridBagLayout grid;
	private Container container;
	private GridBagConstraints gbConstraints = new GridBagConstraints();

	private JLabel datalabel1 = new JLabel("Full filepath of the file to be use to send data - use Get File Name button to select file:");
	private JLabel datalabel2 = new JLabel("Data sent to server (listener):");
	private JTextField dataField = new JTextField(50);
	private JTextArea messageArea = new JTextArea(8, 50);
	private JButton fileNameButton = new JButton();
	private JButton sendDataButton = new JButton();
	private JButton exitButton = new JButton();

	private File file;

	/**
	 * Runs the client application.
	 */
	public static void main(String[] args) throws Exception 
	{
		String serverAddress = "empty";
		String portNumber = "empty";
		String frameTitle = "XML Sender (Client)";
		
		// See if there were any arguments passed in
		// as later we will determine whether to use args passed in
		// or open a GUI to get address and port number
		// expect three args otherwise will prompt user for input
		if (args.length > 2) {
			serverAddress = args[0];
			portNumber = args[1];
			frameTitle = args[2];
		}

		// Configure to run component
		XML_Sender client = new XML_Sender();
		client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.frame.pack();
		client.frame.setVisible(true);
		
		client.frame.setTitle(frameTitle);
		
		client.connectToServer(serverAddress, portNumber);
	}

	/**
	 * Constructs the client by laying out the GUI and
	 * adds action listeners such as buttons.
	 */
	public XML_Sender() 
	{

		// Have opeing frame pop up other than upper left-hand corner
		frame.setLocation(100, 100);

		// Layout GUI
		grid = new GridBagLayout();
		container = frame.getContentPane();
		container.setLayout(grid);

		// Set the button names
		fileNameButton.setText("Get File Name");
		sendDataButton.setText("Send File Data");
		exitButton.setText("Exit");

		// Make messageArea and dataField non-edible
		messageArea.setEditable(false);
		dataField.setEditable(false);

		// Set constraints for when GUI is expanded
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.weightx = 1000;
		gbConstraints.weighty = 1;

		// Add datalabel1
		addComponent(datalabel1, 0, 0, 2, 1);

		// Add dataField 
		addComponent(dataField, 1, 0, 1, 1);

		// Add fileNameButton
		addComponent(fileNameButton, 1, 1, 1, 1);

		//Add datalabel2
		addComponent(datalabel2, 2, 0, 2, 1);

		// Add messageArea, scroll available
		addComponent(new JScrollPane(messageArea), 3, 0, 2, 1);

		// Add sendDataButton
		addComponent(sendDataButton, 4, 0, 1, 1);

		// Add exitButton
		addComponent(exitButton, 4, 1, 1, 1);

		// Add action listener for fileNameButton
		fileNameButton.addActionListener(new ActionListener() 
		{

			// Get the file name we are to open
			public void actionPerformed(ActionEvent e) {
				// Set the dataField box with the file name to open
				String fileName = getFileName() + "\n";

				dataField.setText(fileName);
				dataField.selectAll();

			}

		});

		// Add action listener for exitButton
		exitButton.addActionListener(new ActionListener() 
		{

			// User wants to exist program
			public void actionPerformed(ActionEvent e) 
			{
				// Exit program
				System.out.println("Goob-bye!");
				System.exit(0);
			}

		});

		// Add action listener for sendDataButton
		sendDataButton.addActionListener(new ActionListener() 
		{

			// User wants to send data to server/listener
			public void actionPerformed(ActionEvent e) 
			{
				String fileName = "";
				String content = "";

				// Get the dataField text that has the file name
				// Make sure the user pick a file
				if (file == null) {
					JOptionPane.showMessageDialog(frame,
							"You must select a file first before sending data!",
							"Missing File Name",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				else
				{
					fileName = file.getAbsolutePath();
				}

				// Get the file contents as one string
				try {
					content = readFile(fileName, Charset.defaultCharset());
				} catch (IOException e1) {
					// Could not read file
					e1.printStackTrace();
				}

				messageArea.setText("Sending to listener: \n" + content + "\n");

				// See if there is data to send
				if (content.length() < 1) {
					return;
				}

				// Send data to server (listener)                
				out.println(content);
			}

		});

	}

	static String readFile(String path, Charset encoding) 
			throws IOException 
	{
		String returnStr = "";
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		returnStr = new String(encoded, encoding);

		// Make sure that the return string is only from the
		// first opening "<" to the last closing ">"
		// to remove any bad misleading chars or extra empty
		// lines at the end of the file
		int firstBracketIndex = returnStr.indexOf("<");
		int lastBracketIndex = returnStr.lastIndexOf(">") + 1;

		// Make sure that the file read found our brackets
		// as user could have pick a bad file
		// and make sure there are brackets as may not be a XML file
		if ((firstBracketIndex == -1) || (lastBracketIndex == -1)) 
		{
			JOptionPane.showMessageDialog(null,
					path + "\nAppears to be a non-XML file, please check",
					"Bad Data File?",
					JOptionPane.ERROR_MESSAGE);
			return "";
		}
		returnStr = returnStr.substring(firstBracketIndex, lastBracketIndex);

		return returnStr;
	}


	// Places the component in the grid and determines how many rows
	// and columns the component is to stretch across
	private void addComponent(Component c, int row, int column, int width, int height) 
	{
		// set gridx and gridy - where to put component
		gbConstraints.gridx = column;
		gbConstraints.gridy = row;

		// set gridwidth and gridheight - how many rows and/or columns the component
		// is stretch across
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;

		// set constraints and add component to container
		grid.setConstraints(c, gbConstraints);
		container.add(c);

	}

	/**
	 * Implements the connection logic by prompting the end user for
	 * the server's IP address and port number. Then connects and sets up stream
	 * with the server (listener).
	 */
	public void connectToServer(String serverAddress, String portNumberStr) throws IOException 
	{
		int portNumber = 0;

		// If 'empty' is passed in then prompt user for server IP Address
		if (serverAddress == "empty") {

			// Get the server address from a dialog box.
			serverAddress = JOptionPane.showInputDialog(
					frame,
					"Enter IP Address of the Server/Listener (click on Cancel to exit):",
					"XML Sender (Client) Program - Get IP",
					JOptionPane.QUESTION_MESSAGE);

			if (serverAddress == null) 
			{
				System.out.println("Goob-bye!");
				System.exit(0);
			}
		}

		// If 'empty' is passed in then prompt user for the server port number
		if (portNumberStr == "empty") {

			// Get the server port number from a dialog box.
			portNumberStr = JOptionPane.showInputDialog(
					frame,
					"Enter port number of the Server/Listener (click on Cancel to exit):",
					"XML Sender (Client) Program - Get Port",
					JOptionPane.QUESTION_MESSAGE);

			if (portNumberStr == null) {
				System.out.println("Goob-bye!");
				System.exit(0);
			}
		}

		// Make sure good port # entered
		try 
		{
			portNumber = Integer.parseInt(portNumberStr);
		}
		catch (NumberFormatException e) {
			System.out.println(e);
			System.out.println("Invalid port number exiting this program!");
			System.exit(1);
		}

		// Make connection and initialize streams
		Socket socket = null;
		try 
		{
			socket = new Socket(serverAddress, portNumber);
			out = new PrintWriter(socket.getOutputStream(), true);
		}
		catch (IOException | IllegalArgumentException e) {
			System.out.println(e);
			System.out.println("Connection error or server/listener down - exiting this program!");
			System.exit(1);
		}

	}

	// Opens a file dialog and returns the file name
	// also sets global file parameter for later use 
	public String getFileName()
	{
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = fileChooser.showOpenDialog(frame);

		// See if user clicked on the Cancel button
		if (result == JFileChooser.CANCEL_OPTION)
			file = null;
		else
			file = fileChooser.getSelectedFile();

		// return the file name that was selected
		if (file != null) {
			return file.getAbsolutePath();
		}
		else
		{
			return "";
		}

	}
}
