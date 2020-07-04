import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterComponents extends JPanel implements ComponentListener
{
	private JLabel firstNameLabel = new JLabel("First Name");
	private JLabel lastNameLabel = new JLabel("Last Name");
	private JLabel roomNoLabel = new JLabel("Room Number");
	private JLabel phoneLabel = new JLabel("Phone Number");
	private JLabel studentIDLabel = new JLabel("Student ID");
	private JLabel createPasswordLabel = new JLabel("Create Password");
	private JLabel confirmPasswordLabel = new JLabel("Confirm Password");
	private JTextField firstNameTextField = new JTextField();
	private JTextField lastNameTextField = new JTextField();
	private JTextField roomNoTextField = new JTextField();
	private JTextField phoneTextField = new JTextField();
	private JTextField studentIDTextField = new JTextField();
	private JTextField createPasswordTextField = new JPasswordField();
	private JTextField confirmPasswordTextField = new JPasswordField();

	private Insets currentInsets =  new Insets(0, 10, 0, 30);
	private	GridBagConstraints gridBagConstraints;
	private JPanel compPanel = new JPanel(new GridBagLayout());
	private String currentFont = firstNameLabel.getFont().getName();

	private final int divFactor = 27;

	// set up a new BookDetailComponents object and return a reference to the object which is a kind of panel
	public RegisterComponents()
	{
		setLayout(new BorderLayout(0, 20));

		/*
		documentation on gridBagConstraint: 
		https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
		*/

		// following methos add the labels and textfields to the panel

		dispCompFirstName();
		dispCompLastName();
		dispCompRoomNo();
		dispCompPhone();
		dispCompStudentID();
		dispCompCreatePass();
		dispCompConfirmPass();

		// the textfield added from above methods are resized via method componentResized()

		// this listens for resize events
		addComponentListener(this);
        add(compPanel, "North");
	}

	public void dispCompFirstName(){
		firstNameLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
		compPanel.add(firstNameLabel, gridBagConstraints);
		
		gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(firstNameTextField, gridBagConstraints);
	}

	public void dispCompLastName(){
		lastNameLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
        compPanel.add(lastNameLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(lastNameTextField, gridBagConstraints);
	}

	public void dispCompRoomNo(){
		roomNoLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
        compPanel.add(roomNoLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(roomNoTextField, gridBagConstraints);
	}

	public void dispCompPhone(){
		phoneLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
        compPanel.add(phoneLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(phoneTextField, gridBagConstraints);
	}

	public void dispCompStudentID(){
		studentIDLabel.setFont(new Font(currentFont, Font.BOLD, 12));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
		compPanel.add(studentIDLabel, gridBagConstraints);
		
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(studentIDTextField, gridBagConstraints);
	}

	public void dispCompCreatePass(){
		createPasswordLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
        compPanel.add(createPasswordLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(createPasswordTextField, gridBagConstraints);
	}

	public void dispCompConfirmPass(){
		confirmPasswordLabel.setFont(new Font(currentFont, Font.BOLD, 12));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = currentInsets;
        compPanel.add(confirmPasswordLabel, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        compPanel.add(confirmPasswordTextField, gridBagConstraints);
	}

	 // clear all the text fields
	public void clearTextFields()
	{
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		roomNoTextField.setText("");
		phoneTextField.setText("");
		studentIDTextField.setText("");
		createPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}

	public void componentHidden(ComponentEvent ev) {}

	public void componentMoved(ComponentEvent ev) {}

	// resize text fields
	public void componentResized(ComponentEvent ev)
	{
		if (ev.getSource() == this)
		{
			int width = getWidth();

			if (width >= 0)
			{
				/** these text fields had to be resized manually. Using insets didn't work for
				smaller areas of the panel. */
				firstNameTextField.setColumns(width / divFactor);
				lastNameTextField.setColumns(width / divFactor);
				roomNoTextField.setColumns(width / divFactor);
				phoneTextField.setColumns(width / divFactor);
				studentIDTextField.setColumns(width / divFactor);
				createPasswordTextField.setColumns(width / divFactor);
				confirmPasswordTextField.setColumns(width / divFactor);
			}
		}
	}

	public void componentShown(ComponentEvent ev){}

	public void setFocusName(){
		firstNameTextField.grabFocus();
	}
}