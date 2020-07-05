import java.awt.event.*;
import java.sql.*;

// Class to connect with skyDB for executing queries
public class DBConnection implements ActionListener 
{
    private String jdbcUrl = "jdbc:mysql://localhost:3306/skyDB";
    private String username = "root";
    private String password = "***REMOVED***";

    private Connection conn=null;
	private Statement stmt=null;
    
    DBConnection()
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

    public int execQuery(String query){
        try{
            ResultSet rs = this.stmt.executeQuery(query);
            if(!rs.next())
            {
                throw new SQLException();
            }
            return rs.getInt(1);
        }
        catch(Exception ex)
        {
            return 0;
        }
    }

    public int countUsers(){
        String query = null;
        query = "SELECT count(userID) FROM skyDB.user";
        return execQuery(query);
    }

    public int countTxn(){
        String query = null;
        query = "SELECT count(borrowID) FROM skyDB.borrowlist";
        return execQuery(query);
    }

    public int countBooks(){
        String query = null;
        query = "SELECT count(isbn) FROM skyDB.bookdata";
        return execQuery(query);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("yaha bhi pahuch gya code");

    }
}
