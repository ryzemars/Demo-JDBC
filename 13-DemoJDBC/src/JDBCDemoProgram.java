import repository.GroupRepository;
import repository.SchemasRepository;
import utils.JDBC_Connect;
import utils.ShowMenuUtils;

import java.io.IOException;
import java.sql.*;

public class JDBCDemoProgram {
    //static Connection connection = JDBC_Connect.getConnection();
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        GroupRepository gr = new GroupRepository();
        SchemasRepository sr = new SchemasRepository();
        ShowMenuUtils util = new ShowMenuUtils();
        while (true) {
            //Get group choice (from 1 → 5)
            int choice = util.getChoice();
            switch (choice) {
                //Add new group
                case 1: {
                    gr.createGroup();
                    break;
                }
                //Update group
                case 2: {
                    gr.updateGroup();
                    break;
                }
                //Delete group
                case 3: {
                    gr.deleteGroup();
                    break;
                }
                //Show group
                case 4: {
                    gr.getAllGroup();
                    break;
                }
                //Drop group
                case 5: {
                    sr.dropTable();
                    break;
                }
                case 6: {
                    sr.renameTable();
                    break;
                }
                case 7: {
                    sr.createTable();
                    break;
                }

                //Exit the program
                default: {
                    System.out.println("End the program!");
                    return;
                }
            }
        }
    }
}
