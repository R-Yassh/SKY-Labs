import java.awt.event.*;
import java.sql.*;

// Class to connect with skyDB for authenticating login
public class LoginAuthentication implements ActionListener 
{
    private String jdbcUrl = "jdbc:mysql://localhost:3306/skyDB";
    private String username = "username";
    private String password = "password";

    private Connection conn=null;
	private Statement stmt=null;
    
    LoginAuthentication()
    {
		try
		{   
			Class.forName("com.mysql.cj.jdbc.Driver"); 
            this.conn = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Connection established");
            this.stmt = this.conn.createStatement();
        }
        catch(Exception e)
		{
			System.out.println("Connection error: " + e);
        }
    }

    public boolean authLogin(String login_id, String password){
        String query = null;
        query = "SELECT loginId, passkey FROM skyDB.loginauth WHERE loginID = '" + login_id + "' and passkey = '" + password + "'";
        try{
            ResultSet rs = this.stmt.executeQuery(query);
            if(!rs.next())
            {
                throw new SQLException();
            }
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("yaha bhi pahuch gya code");

    }
}
