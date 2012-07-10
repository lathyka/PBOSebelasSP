
package org.me.cara.paling.simple;

import java.sql.*;


public class Data 
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        //pertama load drivernya
        Class.forName("com.mysql.jdbc.Driver");
        
        //KEdua adalah Ciptakan pipanya
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mahasiswa","root",null);
        
        
        //KEtika PErsiapakan Statement atau pernyataanmu
        
        Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
        String sql = "SELECT * FROM DATA WHERE NIM=1";
        
        
        //Eksekusi Statement tersebut
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next())
        {
             System.out.println("Data------\n Nim = "+rs.getInt(1)+ "\nNAma = "+rs.getString(2)+"\nAlamat = "+rs.getString(3)+"\n-------");
        }
//        rs.next();
//       
//       
//        rs.updateString(2,"AJI VErsi 2");
//        rs.updateRow();
//        rs.next();
//        System.out.println("Data------\n Nim = "+rs.getInt(1)+ "\nNAma = "+rs.getString(2)+"\nAlamat = "+rs.getString(3)+"\n-------");
//       // rs.beforeFirst();
        
        stmt.close();
        con.close();
    }
}
