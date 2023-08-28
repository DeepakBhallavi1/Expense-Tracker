
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mconnection {
    
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    
    private static final String URL = "jdbc:mysql://localhost:3306/expensetracker";
    private static final String USER_NAME = "root";
    private static final String  PASSWORD = "Deepak2311@";      
     
    private static Connection con;
     
    public static Connection getConn(){
        try{
            if(con==null || con.isClosed()){
               Class.forName(DRIVER_CLASS);
               con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
     }
    
    public static void closeConn(){
        try{
            if(con!=null || !con.isClosed()){
                con.close();
            }
             
        }catch(SQLException ex){
            ex.printStackTrace();
        }
         
    }
}
