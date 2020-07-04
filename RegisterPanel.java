import java.awt.event.*;
import javax.swing.*;

public class RegisterPanel extends JPanel implements ActionListener
{
	private HomePage homePage;
	private JLabel headingLabel = new JLabel("Register as User");
	private JButton resetButton = new JButton("Reset");
	private JButton registerButton = new JButton("Register");
	private JPanel buttonPanel = new JPanel();
	private RegisterComponents regComp = new RegisterComponents();
	
	public RegisterPanel(HomePage home)
	{
		homePage = home;

		resetButton.addActionListener(this);
		registerButton.addActionListener(this);
		headingLabel.setAlignmentX(0.5f);

		buttonPanel.add(resetButton);
		buttonPanel.add(registerButton);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(Box.createVerticalStrut(10));
		add(headingLabel);
		add(Box.createVerticalStrut(15));
		regComp.add(buttonPanel, "Center");
		add(regComp);
	}

	public void actionPerformed(ActionEvent ev)
	{
		if (ev.getSource() == resetButton)
			resetButtonClicked();
		else if (ev.getSource() == registerButton)
			registerButtonClicked();
	}

	private void resetButtonClicked()
	{
		regComp.clearTextFields();
		regComp.setFocusName();
	}

	private void registerButtonClicked()
	{
		//TODO
		JOptionPane.showMessageDialog(homePage, "The response to this click is under construction.\nTill then, SKY is the limit... :)", "Redirect error", JOptionPane.WARNING_MESSAGE);
	}
}