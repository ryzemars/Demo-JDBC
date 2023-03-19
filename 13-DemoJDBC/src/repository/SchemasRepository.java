package repository;

import utils.JDBC_Connect;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class SchemasRepository {
    //static Connection connection = JDBC_Connect.getConnection();
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void createTable() throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        System.out.println("Input new table name: ");
        String tableName = sc.next();

        //tham khao nhap so luong citificate bai tap 13
        System.out.println("Input number of columns: ");
        int numberOfColumn = sc.nextInt();
        String [] arrColumn = new String[numberOfColumn*2];
        for (int i = 0; i < numberOfColumn; i++) {
            System.out.println("Input column name: ");
            arrColumn[i] = sc.next();
            System.out.println("Input Column Datatype & constraint: ");
            arrColumn[i+1] = sc.next();
        }

        System.out.println("Input first column name: ");
        String firstColumnName = sc.next();

        System.out.println("Input first Column Datatype & constraint: ");
        String firstColumnDatatype = sc.next();

        System.out.println("Input second column name: ");
        String secondColumnName = sc.next();

        System.out.println("Input second Column Datatype & constraint: ");
        String secondColumnDatatype = sc.next();

        String sql = "CREATE TABLE `" + tableName +"` (" +
                firstColumnName + " " + firstColumnDatatype + "," +
                secondColumnName + " " + secondColumnDatatype + ");";

        Statement statement = connection.createStatement();
        System.out.println(sql);
        statement.executeUpdate(sql);
        System.out.println("Table " + tableName + ": created ✅");
        connection.close();
    }

    public void dropTable() throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        System.out.println("Input name of the table that you want to drop: ");
        String tableName = sc.next();
        String sql = "DROP TABLE IF EXISTS `" + tableName +"`";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        System.out.println("Table " + tableName + ": droped ✅");
        connection.close();
    }

    public void renameTable() throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        System.out.println("Input name of the table that you want to rename: ");
        String tableName = sc.next();
        System.out.println("Input new table name: ");
        String newName = sc.next();
        String sql = "ALTER TABLE `" + tableName + "`"
                +"RENAME TO " + newName;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
        System.out.println("New Table name: " + newName + " ✅");
        connection.close();
    }
}
