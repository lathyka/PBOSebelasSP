
package org.me.driver;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.me.database.dao.MahasiswaDao;
import org.me.entity.Mahasiswa;


public class Driver 
{
    public static void main(String[] args) 
    {
        try {
            //        List<Mahasiswa> myDataList = null;
            //        try {
            //             myDataList = MahasiswaDao.getDataAllMahasiswa();
            //        } catch (ClassNotFoundException ex) {
            //            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            //        } catch (SQLException ex) {
            //            System.out.println("MAsalah Query Database...");
            //        }
                    
            //        
            //        if(myDataList != null)
            //        {
            //            for(Mahasiswa mahasiswa : myDataList)
            //            {
            //                System.out.println(mahasiswa);
            //            }
            //        }
                    
           HashMap<Integer,Mahasiswa> myHash = MahasiswaDao.getDataAllMahasiswaDalamHashMap();
           
           for(Map.Entry<Integer,Mahasiswa> e : myHash.entrySet())
           {
               System.out.println("DATA DENGAN NIM  = "+ e.getKey().toString());
               System.out.println("-------------------------------------");
               System.out.println(e.getValue());
               System.out.println("---------------------------------------");
           }
           
        } 
         catch(CommunicationsException ce)
        {
            System.out.println("Sambungan terputus.............");
            
            try
            {
                Thread.sleep(4000);
            }
            catch(Exception e)
            {
            }
            main(null);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }
}
