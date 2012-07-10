
package org.me.database.connection;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Koneksi 
{
    public static Connection getKoneksi() throws ClassNotFoundException, SQLException
    {
        Connection myConnection;
        Class.forName("com.mysql.jdbc.Driver");
        
        Properties myPro = new Properties();
        myPro.put("user","root");
        myPro.put("password","");
        myConnection = DriverManager.getConnection("jdbc:mysql://localhost/mahasiswa",myPro);
        
        return myConnection;
    }
    
    public static void tutupKoneksi(Connection myConnection) throws SQLException
    {
        myConnection.close();
    }
    
}
