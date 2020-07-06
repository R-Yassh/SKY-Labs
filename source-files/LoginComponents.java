import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginComponents extends JPanel implements ComponentListener
{
	private JLabel usernameLabel = new JLabel("ID");
	private JLabel passwordLabel = new JLabel("Password");
	private JTextField usernameTextField = new JTextField();
	private JTextField passwordTextField = new JPasswordField();

	private final int divFactor = 27;

	// set up a new BookDetailComponents object and return a reference to the object which is a kind of panel
	public LoginComponents()
	{
		Insets currentInsets;
		GridBagConstraints gridBagConstraints;
		setLayout(new BorderLayout(0, 20));
		JPanel compPanel = new JPanel(new GridBagLayout());
		String currentFont = usernameLabel.getFont().getName();
		currentInsets =  new Insets(0, 10, 0, 30);

		usernameLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
        compPanel.add(usernameLabel, gridBagConstraints);

        passwordLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
        compPanel.add(passwordLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(usernameTextField, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(passwordTextField, gridBagConstraints);

		// this listens for resize events
		addComponentListener(this);
        add(compPanel, "North");
	}

	//TODO This code should rename the labels, but it isn't 
	public void changeLabel(char role){
		if(role == 'u')
			this.usernameLabel.setName("User ID");
        else if(role == 'a')
			this.usernameLabel.setName("Admin ID");
		else
            this.usernameLabel.setName("Error Page");
	}

	 // clear all the text fields
	public void clearTextFields()
	{
		usernameTextField.setText("");
		passwordTextField.setText("");
	}

	public void componentHidden(ComponentEvent ev) {}

	public void componentMoved(ComponentEvent ev) {}

	public void componentResized(ComponentEvent ev)
	{
		if (ev.getSource() == this)
		{
			int width = getWidth();

			if (width >= 0)
			{
				/** these text fields had to be resized manually. Using insets didn't work for
				smaller areas of the panel. */
				usernameTextField.setColumns(width / divFactor);
				passwordTextField.setColumns(width / divFactor);
			}
		}
	}

	public void componentShown(ComponentEvent ev){}

	public String getUsername()
	{
		return usernameTextField.getText();
	}

	public String getPassword()
	{
		return passwordTextField.getText();
	}

	public void setFocusUsername()
	{
		usernameTextField.grabFocus();
	}
}
