package repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class ProcedureHandling {
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public static void callProcedureUpdateStudent(Connection connection) throws SQLException {
        String sql = "{CALL pro_UpdateStudent(?, ?, ?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);
        System.out.println("-----Update Student Information------");
        System.out.println("input student id: ");
        int studentId = sc.nextInt();
        System.out.println("input new student name: ");
        String newStudentName = sc.next();
        System.out.println("input new student address: ");
        String newStudentAddress = sc.next();
        //set parameter ↙
        callableStatement.setInt(1, studentId);

        callableStatement.setString(2, newStudentName);
        callableStatement.setString(3, newStudentAddress);
        //executeUpdate ↙
        callableStatement.executeUpdate();
        //System.out.println("Student ID = " + callableStatement.getInt(1) + "Student name = " + callableStatement.getString(2) + "Student address = " + callableStatement.getString(3));
    }

    public static void selectFunctionInsertProduct(Connection connection) throws SQLException {
        String sql = "{? = call func_insertProduct(?, ?)}";

        //Preparing a CallableStatement to call a function
        CallableStatement callableStatement = connection.prepareCall(sql);

        //Registering the out parameter of the function (return type)
        callableStatement.registerOutParameter(1, Types.INTEGER);

        //input the function paragram (using scanner)
        System.out.println("-----Insert new Product-----");

        System.out.println("input product name: ");
        String productName = sc.next();

        System.out.println("input prouduct master id: ");
        int productMasterId = sc.nextInt();
        //set parameter
//        callableStatement.setString("param_product_name", productName);
//        callableStatement.setInt("param_product_master_id", productMasterId);
//        callableStatement.setString("@sv_product_name", productName);
//        callableStatement.setInt("@sv_product_master_id", productMasterId);
        callableStatement.setString(2, productName);
        callableStatement.setInt(3, productMasterId);
        //execute update
        callableStatement.executeUpdate();
        //show information
        //System.out.println("Product ID = " + callableStatement.getInt(1) + "Product name = " + callableStatement.getString(2) + "Product master id = " + callableStatement.getInt(3));
    }
}
