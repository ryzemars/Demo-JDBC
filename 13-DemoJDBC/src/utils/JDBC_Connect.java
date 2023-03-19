package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC_Connect {
//    public static final String URL_DB = "jdbc:mysql://localhost:3306/Fsoft_Data_Sample_DatDQ14?autoReconnect=true&useSSL=false&characterEncoding=latin1";
//    public static final String USER_NAME = "root";
//    public static final String PASSWORD = "2020";
//    static PropertiesUtils propertiesUtils = new PropertiesUtils();
//
//    static String url = propertiesUtils.getPropertyByName("url");
//    static String username = propertiesUtils.getPropertyByName("username");
//    static String password = propertiesUtils.getPropertyByName("password");
//
//    public JDBC_Connect() throws IOException {
//    }
    public static Connection getConnection() throws IOException {
        /*Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\FPT\\Training Thu Viec\\1. Java Core\\Fsoft Training - Java Core Source Code\\DemoJDBC\\src\\resources\\database.properties"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");*/
        PropertiesUtils propertiesUtils = new PropertiesUtils();
        String url = propertiesUtils.getPropertyByName("url");
        String username = propertiesUtils.getPropertyByName("username");
        String password = propertiesUtils.getPropertyByName("password");
        //Class.forName("com.mysql.cj.jdbc.Driver"); //register the driver class with DriverManager
        Connection connection = null;
        try {
            // neu get duoc thi khai bao bien connection thong qua phuong thuc .getConnection
            connection = DriverManager.getConnection(url, username, password);
            //System.out.println("get connection success");
        } catch (Exception ex) {
            System.err.println(ex);
            // neu k get duoc connection thi show ra fail
            System.err.println("Fail get connection");
        }
        return connection;
    }
}
