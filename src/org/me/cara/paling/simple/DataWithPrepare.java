
package org.me.cara.paling.simple;

import java.sql.*;


public class DataWithPrepare 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
         Class.forName("com.mysql.jdbc.Driver");
        
        //KEdua adalah Ciptakan pipanya
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mahasiswa","root",null);
        
        String sql = "SELECT * FROM DATA WHERE NIM = ? AND ALAMAT LIKE   ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1,1);
        psmt.setString(2,"%Da%");
        
        ResultSet rs = psmt.executeQuery();
        ResultSetMetaData rsm = rs.getMetaData();
        //System.out.println("KOlumnya berjumlah = "+rsm.getColumnCount());
        
        while(rs.next())
        {
            System.out.println("Nim = \t"+rs.getInt(1)+"\tNama :\t"+rs.getString(2)+"\tALamat :\t"+rs.getString(3));
        }
        //KEtika PErsiapakan Statement atau pernyataanmu
        
    }
}
