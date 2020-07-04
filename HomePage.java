import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

//Driver class
public class HomePage extends JFrame implements ComponentListener, ChangeListener
{
	
	public static final int BOOKS_COUNT = 0;
	public static final int AUTHORS_COUNT = 1;
	public static final int AVERAGE_PRICE = 2;

	private String imgaddress = "/home/yassh/Desktop/SKY-Labs/book-logo-png-5.png"; // Path to logo
	private Vector registeredListeners = new Vector();
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel titlePanel = new JPanel(new GridLayout(2, 1));
	private JLabel statusLabel = new JLabel();
	private JLabel pictureLabel = new JLabel();
	private JLabel bookCoLabel = new JLabel("SKY Book Depot", JLabel.CENTER);	// Company label
	private JLabel salesSysLabel = new JLabel("SKY - Samarth Kishan Yassh", JLabel.CENTER);	// Subheading label
	private JTabbedPane theTab = new JTabbedPane(JTabbedPane.LEFT); // Tabbed pane towards left

	public HomePage()
	{
		super("SKY Book Management"); //Frame title

		addComponentListener(this);
		theTab.addChangeListener(this);

		setSize(780, 560);

		Container c = getContentPane();

		String currentFont = bookCoLabel.getFont().getName();
		bookCoLabel.setFont(new Font(currentFont, Font.BOLD, 26));
		salesSysLabel.setFont(new Font(currentFont, Font.PLAIN, 16));

		// set border on status bar label to make it look like a panel
		statusLabel.setBorder(new javax.swing.border.EtchedBorder());

		ImageIcon imageIcon = new ImageIcon(this.imgaddress); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(105, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back

		pictureLabel.setIcon(imageIcon);
		pictureLabel.setBorder(new javax.swing.border.EtchedBorder());

		titlePanel.add(bookCoLabel);
		titlePanel.add(salesSysLabel);
		topPanel.add(pictureLabel, "West");
		topPanel.add(titlePanel, "Center");

		HomeWelcomePanel welcomePanel = new HomeWelcomePanel(this);
		LoginPanel userLoginPanel = new LoginPanel(this, 'u');
		LoginPanel adminLoginPanel = new LoginPanel(this, 'a');
		RegisterPanel registerPanel = new RegisterPanel(this);

		theTab.add("Welcome", welcomePanel);
		theTab.add("User Login", userLoginPanel);
		theTab.add("Admin Login", adminLoginPanel);
		theTab.add("Register", registerPanel);

		theTab.addChangeListener(welcomePanel);
		theTab.setSelectedIndex(0);

		c.setLayout(new BorderLayout());
		c.add(topPanel, "North");
		c.add(theTab, "Center");
		c.add(statusLabel, "South");
	}

	public void addBookUpdateListener(Object listener)
	{
		if (!(listener == null))
			registeredListeners.add(listener);
	}

	public void componentHidden(ComponentEvent ev) {}

	public void componentMoved(ComponentEvent ev) {}

	public void componentResized(ComponentEvent ev)
	{
		if (this == ev.getComponent())
		{
			Dimension size = getSize();

			if (size.height < 530)
				size.height = 530;
			if (size.width < 675)
				size.width = 675;

			setSize(size);
		}
	}

	public void componentShown(ComponentEvent ev) {}

	public static void main(String[] args)
	{
		HomePage homePage = new HomePage();
		homePage.setVisible(true);
	}

    public void stateChanged(ChangeEvent ev)
	{
		if (ev.getSource() == theTab)
			statusLabel.setText("Current panel: " + theTab.getTitleAt(theTab.getSelectedIndex()));
	}

	class WindowCloser extends WindowAdapter
	{
		public void windowClosing(WindowEvent ev)
		{
			System.exit(0);
		}
	}
}