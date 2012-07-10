
package org.me.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.me.database.connection.Koneksi;
import org.me.entity.Mahasiswa;

public class MahasiswaDao 
{
    
    public static List<Mahasiswa> getDataAllMahasiswa() throws ClassNotFoundException, SQLException
    {
        List<Mahasiswa> myList = new ArrayList<Mahasiswa>();
        
        Connection myKoneksi = Koneksi.getKoneksi();
        String queryku = "SELECT * FROM DATA";
        PreparedStatement psmt = myKoneksi.prepareStatement(queryku);
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            Mahasiswa m = new Mahasiswa();
            m.setNim(rs.getInt(1));
            m.setNama(rs.getString(2));
            m.setAlamat(rs.getString(3));
            myList.add(m);
        }
        
        psmt.close();
        Koneksi.tutupKoneksi(myKoneksi);
        
        
        
        return myList;
    }
    
    public static HashMap<Integer,Mahasiswa> getDataAllMahasiswaDalamHashMap() throws ClassNotFoundException, SQLException
    {
        HashMap<Integer,Mahasiswa> myHash = new HashMap<Integer,Mahasiswa>();
        
        Connection myKoneksi = Koneksi.getKoneksi();
        String queryku = "SELECT * FROM DATA";
        PreparedStatement psmt = myKoneksi.prepareStatement(queryku);
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            Mahasiswa m = new Mahasiswa();
            m.setNim(rs.getInt(1));
            m.setNama(rs.getString(2));
            m.setAlamat(rs.getString(3));
            myHash.put(new Integer(m.getNim()),m);
        }
        
        psmt.close();
        Koneksi.tutupKoneksi(myKoneksi);
        
        
        
        return myHash;
    }
    
   public static void insertDataMahasiswa(Mahasiswa mahasiswa) throws ClassNotFoundException, SQLException
   {
       Connection con = Koneksi.getKoneksi();
       String query = "INSERT INTO DATA VALUES(?,?,?)"; 
       PreparedStatement psmt = con.prepareStatement(query);
       psmt.setInt(1,0);
       psmt.setString(2,mahasiswa.getNama());
       psmt.setString(3, mahasiswa.getAlamat());
       
       int effect = psmt.executeUpdate();
       System.out.println("affek berjumlah = "+ effect);
       
       psmt.close();
       Koneksi.tutupKoneksi(con);
       
   }
   
   public static void insertListMahasiswa(List<Mahasiswa> myList) throws ClassNotFoundException, SQLException
   {
       Connection con  = Koneksi.getKoneksi();
       String query = "INSERT INTO DATA VALUES(?,?,?)"; 
       PreparedStatement psmt = con.prepareStatement(query);
       
       for(Mahasiswa m : myList)
       {
           psmt.setInt(1, 0);
           psmt.setString(2,m.getNama() );
           psmt.setString(3,m.getAlamat());
           psmt.addBatch();
       }
       psmt.executeBatch();
       psmt.clearBatch();
       psmt.close();
       Koneksi.tutupKoneksi(con);
       
   }
   
    public static void main(String[] args)
    {
        try {
            List<Mahasiswa> mAr = new LinkedList<Mahasiswa>();
            mAr.add(new Mahasiswa(0,"Yabes","buat baru"));
            mAr.add(new Mahasiswa(0, "natha", "Cianjur"));
             mAr.add(new Mahasiswa(0, "Salfa", "Pengalengan"));
             insertListMahasiswa(mAr);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
