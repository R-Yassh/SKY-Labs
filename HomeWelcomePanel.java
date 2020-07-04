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

	//update stats
	private void updateStats()
	{
		// TODO receive new statistics
		// int books = (int)homePage.getStatistics(HomePage.BOOKS_COUNT);
		// int users = (int)homePage.getStatistics(HomePage.AUTHORS_COUNT);
		// double avgPrice = Math.floor(homePage.getStatistics(HomePage.AVERAGE_PRICE) * 10 + 0.5) / 10;

		int books = 0, users = 0, txn = 0;
		booksLabel.setText("Total number of books: " + String.valueOf(books));
		usersLabel.setText("Total number of users: " + String.valueOf(users));
		totalActiveLabel.setText("Total number of active transactions: " + String.valueOf(txn));
	}
}