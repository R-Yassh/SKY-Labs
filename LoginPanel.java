import java.awt.event.*;
import javax.swing.*;

public class LoginPanel extends JPanel implements ActionListener
{
	private HomePage homePage;
	private JLabel headingLabel = new JLabel("Login Page");
	private JButton resetButton = new JButton("Reset");
	private JButton loginButton = new JButton("Login");
	private JPanel buttonPanel = new JPanel();
	private LoginComponents loginComponents = new LoginComponents();
    private LoginAuthentication authenticate = new LoginAuthentication();

	public LoginPanel(HomePage home, char role)
	{
		homePage = home;

		changeLabel(role); //TODO This code should rename the labels, but it isn't
		loginComponents.changeLabel(role); 	//TODO This code should rename the labels, but it isn't 

		resetButton.addActionListener(this);
		loginButton.addActionListener(this);
		headingLabel.setAlignmentX(0.5f);

		buttonPanel.add(resetButton);
		buttonPanel.add(loginButton);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(Box.createVerticalStrut(10));
		add(headingLabel);
		add(Box.createVerticalStrut(15));
		loginComponents.add(buttonPanel, "Center");
		add(loginComponents);
	}

	public void actionPerformed(ActionEvent ev)
	{
		if (ev.getSource() == resetButton)
			resetButtonClicked();
		else if (ev.getSource() == loginButton)
			loginButtonClicked();
	}

	//TODO This code should rename the labels, but it isn't
	public void changeLabel(char role){
        if(role == 'u')
			this.headingLabel.setName("User Login Page");
        else if(role == 'a')
			this.headingLabel.setName("Admin Login Page");
		else
            this.headingLabel.setName("Error Page");
	}

	private void resetButtonClicked()
	{
		loginComponents.clearTextFields();
	}

	private void loginButtonClicked()
	{
		String username = "";
		String password = "";
		boolean valid = false;
		try
		{
			/* retrieve all the values from the text field, and convert them into an appropriate
			format */
			username = loginComponents.getUsername().trim();
            password = loginComponents.getPassword().trim();
		}
		catch (Exception exp)
		{
			JOptionPane.showMessageDialog(homePage, "An unknown error has occured", "Invalid field", JOptionPane.ERROR_MESSAGE);
		}

        valid = authenticate.authLogin(username, password);

        if(valid) // if the authentication is successful
        {
            loginComponents.clearTextFields();
			loginComponents.setFocusUsername();
			//TODO
            JOptionPane.showMessageDialog(homePage, "User/Admin page is under connstruction.\nTill then, SKY is the limit... :)", "Login Successful, but...", JOptionPane.WARNING_MESSAGE);
        }
        else // invalid login combiation
            JOptionPane.showMessageDialog(homePage, "Username and Password combination is invalid. Please check again.", "Invalid login", JOptionPane.ERROR_MESSAGE);
	}
}