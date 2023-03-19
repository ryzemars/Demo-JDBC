package repository;

import utils.JDBC_Connect;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class GroupRepository {
    //static Connection connection = JDBC_Connect.getConnection();
    static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void createGroup() throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        connection.setAutoCommit(false);
        try {
            String myQuery = "INSERT INTO `group` (group_name, author_id, create_date)" + "VALUE (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(myQuery);

            System.out.println("Input group name: ");
            String grName = sc.next();
            System.out.println("Input group author id: ");
            int grAuthorId = sc.nextInt();
            System.out.println("Input group create date (YYYY/MM/DD): ");
            String grCreateDate = sc.next();

            preparedStatement.setString(1, grName);
            preparedStatement.setInt(2, grAuthorId);
            preparedStatement.setString(3, grCreateDate);

            preparedStatement.executeUpdate();

            connection.commit();
            System.out.println("Transaction Commit!");
            System.out.println("Successfully created new group ✅");
        } catch (Exception ex) {
            ex.printStackTrace();
            connection.rollback();
            System.out.println("Transaction Rollback!");
        }
        connection.setAutoCommit(true);
        connection.close();
    }

    public void updateGroup() throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        connection.setAutoCommit(false);
        try {
            String myQuery = "UPDATE `group` SET group_name = ? , author_id = ?, create_date = ? WHERE group_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(myQuery);
            System.out.println("Which group you want to update information? (id): ");
            short groupId = sc.nextShort();
            System.out.println("Input group name: ");
            String groupName = sc.next();
            System.out.println("Input group author id: ");
            int groupAuthorId = sc.nextInt();
            System.out.println("Input group create date (YYYY/MM/DD): ");
            String groupCreateDate = sc.next();
            preparedStatement.setString(1, groupName);
            preparedStatement.setInt(2, groupAuthorId);
            preparedStatement.setString(3, groupCreateDate);
            preparedStatement.setShort(4, groupId);
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("Transaction Commit!");
            System.out.println("Successfully updated to DB ✅");
        } catch (Exception ex) {
            ex.printStackTrace();
            connection.rollback();
            System.out.println("Transaction Rollback!");
        }
        connection.setAutoCommit(true);
        connection.close();
    }

    public void deleteGroup() throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "DELETE FROM `group` WHERE group_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.println("Input id of the group that you want to delete: ");
            int groupId = sc.nextInt();
            preparedStatement.setInt(1, groupId);
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println("Transaction Commit!");
            System.out.println("Group " + groupId + ": deleted ✅");
        } catch (Exception ex) {
            ex.printStackTrace();
            connection.rollback();
            System.out.println("Transaction Rollback!");
        }
        connection.setAutoCommit(true);
        connection.close();
    }

    public void getAllGroup() throws SQLException, IOException {
        Connection connection = JDBC_Connect.getConnection();
        connection.setAutoCommit(false);
        try {
            String sql = "SELECT * FROM `group`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet groups = preparedStatement.executeQuery();
            //Statement statement = connection.createStatement();
            //ResultSet groups = statement.executeQuery(sql);

            System.out.format("+----------------------------------------------------+%n");
            System.out.format("|                  GROUP INFORMATION                 |%n");
            System.out.format("+------+-------------------+---------+---------------+%n");
            System.out.format("|  ID  |    Group Name     | Author  |  Create Date  |%n");
            System.out.format("+------+-------------------+---------+---------------+%n");

            while (groups.next()) {
                int groupId = groups.getInt(1);
                String groupName = groups.getString(2);
                int groupAuthorId = groups.getInt("author_id");
                Date createDate = groups.getDate("create_date");
                //System.out.println("Account Id = " + groupId + ", Full name = " + groupName);
                System.out.format("|  %-3d |    %-10s     |    %-4d |  %-4s   |%n", groupId, groupName, groupAuthorId, createDate);
            }

            System.out.format("+------+-------------------+---------+---------------+%n");
        } catch (Exception ex) {
            ex.printStackTrace();
            connection.rollback();
            System.out.println("Transaction Rollback!");
        }
        connection.setAutoCommit(true);
        connection.close();
    }
}
