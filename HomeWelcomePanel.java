import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

// Class to display home welcome panel
public class HomeWelcomePanel extends JPanel implements ChangeListener
{
	private HomePage homePage;
	private JLabel headingLabel = new JLabel("Welcome to the Book Management System", JLabel.CENTER);
	private JLabel booksLabel = new JLabel();
	private JLabel usersLabel = new JLabel();
	private JLabel totalActiveLabel = new JLabel();
	private JPanel statsPanel = new JPanel();
	private JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
	private DBConnection database = new DBConnection();

	public HomeWelcomePanel(HomePage home)
	{
		this.homePage = home;
		setLayout(new BorderLayout(0, 10));
		home.addBookUpdateListener(this);

		statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
		centerPanel.add(statsPanel);
		headingLabel.setBorder(new EmptyBorder(new Insets(10, 0, 0, 0)));

		updateStats();

		statsPanel.add(usersLabel);
		statsPanel.add(booksLabel);
		statsPanel.add(totalActiveLabel);
		statsPanel.add(Box.createVerticalStrut(20));
		
		add(headingLabel, "North");
		add(centerPanel, "Center");
	}

	public void stateChanged(ChangeEvent ev){}

	//fetches latest stats from database
	private void updateStats()
	{
		int books =  database.countBooks(); 
		int users = database.countUsers();
		int txn = database.countTxn();
		
		booksLabel.setText("Total number of books: " + String.valueOf(books));
		usersLabel.setText("Total number of users: " + String.valueOf(users));
		totalActiveLabel.setText("Total number of active transactions: " + String.valueOf(txn));
	}
}