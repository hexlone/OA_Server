package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectSQL {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/myjava";
    private static String user = "root";
    private static String mypassword = "wl624528405wang";
    private static Connection connection = null;
    public  static Connection getConnection(){
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,mypassword);
            System.out.println("连接数据库成功");
        }catch (Exception e){
            System.out.println("连接数据库错误");
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            }catch (Exception e){

            }
        }
    }
    /**
     *
     */

}
