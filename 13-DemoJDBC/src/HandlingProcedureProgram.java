import repository.ProcedureHandling;
import utils.JDBC_Connect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HandlingProcedureProgram {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = JDBC_Connect.getConnection();
        connection.setAutoCommit(false);
        try {
            //ProcedureHandling.callProcedureUpdateStudent(connection);
            ProcedureHandling.selectFunctionInsertProduct(connection);
            connection.commit();
            System.out.println("Transaction commit!");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Transaction rollback!");
        }
        connection.setAutoCommit(true);
        connection.close();
    }
}
